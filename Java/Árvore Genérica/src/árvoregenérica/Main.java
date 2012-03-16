package árvoregenérica;

import arvore.ArvoreGenerica;
import arvore.Nodo;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Main {

    static ArvoreGenerica ag = new ArvoreGenerica();
    static Nodo raiz = new Nodo();

    public static void main(String[] args) {
        raiz.setO("NOMES");
        ag.inserirFilho(raiz, "A");
        ag.inserirIrmao(raiz.getFilho(), "Andréia");
        ag.inserirIrmao(raiz.getFilho(), "Ana");
        ag.inserirIrmao(raiz.getFilho(), "Alberto");
        ag.inserirFilho(raiz.getFilho(), "B");
        ag.inserirIrmao(raiz.getFilho().getFilho(), "Bianca");
        ag.inserirFilho(raiz.getFilho().getFilho(), "C");
        ag.inserirIrmao(raiz.getFilho().getFilho().getFilho(), "Carla");
        ag.inserirIrmao(raiz.getFilho().getFilho().getFilho(), "Cristina");
        ag.inserirFilho(raiz.getFilho().getFilho().getFilho(), "D");
        ag.inserirIrmao(raiz.getFilho().getFilho().getFilho().getFilho(), "Diana");
        ag.inserirFilho(raiz.getFilho().getFilho().getFilho().getFilho().getIrmao(), "Dianinha");
        ag.inserirFilho(raiz.getFilho().getFilho().getFilho().getFilho(), "E");

        Nodo nodo = ag.buscar(raiz, "Alberto");
        if (nodo != null) {
            System.out.println("Nodo Encontrado: "+nodo.getO());
        } else {
            System.out.println("Nodo não encontrado");
        }

        ag.setRaiz(raiz);
        if (ag.remove(raiz, "Dianinha")) {
            JOptionPane.showMessageDialog(null, "Removeu");
        }
        raiz = ag.getRaiz();

        ag.resetExibir();
        ag.exibir(raiz);
        JOptionPane.showMessageDialog(null, ag.getExibir());
    }
}
