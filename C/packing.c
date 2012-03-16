#include <stdio.h>

struct teste_packing
{
    short int inteiro1 :10;
    short int inteiro7 :11;
};

int main()
{
    struct teste_packing estrutura;

    estrutura.inteiro1=2;

    printf(" tamanho: %d",sizeof(estrutura));

    return 0;
}
