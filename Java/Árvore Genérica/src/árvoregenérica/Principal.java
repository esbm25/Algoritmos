package árvoregenérica;

import arvore.ArvoreGenerica;

public class Principal extends javax.swing.JFrame {
    private ArvoreGenerica arv;
    public Principal() {
        arv = new ArvoreGenerica();
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        infos = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        arquivo = new javax.swing.JMenu();
        salvarArv = new javax.swing.JMenuItem();
        recuperarArv = new javax.swing.JMenuItem();
        insercao = new javax.swing.JMenu();
        insercaoPai = new javax.swing.JMenuItem();
        insercaoFilho = new javax.swing.JMenuItem();
        insercaoIrmao = new javax.swing.JMenuItem();
        remocao = new javax.swing.JMenu();
        remocaoNodo = new javax.swing.JMenuItem();
        exibirArv = new javax.swing.JMenuItem();
        pesquisarArv = new javax.swing.JMenuItem();
        sair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Jokerman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("                                Árvore Genérica");

        infos.setColumns(20);
        infos.setRows(5);
        jScrollPane1.setViewportView(infos);

        arquivo.setText("Arquivo");

        salvarArv.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        salvarArv.setText("Salvar Árvore em Disco");
        salvarArv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarArvActionPerformed(evt);
            }
        });
        arquivo.add(salvarArv);

        recuperarArv.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        recuperarArv.setText("Recuperar Árvore do Disco");
        arquivo.add(recuperarArv);

        insercao.setText("Inserção");

        insercaoPai.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        insercaoPai.setText("Pai");
        insercao.add(insercaoPai);

        insercaoFilho.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        insercaoFilho.setText("Filho");
        insercao.add(insercaoFilho);

        insercaoIrmao.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        insercaoIrmao.setText("Irmão");
        insercao.add(insercaoIrmao);

        arquivo.add(insercao);

        remocao.setText("Remoção");

        remocaoNodo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        remocaoNodo.setText("Remover Nodo");
        remocao.add(remocaoNodo);

        arquivo.add(remocao);

        exibirArv.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        exibirArv.setText("Exibir Árvore");
        arquivo.add(exibirArv);

        pesquisarArv.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        pesquisarArv.setText("Pesquisar Elemento");
        arquivo.add(pesquisarArv);

        sair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        sair.setText("Sair");
        arquivo.add(sair);

        jMenuBar1.add(arquivo);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salvarArvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarArvActionPerformed
    
    }//GEN-LAST:event_salvarArvActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu arquivo;
    private javax.swing.JMenuItem exibirArv;
    private javax.swing.JTextArea infos;
    private javax.swing.JMenu insercao;
    private javax.swing.JMenuItem insercaoFilho;
    private javax.swing.JMenuItem insercaoIrmao;
    private javax.swing.JMenuItem insercaoPai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenuItem pesquisarArv;
    private javax.swing.JMenuItem recuperarArv;
    private javax.swing.JMenu remocao;
    private javax.swing.JMenuItem remocaoNodo;
    private javax.swing.JMenuItem sair;
    private javax.swing.JMenuItem salvarArv;
    // End of variables declaration//GEN-END:variables

}
