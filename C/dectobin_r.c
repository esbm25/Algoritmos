/*-------------------------------------------------
Universidade Federal de Mato Grosso
Instituto de Computacao
---------------------------------------------------
Proprietario: Gustavo Liberatti
---------------------------------------------------*/

#include <stdio.h>
#include<string.h>

int bin[32];

void binario(int *num, int *i)
{
        int resto;

        if(*num>=1)
        {
                resto = *num%2;
                *num = *num /2;
                binario(num,i);
                bin[*i] = resto;
                //printf("%d\n",bin[*i]);
                (*i)++;
        }
}
void print(int i)
{
        int j;

        for(j = 0;j<i;j++)
        {
                printf("%d\n",bin[j]);
        }
}
int main()
{
        int i = 0;
        int num;

        printf("Informe um numero decimal: ");
        scanf("%d",&num);
        binario(&num,&i);
        print(i);
        return(0);
}
