/*-------------------------------------------------
Universidade Federal de Mato Grosso
Instituto de Computacao
---------------------------------------------------
Proprietario: Gustavo Liberatti
---------------------------------------------------*/

#include <stdio.h>
#include<stdlib.h>
#include<string.h>

int i = 0;
char bin[32];

int main()
{
	int num;
	printf("Informe um numero decimal: ");
	scanf("%d",&num);
	while (num >=1)
	{
		bin[i] = num%2;
		num = num /2;
		i++; 
	}
	for(;i>=0;i--)
	{
		printf("%d\n",bin[i]);
	}
}

