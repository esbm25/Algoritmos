#include <stdio.h>
#include <stdlib.h>
#include "/home/gaiia/Desktop/TLista/listasimples.h"

 struct lista {
    int num;
    struct lista* prox;
};

void criar(TLista* P){
    P = NULL;
}
void destruir(TLista* P){
        if (P != NULL)
        {
                destruir(P->prox);
                free(P);
        }
}
int inserir (TLista* P, int elem)
{
    TLista* aux;
     aux = P;

        if (aux == NULL )
        {
                aux = ((TLista*)malloc(sizeof(TLista)));
                if (aux != NULL){
                   aux->num = elem;
                   aux->prox = NULL;
                   P = aux;
                   return(0);
                }else{
                    return(1);
                }
        }
        else{
                return(inserir(P->prox,elem));
        }
}
int remover(TLista* P, int elem){
    TLista* aux;
    TLista* ant;

    aux = P;
    while ( (aux->prox != NULL) && (elem != aux->num) ){
        ant = aux;
        aux = aux->prox;
    }
     if ( aux->num == elem){
        if (aux->prox == NULL){
            free(aux);
            ant->prox = NULL;
        }
    }
    else{
        return(1);
    }
    return(0);
}
int vazia (TLista* P){

    if (P == NULL){
        return(0);
    }else{
        return(1);
    }
}
