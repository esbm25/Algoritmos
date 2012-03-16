/*
 * main.c
 *
 *  Created on: Oct 1, 2010
 *      Author: mauricio
 */

#include <stdio.h>
#include <stdlib.h>
#include <time.h>


#define ERRO_PARAMETROS -1
#define ERRO_ARQUIVO1 -2
#define ERRO_ARQUIVO2 -3
#define Max 10

void Leia(FILE *f, int *p, int N)
{
	int i ;
	for (i = 0; i < N ; i++ )
		fscanf(f,"%d", &p[i]);

}

void geraDados( FILE *f, int N )
{
	int i, valor ;
	for (i = 0; i < N; i++){
	    	valor = rand()%(Max+ 1);
 		fprintf(f,"%d\t",valor );
		//printf("(%d) -> %d\n",i,valor);
	}

}


/**
 *  Autor: Mauricio Pereira
 *  Programa para gerar um conjunto de dados aleatórios
 *  Parametro 1 : Nome do arquivo
 *  Parametro 2 : Quantidade de dados
 *
 */

int main (int argc , char *argv[])
{
	FILE *f	, *f2;
	int i ;
	double total;
	int N ;


	if ( argc < 4 )
	{
		printf("Você deve fornecer os nomes dos arquivos como parâmetro e quantidade de dados\n") ;
		printf("Exemplo:\n%s dados1.txt dados2.txt 1000\n", argv[0]);
		return ERRO_PARAMETROS;
	}
	else
	{
	N = atoi(argv[3]);
	f = fopen(argv[1], "w");
	printf("Iniciando geração de valores aleatórios\n");
	srand(time(NULL));
	printf("Criando %d valores entre 0 e %d\n",N, Max );
	if ( f != NULL )
	{
		geraDados(f,N);
		//printf("Arquivo de dados %s gerado com sucesso\n ", argv[1]);
		fflush(f);
		fclose(f);

	}
	else {
		printf("Falha ao criar o arquivo %s", argv[1]);
		return ERRO_ARQUIVO1;
	}

	f = fopen(argv[2], "w");
	if ( f != NULL ){
		geraDados(f,N);
		//printf("Arquivo de dados %s gerado com sucesso \n", argv[2]);
		fflush(f);
		fclose(f);

	}
	else
	{
		printf("Falha ao criar arquivo %s\n", argv[2]);
		return ERRO_ARQUIVO2;
	}



	/** realizando teste do arquivo para apresentação dos resultados*/
	f = fopen(argv[1], "r");
	f2 = fopen(argv[2], "r");
	int *p1 = NULL, *p2=NULL;
	p1 = (int*) malloc(sizeof(int)* N);
	p2 = (int*) malloc(sizeof(int)* N);

	if (( f != NULL ) && (f2 != NULL))
	{
		Leia(f, p1, N);
		Leia(f2, p2, N);

		total = 0;

		for (i = 0 ; i < N ; i++)
			total += p1[i]*p2[i];
		printf("Resultado obtidos dos arquivos %s e %s \n", argv[1], argv[2]);
		printf("Total de elementos: %d\nValores entre 0 e %d\n",N, Max );
		printf("Conjunto de dados contendo %d elementos\n", N);
		printf("Produto escalar dos dados igual a %.0lf\n", total);
		free(p1);
		free(p2);

	}
	return 0 ;
	}
}
