
typedef struct lista TLista;

/*Inicializa A estrutura Dinamica e efetua o teste para saber
 * se ha espaço na memoria */
void criar(TLista* P);

//Destroi toda a estrura dinamica de forma recursiva
void destruir(TLista* P);

/*Inserir sempre no final da estrutura, e efetua teste para verificar
 se o espaço foi realmente alocado*/
int inserir (TLista* P, int num);

/* Remove um elemento passado por parametro, buscando este na estrutura TLista
    e confere se encontrou, depois verifica em que posição se encontra para então
 * remover*/
int remover(TLista* P, int num);

int vazia(TLista* P);

int tamanho(TLista* P);