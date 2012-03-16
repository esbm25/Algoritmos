#include <stdio.h>

int main ()
{
        int c;

        for (c=32; c <= 63;c++){
                printf("%d %c  %d %c %d %c\n",c,c,(c+32),(c+32),(c+64),(c+64));
        }
        return 0;
}
