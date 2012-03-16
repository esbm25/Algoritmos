C 1 2 3 4
C234567890123456789012345678901234567890
      PROGRAM GAUSS
      
      integer row,col,i,j,k,l
      real   pivo, lambda
      real *4 me(4,3),ms(4,3)
100   FORMAT(4F8.3)

      WRITE(*,*) '*********************************************'
      WRITE(*,*) '*                                           *'
      WRITE(*,*) '*        Método da Pivotamento Gauss        *'
      WRITE(*,*) '*        para: |a b c d1|                   *'
      WRITE(*,*) '*              |e g i d2|                   *'
      WRITE(*,*) '*              |f h j d3|                   *'
      WRITE(*,*) '*                                           *'
      WRITE(*,*) '* IC-UFMT (Gustavo Liberatti)               *'
      WRITE(*,*) '*********************************************'

c     Define-se os limites da matriz, criada anteriormente para facilitar  
      row=3
      col=4
      
*     Abre e carrega a matriz de entrada para a memória
      open (10, FILE='entrada.dat', STATUS='OLD')
      read(10,*)me
      close(10)
      
      WRITE(*,*) 'Matriz de entrada (matriz.dat) **************'
      WRITE(*,100)me
      ms=me
*     Enquanto não anular a ultima posição      
      do k=1, (col-2)
      me=ms
        pivo=me(k,k)
        WRITE(*,*) 'Novo pivo selecionado: ',pivo
        do l=k, row-1
            lambda=me(k,l+1)/pivo
            WRITE(*,*)'Lambda: ',lambda
            do j=k,col
               i=l+1
               write(*,*)ms(j,i),'=',me(j,i),'-',me(j,k),'*',lambda
               ms(j,i) = me(j,i) - me(j,k)*lambda
            enddo
            WRITE(*,*) 'Matriz interacao:',k,'**************'
            WRITE(*,100)ms
        enddo
      enddo
      
      END