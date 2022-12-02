/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import controladores.UsuarioController;
import controladores.ProdutoController;
import ferramentas.CaixaDeDialogo;
import modelos.Produto;
import modelos.Usuario;

/**
 *
 * @author pedro.azevedo1
 */
public class TelaProdutos extends javax.swing.JFrame {

    Produto objProduto;
    ProdutoController objProdutoController;
    /**
     * Creates new form TelaProdutos
     */
    public TelaProdutos() {
        initComponents();
        
        limparCampos();
    }
    
        private void atualizarLista(){
        objProdutoController = new ProdutoController();
        objProdutoController.preencherLista(jtbProdutos);

        }
        private void preencherCampos(){
        try{
            
            txtCod.setText(String.valueOf(objProduto.getCod()));
            txtProduto.setText(objProduto.getProduto());

            
            btnIncluir.setEnabled(false);            
            btnAlterar.setEnabled(true);
            btnExcluir.setEnabled(true);
         

            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem(ex.getMessage());
        }
    }
        private void limparCampos(){
        try{
            
            txtCod.setText("COD");
            txtProduto.setText("");

            
            btnIncluir.setEnabled(true);            
            btnAlterar.setEnabled(false);
            btnExcluir.setEnabled(false);
           
            
            atualizarLista();
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem(ex.getMessage());
        }
    }
        
        private void guardarDados(){
        try{
            
            objProduto = new Produto();
            objProduto.setProduto(txtProduto.getText());

            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem(ex.getMessage());
        }
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnIncluir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbUsuarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Cadastro de Produtos");

        btnIncluir.setText("INCLUIR");
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });

        btnLimpar.setText("LIMPAR");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnAlterar.setText("ALTERAR");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setText("EXCLUIR");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jLabel2.setText("Código");

        jLabel3.setText("Nome");

        jtbUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtbUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbUsuariosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbUsuarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                            .addComponent(txtNome))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnIncluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir)))
                .addGap(41, 41, 41))
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIncluir)
                    .addComponent(btnExcluir)
                    .addComponent(btnAlterar)
                    .addComponent(btnLimpar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtbUsuariosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbUsuariosMousePressed
        // TODO add your handling code here:
        try{

            int linhaSelecionada = jtbProdutos.getSelectedRow();//pega a linha selecionada
            String codProduto = jtbProdutos.getModel()
            .getValueAt(linhaSelecionada, 0).toString(); // Primeira coluna da linha

            //if(jtbUsuarios.isColumnSelected(2)){
                ProdutoController objProdutoController = new ProdutoController();

                objProduto = objProdutoController.buscar(Integer.parseInt(codProduto));
                if (objProduto != null && objProduto.getCod() > 0){
                    preencherCampos();
                }else{
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao buscar Usuário no BD!");
                }
                //}

        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem(ex.getMessage(), 'e');
        }
    }//GEN-LAST:event_jtbUsuariosMousePressed

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
        // TODO add your handling code here:
                if(validarDados()){
            
            guardarDados();
            
            //verificar se o usuário já existe
            objProdutoController = new ProdutoController();
            if (objProdutoController.verificaExistencia(objProduto)) {
                CaixaDeDialogo.obterinstancia().exibirMensagem("Produto existente!", 'e');
            }else{
                if(objProdutoController.incluir(objProduto) == true){
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Produto incluído com Sucesso ("+ objProduto.getCod() +")!");
                }else{
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao adicionar produto!", 'e');
                }
            }
            
            limparCampos();

        }
    }         
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:
        try{
            if(validarDados()){
            
                guardarDados();
                objProduto.setCod(Integer.parseInt(txtCod.getText()));

                //verificar se o usuário já existe
                objProdutoController = new ProdutoController();
                if (objProdutoController.verificaExistencia(objProduto)) {
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Produto já existe!", 'e');
                }else{
                    if(objUsuarioController.alterar(objUsuario) == true){
                        CaixaDeDialogo.obterinstancia().exibirMensagem("Produto alterado com Sucesso ("+ objUsuario.getId() +")!");
                    }else{
                        CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao alterar produto!", 'e');
                    }
                }

                limparCampos();

            }

        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
    }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
// TODO add your handling code here:

        limparCampos();

    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:

        try{
            boolean wPergunta = CaixaDeDialogo.obterinstancia().pedirConfirmacao("Tem certeza de que deseja excluir?","",'p');

            if (wPergunta == true){
                objProdutoController = new ProdutoController();
                boolean retorno = objProdutoController
                        .excluir(Integer.parseInt(txtCod.getText()));
                if(retorno){
                    //mensagem OK
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Produto Excluído com sucesso");
                    
                    limparCampos();                 
                }else{
                    //mensagem ERRO
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Impossível Excluir Produto");
                }
            }

        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
    }           
        
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formMousePressed
            private boolean validarDados() {
        
        if (txtNome.getText().equals("")) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Informe o nome do produto", 'e');
            return false;

      
        }
        return true;
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbUsuarios;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
