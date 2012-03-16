/*
*  <A revolta do clone> is a  <Software calcular o produto cartesiano de dois vetor de entrada >
*  Copyright (C) 2010 Gustavo Liberatti <liberatti.gustvo@gmail.com>
*		      Rodicrisller Rodrigues <rodi_67@gmail.com>
		      Guilherme W. dos Santos Lopes <gwslopes@gmail.com> 
*  This program is free software; you can redistribute it and/or modify
*  it under the terms of the GNU General Public License as published by
*  the Free Software Foundation; either version 2, or (at your option)
*  any later version.
*
*  This program is distributed in the hope that it will be useful,
*  but WITHOUT ANY WARRANTY; without even the implied warranty of
*  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*  GNU General Public License for more details.
*
*  You should have received a copy of the GNU General Public License
*  along with this program; if not, write to the Free Software
*  Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
*
*/

#include "mpi.h"
#include <stdio.h>
#include <string.h>

// Variável globa que ajusta as dimensões do arquivo e do vetor
int SIZE;

// Variável para limpar o concole de comando para as plataformas WIN32 e LINUX
void clear(){
	//Diretiva de compilação para limpar a tela
	#ifdef WIN32
		system("cls");
	#else
		system("clear");
	#endif
}
void imprimirMenu(){
	clear();
	printf("Desenvolvido pelos alunos: Rodicrisller Rodrigues," );
	printf(	"Gustavo Liberatti\n Guilherme W. dos Santos Lopes\n");
	printf("--------------------------------------------------------------------------------------------\n\n");
}

//Função que carrega um arquivo alfanumérico contendo apenas numeros e insere em um vetor de tamanho compativel com o parametro
// fornecido na linha de comando.
int load(char* file,int *data){
	FILE *fp;
	if( NULL == (fp = fopen(file, "r")) ) {
		printf("Falha ao carregar arquivo: %s\n\n", file);
		return 1;
	}
	// variável que irá receber a linha lida do arquivo
	char line[255];
	int i=0;
	  while (!feof(fp) && i < SIZE)  
	 {    	
		fscanf(fp, "%s", line);
		data[i]=atoi(line); // Converte String obtida junto ao arquivo e adiciona na proxima posição do vetor
		i++;
	}
	printf("%d Valores carregados do arquivo: %s\n",i,file);
}
int main(int argc, char **argv){
	int myid; 					// Indica o rank do processo
	int numprocs; 				//Utilizada para indicar o numero de processos disponíveis
	int mymax=0, max;			// Variáveis utilizadas para calcular o Maximo contido no vetor principal data
	int *dataA; 					// Vetor principal contendo todos os valores do obtidos no arquivo
	int *dataB; 

	int *sendBufA;			// Vetor auxiliar com tamanho definido por x, utilizado para segmentar
	int *sendBufB;				// o vetor principal na comunicação com os demais processos
	
	int myresult=0, result; 	// Variávei utilizadas para calcular a soma de parciais e totais

	int i,j, x, low, high;		// Variáveis auxiliares para laço e segmentação
	double tempoI, tempoF;		//Variáveis para calcular o tempo de processamento
	
	// Efetua a validação dos parametros de entrada da linha de comando
	if(!(argc < 3)){
		SIZE=atoi(argv[3]);
		if(SIZE < 0){			// O valor informado é inválido
			clear();
			printf("ERRO - Informe um numero válido para quantidade !\n");
			return 1;
		}
	}else{						//Faltam parametros de entrada para o programa
		clear();
		printf("ERRO - Informe o caminho do arquivo de entrada e a quantidade de elementos a serem computados !\n");
		return 1;
	}

	// Aloca vetor com tamanho informado por linha de comando
	dataA = (int*) malloc(sizeof(int)*SIZE);
	dataB = (int*) malloc(sizeof(int)*SIZE);

	// Inicia ambiente MPI para a aplicação
	MPI_Status Stat;
	MPI_Init(&argc, &argv);
	MPI_Comm_size(MPI_COMM_WORLD, &numprocs);
	MPI_Comm_rank(MPI_COMM_WORLD, &myid);

	// Calcula tamanho para cada partição do vetor principal
	x = SIZE/(numprocs -1);
	sendBufA = (int*) malloc(sizeof(int)*x);
	sendBufB = (int*) malloc(sizeof(int)*x);
	// Processo MASTER, efetua a distriuição de tarefas e calcula valores resultantes que não puderam 
	// ser dividos entre os processos.
	if(myid == 0){
		imprimirMenu();
		tempoI=MPI_Wtime();		//Coleta o tempo de inicio do processamento	
		printf("Métodos--------------------------------------------------------------------------------\n\n");
		load(argv[1],dataA);
		load(argv[2],dataB);
		printf("O vetor original foi divido em Segmentos de %d elementos distribuídos para %d processos\n",x,(numprocs -1));
		printf("--------------------------------------------------------------------------------------------\n\n");
		int j,k;
		for(i=1;i<numprocs;i++){
			low = (i-1) * x;
			high = low + x;
			k=0;
			// Gera vetor com dados segmentados do vetor original das posições low até high -1
			for(j=low; j<high; j++) {
				sendBufA[k] = dataA[j];
				sendBufB[k] = dataB[j];
				k++;
			}
			// Envia vetor para processo i SLAVE, não sendo possivel enviar para o processo MASTER
			MPI_Send(sendBufA, x, MPI_INT, i , 0, MPI_COMM_WORLD);
			MPI_Send(sendBufB, x, MPI_INT, i , 0, MPI_COMM_WORLD);
		}
	}
	// Todos os processos SLAVE executam este condicional
	if(myid !=0){
		MPI_Recv(sendBufA, x, MPI_INT, 0, 0, MPI_COMM_WORLD, &Stat);
		MPI_Recv(sendBufB, x, MPI_INT, 0, 0, MPI_COMM_WORLD, &Stat);
		for(i=0; i<x; i++) {
			myresult += sendBufA[i] * sendBufB[i];		// Efetua a soma parcial
		}
	}
	// Faz a junção de todas as somas
	MPI_Reduce(&myresult, &result, 1, MPI_INT, MPI_SUM, 0, MPI_COMM_WORLD);
	if(0 == myid) {
		do{
			result+=dataA[high]*dataB[high];
			high++;
		}while(high < SIZE);
		// Informa o resultado final na tela do console
		printf("Resultados----------------------------------------------------------------------------------\n\n");
		printf("Resultado do produto escalar: %d.\n ", result);
		printf("--------------------------------------------------------------------------------------------\n");
		tempoF = MPI_Wtime();
		printf("Tempo gasto: %lf\n", tempoF - tempoI );
		printf("--------------------------------------------------------------------------------------------\n");
	}
	MPI_Finalize();		//Finaliza o Ambiente MPI
	return 0;			// Finaliza a aplição
}
