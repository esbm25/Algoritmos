package arquivo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Arquivo {

    private File file;

    public Arquivo() {
    }

    public void gravar(String nome, String conteudo) throws FileNotFoundException, IOException {
        file = new File(nome);
        FileOutputStream fos = new FileOutputStream(file, true);
        fos.write(conteudo.getBytes());
        fos.close();
    }

    public void gravar(String nome, ArrayList<String> list) {
        file = new File(nome);
        try {
            FileOutputStream fos = new FileOutputStream(file, true);
            while(list.size() > 0) {
                try {
                    fos.write(list.get(0).getBytes());
                    String s = " # ";
                    fos.write(s.getBytes());
                } catch (IOException ex) {
                    Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
                }
                list.remove(0);
            }
            try {
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String ler(String nome) throws FileNotFoundException, IOException {
        file = new File(nome);
        FileInputStream fis = new FileInputStream(file);
        String saida = "";
        int ln;
        while((ln = fis.read()) != -1) {
            saida = saida+(char)ln;
        }
        fis.close();
        return saida;
    }
}
