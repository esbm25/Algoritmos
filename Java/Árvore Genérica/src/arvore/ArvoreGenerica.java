package arvore;

import arquivo.Arquivo;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ArvoreGenerica {

    private Nodo raiz;
    private Nodo busca;
    private String exibir = "";
    private ArrayList<String> list = new ArrayList<String>();
    private boolean chave = true;

    public ArvoreGenerica() {
    }

    public void inicializar(Nodo raiz) {
        this.raiz = raiz;
    }

    public void inserirFilho(Nodo pai, Object o) {
        Nodo nodo = new Nodo();
        nodo.setO(o);
        nodo.setFilho(null);
        nodo.setIrmao(null);
        nodo.setPai(pai);
        if (pai == null) {
            JOptionPane.showMessageDialog(null, "PAI nulo", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            if (pai.getFilho() == null) {
                pai.setFilho(nodo);
            } else {
                inserirIrmao(pai.getFilho(), o);
            }
        }
    }

    public void inserirIrmao(Nodo filho, Object o) {
        Nodo nodo = new Nodo();
        nodo.setO(o);
        nodo.setFilho(null);
        nodo.setIrmao(null);
        nodo.setPai(filho.getPai());
        if (filho == null) {
            JOptionPane.showMessageDialog(null, "FILHO nulo", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            if (filho.getIrmao() == null) {
                filho.setIrmao(nodo);
            } else {
                Nodo aux = filho.getIrmao();
                while (aux.getIrmao() != null) {
                    aux = aux.getIrmao();
                }
                if (aux.getIrmao() == null) {
                    aux.setIrmao(nodo);
                } else {
                    JOptionPane.showMessageDialog(null, "Houve um erro na inserção do irmão", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public void inserirPai(Nodo filho, Object o) {
        if (filho == null) {
            JOptionPane.showMessageDialog(null, "FILHO nulo", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            if (filho.getPai() == null) {
                Nodo nodo = new Nodo();
                nodo.setO(o);
                nodo.setFilho(filho);
                nodo.setIrmao(null);
                nodo.setPai(null);
                filho.setPai(nodo);
            } else {
                JOptionPane.showMessageDialog(null, "O filho já possui pai!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void exibir(Nodo nodo) {
        if (nodo != null) {
            exibir = exibir+nodo.getO()+"\n ";
            exibir(nodo.getIrmao());
            exibir(nodo.getFilho());
        }
    }

    private void exibirSalvar(Nodo nodo) {
        if (nodo != null) {
            String text = "";
            if (nodo.getPai() == null) {
                text = nodo.getO().toString()+" - NULL";
            } else {
                text = nodo.getO().toString()+" - "+nodo.getPai().getO();
            }
            list.add(text);
            exibirSalvar(nodo.getIrmao());
            exibirSalvar(nodo.getFilho());
        }
    }

    public void salvar(Nodo nodo, String nome) throws FileNotFoundException, IOException {
        limparList();
        exibirSalvar(nodo);
        Arquivo arquivo = new Arquivo();
        arquivo.gravar(nome, list);
    }

    public boolean ler(Nodo nodo) {
        return false;
    }

    public void apagarArvore(Nodo nodo) {
        nodo = null;
        raiz = nodo;
    }

    //Inicio Busca
    public Nodo buscar(Nodo nodo, Object o) {
        busca = null;
        procurar(nodo, o);
        return busca;
    }
        // Função auxiliar da BUSCA
        private void procurar(Nodo nodo, Object o) {
            if (nodo != null) {
                if (nodo.getO() == o) {
                    System.out.println("Achei");
                    busca = nodo;
                }
                procurar(nodo.getIrmao(), o);
                procurar(nodo.getFilho(), o);
            }
        }
    //Fim Busca

    public Nodo getNodo(Nodo nodo, Object o) {
        if (nodo.getO() == o) return nodo;
        if(nodo.getIrmao() != null) return getNodo(nodo.getIrmao(), o);
        if(nodo.getFilho() != null) return getNodo(nodo.getFilho(), o);
        return null;
    }

    public void remove(Nodo nodo) {
        chave = false;
        boolean key = true; //  Operação não realizada
        boolean erro = false;

        // Está Funcionando
        if (key && nodo == null) { // O nodo é nulo
            System.out.println("O nodo é nulo");
            key = false;
            erro = true;
        }

        // Está Funcionando
        if (key && buscar(raiz, nodo.getO()) == null) { // O nodo não existe na árvore
            System.out.println("O nodo não existe na árvore");
            key = false;
            erro = true;
        }

        // Está Funcionando
        if (key && raiz == nodo) { // A raiz deve ser removida
            System.out.println("A raiz deve ser removida");
            if (key && nodo.getFilho() == null && nodo.getIrmao() == null) { // A árvore só tem o nodo raiz!
                System.out.println("A árvore só tem o nodo raiz");
                nodo = null;
                raiz = nodo; // Atualizando a raiz
                key = false;
            }
            if (key && nodo.getIrmao() == null && nodo.getFilho() != null) { // A raiz é um elemento único
                System.out.println("A raiz é um elemento único");
                raiz = nodo.getFilho();
                nodo = raiz; // Atualizando a raiz
                while (nodo != null) {
                    nodo.setPai(null);
                    nodo = nodo.getIrmao();
                }
                key = false;
            }
            if (key && nodo.getIrmao() != null && nodo.getFilho() == null) { // A raiz possui apenas irmão
                System.out.println("A raiz possui apenas irmão");
                nodo = nodo.getIrmao();
                raiz = nodo; // Atualizando a raiz
                key = false;
            }
            if (key && nodo.getIrmao() != null && nodo.getFilho() != null) { // A raiz possui irmão e filho, ou seja, é composta
                System.out.println("A raiz é composta e não será removida por NÃO TER SIDO IMPLEMENTADA");
                // IMPLEMENTAR
                key = false;
            }
        }

        // Aparentemente Funcionando - Falta Testes
        if (key && nodo.getPai() == null) { // É um elemento da raiz composta, ou seja, é um irmão da verdadeira raiz
            System.out.println("É um irmão da raiz");
            Nodo auxRaiz = raiz;
            while (auxRaiz.getIrmao() != nodo) {
                auxRaiz = auxRaiz.getIrmao();
            }
            if (key && nodo.getFilho() == null && nodo.getIrmao() == null) { // Se o nodo é uma folha
                nodo = null;
                auxRaiz.setIrmao(nodo);
                key = false;
            }
            if (key && nodo.getFilho() != null && nodo.getIrmao() == null) { // Se o nodo possui filho e não possui irmão
                Nodo filho = nodo.getFilho();
                auxRaiz.setIrmao(nodo.getFilho());
                while(filho != null) {
                    filho.setPai(null);
                    filho = filho.getIrmao();
                }
                key = false;
            }
            if (key && nodo.getFilho() == null && nodo.getIrmao() != null) { // Se o nodo não possui filho e possui irmão
                nodo = nodo.getIrmao();
                auxRaiz.setIrmao(nodo);
                key = false;
            }
            if (key && nodo.getFilho() != null && nodo.getIrmao() != null) { // Se o nodo possui filho e irmão
                System.out.println("O nodo é irmão de uma raiz composta e não será removida por NÃO TER SIDO IMPLEMENTADA");
                // IMPLEMENTAR
                key = false;
            }
        }

        // O método está funcionando
        if (key && nodo.getFilho() == null && nodo.getIrmao() == null) { // O nodo é uma folha
            System.out.println("O nodo é uma folha");
            Nodo pai = nodo.getPai(); // Recebendo o pai do nodo a ser removido
            Nodo filho = pai.getFilho(); // Recebendo o primeiro filho do pai do nodo a ser removido
            if (filho == nodo) { // Se o nodo for o único filho de seu pai
                nodo = null;
                pai.setFilho(nodo);
            } else { // Se o nodo tiver irmãos mais velhos
                while (filho.getIrmao() != nodo) { // Enquanto não achar o irmão mais velho mais próximo ao nodo a ser removido
                    filho = filho.getIrmao(); // Avançar a linha de irmãos na árvore
                }
                nodo = null;
                filho.setIrmao(nodo); // Removendo a FOLHA
            }
            key = false;
        }

        // O método está funcionando
        if (key && nodo.getFilho() != null && nodo.getIrmao() == null) { // O nodo possui filho e não possui irmão
            System.out.println("O nodo possui filho e não possui irmão");
            Nodo pai = nodo.getPai();
            Nodo filho = pai.getFilho();
            if (filho == nodo) { // O nodo é filho único
                filho = filho.getFilho();
                pai.setFilho(filho);
                nodo = filho;
                while(nodo != null) {
                    nodo.setPai(pai);
                    nodo = nodo.getIrmao();
                }
                key = false;
            } else { // O nodo não é filho único
                while(filho.getIrmao() != nodo) {
                    filho = filho.getIrmao();
                }
                filho.setIrmao(nodo.getFilho());
                nodo = nodo.getFilho();
                while(nodo != null) {
                    nodo.setPai(pai);
                    nodo = nodo.getIrmao();
                }
                key = false;
            }
        }

        // Está Funcionando
        if (key && nodo.getFilho() == null && nodo.getIrmao() != null) { // O nodo não possui filho e possui irmão
            System.out.println("O nodo não possui filho e possui irmão");
            Nodo pai = nodo.getPai();
            Nodo filho = pai.getFilho();
            if (filho == nodo) { // O nodo é o primeiro filho
                nodo = nodo.getIrmao();
                pai.setFilho(nodo);
                key = false;
            } else { // Ele não é o primeiro filho nem o último
                while(filho.getIrmao() != nodo) {
                    filho = filho.getIrmao();
                }
                nodo = nodo.getIrmao();
                filho.setIrmao(nodo);
                key = false;
            }
        }

        // Aparentemente Funcionando
        if (key && nodo.getFilho() != null && nodo.getIrmao() != null) { // O nodo possui filho e irmão
            System.out.println("O nodo possui filho e irmão");
            Nodo pai = nodo.getPai();
            System.out.println(pai.getO());
            Nodo filho = pai.getFilho();
            if (filho == nodo) { // O nodo é o primeiro filho
                pai.setFilho(filho.getIrmao());
                filho = pai.getFilho();
                nodo = nodo.getFilho();
                Nodo aux = filho.getFilho();
                filho.setFilho(nodo);
                while(nodo.getIrmao() != null) {
                    nodo = nodo.getIrmao();
                }
                nodo.setIrmao(aux);
                key = false;
            } else { // O nodo é um dos intermediários da lista
                while(filho.getIrmao() != nodo) {
                    filho = filho.getIrmao();
                }
                filho.setIrmao(nodo.getIrmao());
                nodo = nodo.getFilho();
                Nodo aux = filho.getFilho();
                if (aux == null) {
                    filho.setFilho(nodo);
                } else {
                    while(aux.getIrmao() != null) {
                        aux = aux.getIrmao();
                    }
                    aux.setIrmao(nodo);
                }
                key = false;
            }
        }

        chave = key;

        if (erro) {
            chave = true;
        }
    }

    public boolean remove(Nodo nodo, Object o) {
        Nodo buscado = buscar(nodo, o);
        if (buscado != null) {
            remove(buscado);
            if (isChave()) {
                return true;
            }
        }
        return false;
    }
    
    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public void resetExibir() {
        exibir = "";
    }

    public String getExibir() {
        return exibir;
    }

    private boolean isChave() {
        return !chave;
    }

    public void limparList() {
        while(list.size() > 0) {
            list.remove(0);
        }
    }
}