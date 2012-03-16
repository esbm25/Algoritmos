#include <stdio.h>
#include <stdlib.h>
#include "listasimplesdescritor.h"

 struct tipo {
    int num;
    struct tipo* prox;
};

void criar(TLista* P){
    P->prim = NULL;
}
void destruir(TLista* P){
        if (P->prim != NULL)
        {
                destruir(P->prim->prox);
                free(P);
        }
}
int inserir (TLista* P, int elem)
{
    TLista* aux = ((TLista*)malloc(sizeof(TLista)));
         if (aux->prim != NULL){
             aux->prim->num = elem;
             aux->prim->prox = NULL;
             P->last = aux;
             return(0);
         }else{
             return(1);
         }
}
int remover(TLista* P, int elem){
    TLista* aux;
    TLista* ant;

    aux = P;
    while ( (aux->prim->prox != NULL) && (elem != aux->prim->num) ){
        ant = aux;
        aux = aux->prim->prox;
    }
     if ( aux->prim->num == elem){
        if (aux->prim->prox == NULL){
            free(aux);
            ant->prim->prox = NULL;
        }
    }
    else{
        return(1);
    }
    return(0);
}
int vazia (TLista* P){
    if (P->tam == 0){
        return(0);
    }else{
        return(1);
    }
}

