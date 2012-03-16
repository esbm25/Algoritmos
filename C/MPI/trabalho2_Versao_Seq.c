/*
*  <Soma de Matriz Seq> is a   <Software para soma de matrizes >
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
#include <stdio.h>
#include <time.h> 

int *MatrizA, *MatrizB;
int MAX = 0;

void imprimeMatriz(int *matriz){
	int l,c;
	for(l=0;l<MAX;l++){
		for(c=0;c<MAX-1;c++){
			printf("|%d|",matriz[l*MAX + c]);
		}	
		printf("\n");
	}
	printf("\n");
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
	  while (!feof(fp) && i < MAX*MAX)  
	 {    	
		fscanf(fp, "%s", line);
		data[i]=atoi(line); // Converte String obtida junto ao arquivo e adiciona na proxima posição do vetor
		i++;
	}
	printf("%d Valores carregados do arquivo: %s\n",i,file);
}

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
	printf("Desenvolvido pelos alunos: Rodicrisller Rodrigues,\nGuilherme W. dos Santos Lopes\n" );
	printf(	"Gustavo Liberatti, \n");
	printf("-------------------------------------------------------------------\n\n");
	
}

int main(int argc,char *argv[])  {
	int i;
	time_t ini = time(0); // tempo de inicio
	imprimirMenu();
	// Efetua a validação dos parametros de entrada da linha de comando
	if(!(argc < 3)){
		MAX = atoi(argv[3]) ;
		if(MAX < 0){			// O valor informado é inválido
			clear();
			printf("ERRO - Informe um numero válido para quantidade !\n");
			return 1;
		}
	}else{						//Faltam parametros de entrada para o programa
		clear();
		printf("ERRO - Informe o caminho do arquivo de entrada e a quantidade de elementos a serem computados !\n");
		return 1;
	}	

	MatrizA = (int*) malloc(sizeof(int) * MAX * MAX);
	MatrizB = (int*) malloc(sizeof(int) * MAX * MAX);
	
	printf("Métodos--------------------------------------------------------------------------------------\n\n");
	load(argv[1],MatrizA);		// Carrega matriz A
	load(argv[2],MatrizB);		// Carrega matriz B

	printf("--------------------------------------------------------------------------------------------\n");
	printf("Matriz de Entrada A \n");
	imprimeMatriz(MatrizA);
	printf("Matriz de Entrada B \n");
	imprimeMatriz(MatrizB);
	printf("--------------------------------------------------------------------------------------------\n");

	for(i=0;i<=((MAX*MAX ) -1);i++){
		MatrizA[i]=MatrizA[i] + MatrizB[i];
	}	

	printf("Resultados----------------------------------------------------------------------------------\n\n");
	printf("Matriz Resultante --------------------------------------------------------------------------\n");
	imprimeMatriz(MatrizA);
	printf("--------------------------------------------------------------------------------------------\n");
	printf("tempo gasto: %lf\n\n", time(0)-ini );
	printf("--------------------------------------------------------------------------------------------\n\n");	
	return 0;
}
