#include <stdio.h>

int main()
{
        int num,n,result,i,j;

        printf("informe um numero binario: ");
        scanf("%d", &num);
        i=0;
        result=0;
        for(i=0;i<6;i++)
        {
                n=num%10;
                num=num/10;
                if (n > 1)
                {
                        printf("O numero informado nao e binario\n");
                        return(1);
                        result=0;
                }
                if(n==1)
                        if (i==0)
                                n=0;
                        else
                                for (j=0;j<i;j++)
                                        n=n*2;
        result=result+n;
        }
        printf("%d\n",result);
        return (0);
}
