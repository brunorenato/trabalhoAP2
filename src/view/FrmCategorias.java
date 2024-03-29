/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.CategoriaDAO;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import model.Categoria;

/**
 *
 * @author 631420395
 */
public class FrmCategorias extends javax.swing.JInternalFrame {

    
    private Categoria categoria;
    
    private ListCategorias telaListCategorias;
    
    /**
     * Creates new form FrmCategorias
     */
    public FrmCategorias() {
        initComponents();
        lblCodigo.setVisible(false);
        lblCodigoValor.setVisible(false);
    }
    
    // Este método Construtor recebe o id da Cidade que será editada e a 
    // referência da tela ListCidades que chamou este formulário, para que ao 
    // final da edição a tebela no ListCidades possa ser atualizada, senão o 
    // usuário pensará que não salvou a alteração no banco
    public FrmCategorias(int idCategoria, ListCategorias telaListCategorias) {
        initComponents();
        lblCodigo.setVisible(false);
        lblCodigoValor.setVisible(false);
        carregarFormulario( idCategoria );
        this.telaListCategorias = telaListCategorias;
    }
    
    private void carregarFormulario( int idCategoria ){
        categoria = CategoriaDAO.getCategoriaById( idCategoria );
        lblCodigoValor.setText( String.valueOf( categoria.getId() ) );
        txtNome.setText( categoria.getNome() );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        lblCodigo = new javax.swing.JLabel();
        lblCodigoValor = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Formulário de Categorias");

        jPanel1.setBackground(new java.awt.Color(51, 248, 245));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Nome da categoria: ");

        btnSalvar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        lblCodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCodigo.setText("Código: ");

        lblCodigoValor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCodigoValor.setText("00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNome))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(144, 144, 144)
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblCodigo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCodigoValor, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 122, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(lblCodigoValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(73, 73, 73)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        String nome = txtNome.getText();
        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Informe o nome da Categoria!");
        }else{

            // se cidade for igual a NULL então significa que o formulário está
            // sendo usado para cadastrar uma nova categoria
            // se não for NULL então significa que passou pelo método construtor
            // que recebe uma cidade do banco e preenche o formulário para poder
            // editar uma categoria
            if( categoria == null ){
                Categoria categoria = new Categoria();
                categoria.setNome( nome );
                CategoriaDAO.inserir( categoria );

                limpar();
                
            }else{
                categoria.setNome( nome );
                CategoriaDAO.editar( categoria );

                // Assim que a categoria for editada, a tabela na tela ListCategorias
                // será recarregada
                telaListCategorias.carregarTabela();

                //Fechar a tela
                this.dispose();
            }

        }
    }//GEN-LAST:event_btnSalvarActionPerformed
    
    private void limpar() {
        txtNome.setText("");        
    }   


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCodigoValor;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
