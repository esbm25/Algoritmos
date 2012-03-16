  
CREATE FUNCTION cursor() RETURNS VOID AS $$
  DECLARE
      alu varchar;
      cursor1 CURSOR FOR SELECT nome FROM aluno;
      cont integer;

BEGIN
   cont = 0;
   open cursor1;
   LOOP FETCH cursor1 INTO alu;
      IF NOT FOUND THEN
         EXIT;
      END IF;
   cont = cont + 1;
   RAISE NOTICE 'Na tupla % está o Aluno %', cont, alu;
   END LOOP;
   close cursor1;
   RETURN;
END;


--------------------------------------------------------

   DECLARE
      alu aluno%ROWTYPE;
      cursor1 CURSOR FOR SELECT * FROM aluno;
      cont integer;

BEGIN
   cont = 0;
   open cursor1;
   LOOP FETCH cursor1 INTO alu;
      IF NOT FOUND THEN
         EXIT;
      END IF;
      cont = cont + 1;
      IF n == cont THEN
         RETURN alu;
      END IF;
   END LOOP;
   close cursor1;
END;

