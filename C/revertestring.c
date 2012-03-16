#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main ()
{
        char pa[255],painver[255];
        int tam,i,j;

        strcpy(painver,"");
        j=0;
        i=0;
        printf("Digite uma palavra: ");
        gets(pa);
        tam=strlen(pa);
        for(i=(tam-1); i >= 0;i--){
                painver[j]=pa[i];
                j++;
        }
        painver[j]='\0';
        printf("A palavra invertida e: %s\n",painver);
        return 0;
}
