/* 
 * File:   main.c
 * Author: Gustavo Liberatti
 *
 * Created on 26 de Janeiro de 2002, 12:50
 */
#include <stdio.h>
#include <stdlib.h>
#include </home/gaiia/Desktop/TLista/listasimplesdescritor.h>

/* 
 * 
 */
int main() {

TLista* P;

P = NULL;
inserir(&P,5);

if ( (vazia(&P)) != 0){
    printf("Insere sucesso");
}
    return (EXIT_SUCCESS);
}

