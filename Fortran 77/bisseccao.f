C 1 2 3 4
C234567890123456789012345678901234567890
      PROGRAM BISSECCAO
*       Declaração de variáveis
        INTEGER I, Nmax, D
        REAL *4 Xa, Xb, Xm, Er, f, Rf
      
        WRITE(*,*)
        WRITE(*,*) '*********************************************'
        WRITE(*,*) '*                                           *'
        WRITE(*,*) '*        Método da bissecção                *'
        WRITE(*,*) '*        para: x^2 -9x +3                   *'
        WRITE(*,*) '*                                           *'
        WRITE(*,*) '* IC-UFMT (Gustavo Liberatti)               *'
        WRITE(*,*) '*********************************************'
        WRITE(*,*)
      
*       RECEBE PARAMETROS -----------------------------------------------
        PRINT *, "INFORME LIMITE Xa"
        READ(*,*)Xa
        PRINT *, "INFORME LIMITE Xb"
        READ(*,*)Xb
        PRINT *, "INFORME ERRO"
        READ(*,*)Er
        PRINT *, "INFORME NUMERO MAXIMO DE INTERACOES"
        READ(*,*)Nmax
        
*       ALGORITMO DA BISSECCAO-------------------------------------------
        WRITE(*,*)'i ', 'Xa ','Xb ','Xm ','f(Xm) ','f(Xa)*f(Xm)'
        I=0
171     CONTINUE
            Xm=(Xa+Xb)/2;
            Rf=f(Xa)*f(Xm)
            IF ( Rf .LT. 0) THEN
                Xb=Xm
            ELSE
                Xa=Xm
            ENDIF
*           IMPRIME RESULTADOS PRELIMINARES
            WRITE(*,*)I,' ',Xa,' ',Xb,' ',Xm,' ',f(Xm),' ',Rf
            I=I+1;
        IF((abs(f(Xm)) > Er) .AND. I < Nmax) GOTO 171
        
        PRINT *, "Xm: "
        PRINT *, Xm
        END
    
*       FUNÇÃO POLINOMIAL ------------------------------------------------     
        REAL FUNCTION f(Xm)
        REAL Xm
            f=Xm*Xm-9*Xm+3;
        RETURN
        END