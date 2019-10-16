/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.ProdutoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Produto;

/**
 *
 * @author 631420395
 */
public class ListProdutos extends javax.swing.JInternalFrame {

    // este objeto receberá a referência do painel da tela inicial, para que 
    // a tela FrmCidades possa ser aberta quando o usuário clicar no botão Editar
    JDesktopPane jdpPainelTelaInicial;
    
    /**
     * Creates new form ListProdutos
     */
    public ListProdutos() {
        initComponents();
        carregarTabela();
    }
    
    public ListProdutos( JDesktopPane jdp) {
        initComponents();
        carregarTabela();
        jdpPainelTelaInicial = jdp;
    }
    
    // método público para que ao editar um produto, possa ser recarregada a tabela de produtos
    public void carregarTabela(){
        List<Produto> lista = ProdutoDAO.getProdutos();
        String[] colunas = {"Código" , "Nome"};
       
        
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers( colunas );
       
        for (Produto produto : lista) {
            Object[] linha = { produto.getId(), produto.getNome() };
            model.addRow( linha );
        }
        
        tableProdutos.setModel( model );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableProdutos = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        tableProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome"
            }
        ));
        jScrollPane1.setViewportView(tableProdutos);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("EXCLUIR");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExcluir)
                    .addComponent(btnEditar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(btnExcluir)
                .addGap(151, 151, 151)
                .addComponent(btnEditar)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int linha = tableProdutos.getSelectedRow();
        if( linha < 0 ){
            JOptionPane.showMessageDialog(this,
                "Você deve selecionar um produto");
        }else{
            int idProduto = (int) tableProdutos.getValueAt(linha, 0);
            FrmProdutos tela = new FrmProdutos( idProduto, this );
            jdpPainelTelaInicial.add( tela );
            tela.setVisible( true );
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linha = tableProdutos.getSelectedRow();
        if( linha < 0 ){
            JOptionPane.showMessageDialog(this,
                "Você deve selecionar um produto");
        }else{
            String nome = (String) tableProdutos.getValueAt(linha, 1);
            int resposta = JOptionPane.showConfirmDialog(this,
                "Confirma que deseja excluir o produto " +nome+ "?",
                "Excluir produto",
                JOptionPane.YES_NO_OPTION);
            if( resposta == JOptionPane.YES_OPTION){
                int id = (int) tableProdutos.getValueAt(linha, 0);
                ProdutoDAO.excluir( id );
                carregarTabela();
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableProdutos;
    // End of variables declaration//GEN-END:variables
}