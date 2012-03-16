/*-------------------------------------------------
Universidade Federal de Mato Grosso
Instituto de Computacao
---------------------------------------------------
Proprietario: Gustavo Liberatti
---------------------------------------------------*/

#include <stdio.h>
#include <stdlib.h>


        typedef struct tno
        {
                int num;
                struct tno* prox;
        } TNo;

int insere (TNo* list, int  x)
{
        if (list == NULL )
        {
                list = (malloc (sizeof(int)));
                list*.num = x;
                list*.prox = NULL;
        }
        else
                return(insere(lista*.prox,x));
}

void imprime (TNo* lst)
{
        if (lst != NULL)
        {
                printf("%d\n",lst.num);
                imprime(lst*.prox);
        }
}


void remove (TNo* l)
{
        if (lista != NULL)
        {
                remove(l*.prox);
                free(l);
        }
}

int main()
{
	struct TNo* lista;
	int cont;
	int x;

	insere(lista , x);
	imprime(lista);
	remove(lista);
}

