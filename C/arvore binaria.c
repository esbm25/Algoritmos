#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include "TLista.a"
#define TRUE 0
#define FALSE 1

typedef struct TNo {
        struct TNo *esq;
        struct TNo *dir;
        int valor;
    } TLista;

typedef TLista *TArvore;

void criaArvore (TLista **l, int x) {
    *l = malloc(sizeof(*TLista));
    if (*l != NULL) {
        printf ("Sucesso!\n");
    }
}
void insere (TArvore **l, int x) {
    if (*l == NULL) {
        *l = malloc(sizeof(TLista));
        if (*l = NULL) {
            printf ("Nao ha espaço em memoria suficiente\n");
            break;
        }
        (*l)->valor = x;
        (*l)->esq = NULL;
        (*l)->dir = NULL;
        printf ("Sucesso na insercao\n");
    } else {
        if (x < (*l)->valor) {
            insere (&l->esq, x);
        } else {
            if (x > (*l)->valor) {
                insere (&l->dir, x);
            } else {
                printf ("O valor ja existe!");
                break;
            }
        }
    }
}

int main () {
    TLista *head;
    int i;

    criaArvore(&head);
    for (i = 0; i < 10; i++) {
        insere (&head, i);
    }
    for (i = -10; i < 0; i++) {
        insere (&head, i);
    }

    printf ("Fim da insercao\n");
}
