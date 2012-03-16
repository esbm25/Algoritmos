----Cria TRIGGER que valida um campo -------------------------------------

CREATE OR REPLACE FUNCTION cruTrigger() RETURNS TRIGGER AS $$
BEGIN

IF (NEW.cru < 0)THEN
RAISE EXCEPTION 'O Valor CRU não pode ser negativo';
END IF;
RETURN NEW;
END;$$ language plpgsql;


CREATE TRIGGER insertCru BEFORE INSERT or UPDATE ON aluno FOR EACH ROW
EXECUTE PROCEDURE cruTrigger();

INSERT INTO aluno (rga,nome,tipo,cru) VALUES ('2000011','000010011','10','1');

 --------------------------------------------------------------------

CCREATE OR REPLACE FUNCTION confereNome() RETURNS TRIGGER AS $$
 DECLARE
      nome varchar;
      cursor1 CURSOR FOR SELECT nome FROM aluno;


BEGIN
   open cursor1;
   LOOP FETCH cursor1 INTO nome;
      IF NEW.nome = nome THEN
         RAISE EXCEPTION 'O Nome ja existe no Sistema';
      END IF;
   END LOOP;
   close cursor1;
   RETURN NEW;
END;$$ language plpgsql;

CREATE TRIGGER confereNome BEFORE INSERT ON aluno FOR EACH ROW
EXECUTE PROCEDURE conferenome();

PROCEDURE validaIdade();
