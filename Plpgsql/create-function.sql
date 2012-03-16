CREATE FUNCTION (cod integer) RETURNS VARCHAR AS $$

DECLARE

	aux VARCHAR;
BEGIN

	SELECT nome 
	INTO aux
	From Cliente C
	WHERE C.cod = $1;

RETURN aux;

END; $$ LANGUAGE plpgsql;

Obs.: $1 representa o primeiro parametro recebido.
