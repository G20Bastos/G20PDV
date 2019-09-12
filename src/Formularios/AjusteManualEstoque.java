/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import utilitarios.ConectaBanco;
import utilitarios.ModeloTabela;

/**
 *
 * @author gabrielbastos
 */
public class AjusteManualEstoque extends javax.swing.JFrame {

    ConectaBanco conecta = new ConectaBanco(); // Instancia da classe de conexao
    //Tratando data
    java.util.Date d = new java.util.Date();
    java.sql.Date dataSql = new java.sql.Date(d.getTime());
    String dataFormatada = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
    
    public AjusteManualEstoque() {
        initComponents();
        conecta.conexao(); // chamada do metodo de conexao
        jTextFieldNovaQtde.setEnabled(false);
        jTextFieldQtde.setEnabled(false);
        preencherTabela("SELECT * FROM produto ORDER BY prodes limit 30");
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
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldCod = new javax.swing.JTextField();
        jTextFieldNomeProduto = new javax.swing.JTextField();
        jTextFieldPrecoCompra = new javax.swing.JTextField();
        jButtonEditar = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldPrecoVenda = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldQtde = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldNomeProdutoReduzido = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldTipoEmbalagem = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextMotivo = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldNovaQtde = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Estados");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Código:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Descrição");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Preço de compra");

        jTextFieldCod.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldCod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldCodKeyPressed(evt);
            }
        });

        jTextFieldNomeProduto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldNomeProduto.setEnabled(false);

        jTextFieldPrecoCompra.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldPrecoCompra.setEnabled(false);

        jButtonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/if_081_Pen_183209.png"))); // NOI18N
        jButtonEditar.setText("Salvar dados editados");
        jButtonEditar.setToolTipText("Editar");
        jButtonEditar.setEnabled(false);
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/if_059_CircledOff_183188.png"))); // NOI18N
        jButtonSair.setText("Sair");
        jButtonSair.setToolTipText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Preço de venda");

        jTextFieldPrecoVenda.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldPrecoVenda.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Estoque atual");

        jTextFieldQtde.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldQtde.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Descrição Reduzida");

        jTextFieldNomeProdutoReduzido.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldNomeProdutoReduzido.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Tipo embalagem");

        jTextFieldTipoEmbalagem.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldTipoEmbalagem.setEnabled(false);

        jTextMotivo.setColumns(20);
        jTextMotivo.setRows(5);
        jTextMotivo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Motivo do ajuste", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 0, 14))); // NOI18N
        jScrollPane3.setViewportView(jTextMotivo);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Nova Quantidade");

        jTextFieldNovaQtde.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldNovaQtde.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCod)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNomeProdutoReduzido, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldTipoEmbalagem, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldNovaQtde, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldPrecoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldQtde, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonEditar)
                        .addGap(26, 26, 26)
                        .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 88, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(jTextFieldTipoEmbalagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(jTextFieldNomeProdutoReduzido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jTextFieldPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)
                                .addComponent(jTextFieldQtde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jTextFieldPrecoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonEditar)
                            .addComponent(jButtonSair))))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldNovaQtde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("SFNS Display", 1, 18)); // NOI18N
        jLabel1.setText("Estoque - Ajuste Manual");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(314, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(570, 570, 570))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1110, 523));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed
        
        
    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
            // TODO add your handling code here:
         try { 
            PreparedStatement pst = conecta.conn.prepareStatement("INSERT INTO ajuste_manual_estoque (procod,prodes, prodesrdz, qtde_atual, nova_qtde, motivo_ajuste, data_ajuste)  values (?,?,?,?,?,?,?)"); //passagem do sql a ser executado
            pst.setString(1, jTextFieldCod.getText());
            pst.setString(2, jTextFieldNomeProduto.getText());// passagem dos parametros
            pst.setString(3, jTextFieldNomeProdutoReduzido.getText());
            pst.setFloat(4, Float.parseFloat(jTextFieldQtde.getText()));
            pst.setFloat(5, Float.parseFloat(jTextFieldNovaQtde.getText()));
            pst.setString(6,jTextMotivo.getText());
            pst.setDate(7, dataSql);
            
            pst.executeUpdate(); //chamado do metodo para executar a instrucao
            PreparedStatement pst11 = conecta.conn.prepareStatement("UPDATE PRODUTO SET QUANTIDADE=? WHERE PROCOD='"+jTextFieldCod.getText()+"'");
            pst11.setFloat(1, Float.parseFloat(jTextFieldNovaQtde.getText()));
            pst11.executeUpdate(); 
            JOptionPane.showMessageDialog(rootPane, "Registro Editado com Sucesso!");
            //preencherTabela("SELECT * FROM produto ORDER BY prodes limit 30");
            jButtonEditar.setEnabled(false);
            jTextFieldNomeProduto.setEnabled(false);
            jTextFieldPrecoVenda.setEnabled(false);
            jTextFieldCod.setEnabled(true);
            jTextFieldCod.setText("");
            jTextFieldNomeProduto.setText("");
            jTextFieldNomeProdutoReduzido.setText("");
            jTextFieldNovaQtde.setText("");
            jTextFieldQtde.setText("");
            jTextFieldTipoEmbalagem.setText("");
            jTextFieldPrecoCompra.setText("");
            jTextFieldPrecoVenda.setText("");
            jTextMotivo.setText("");
                    // TODO add your handling code here:
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao editar \n Erro: " + ex);
        }
        
        
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jTextFieldCodKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCodKeyPressed
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            
             String numero = jTextFieldCod.getText();
            final String ZEROS = "00000000000000";
            String s = String.valueOf(numero);
            String novoNumero = ZEROS.substring(s.length()) + s;   
            jTextFieldCod.setText(novoNumero);
            
            conecta.executaSQL("SELECT * FROM PRODUTO WHERE PROCOD='"+jTextFieldCod.getText()+"'");
            
            try {
                
                if(conecta.rs.next()){
                    jTextFieldNomeProduto.setText(conecta.rs.getString("PRODES"));
                    jTextFieldNomeProdutoReduzido.setText(conecta.rs.getString("PRODESRDZ"));
                    jTextFieldTipoEmbalagem.setText(conecta.rs.getString("PROUNID"));
                    jTextFieldPrecoVenda.setText(conecta.rs.getString("PROPRC1"));
                    jTextFieldPrecoCompra.setText(Float.toString(conecta.rs.getFloat("PRECO_COMPRA_REAL")));      
                    jTextFieldQtde.setText(Float.toString(conecta.rs.getFloat("QUANTIDADE")));
                    
                    jTextFieldPrecoVenda.setEnabled(true);
                    jTextFieldQtde.setEnabled(true);
                    jTextFieldPrecoCompra.setEnabled(true);
                    jButtonEditar.setEnabled(true);
                    jTextFieldNovaQtde.setEnabled(true);
        jTextFieldQtde.setEnabled(false);
        jTextFieldNomeProduto.setEnabled(false);
        jTextFieldNomeProdutoReduzido.setEnabled(false);
        jTextFieldPrecoCompra.setEnabled(false);
        jTextFieldPrecoVenda.setEnabled(false);
                    
                    
                    
                    
                } else {
                        JOptionPane.showMessageDialog(null, "Produto não cadastrado!");
                        }
            } catch (SQLException ex) {
                Logger.getLogger(AjusteManualEstoque.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
        
        
        
        
    }//GEN-LAST:event_jTextFieldCodKeyPressed
       public void preencherTabela(String SQL){
            
            ArrayList dados = new ArrayList();
            
            String[]  colunas = new String[]{"CÓDIGO","DESCRIÇÃO","PREÇO"};
            
            conecta.executaSQL(SQL);
            try{ 
               conecta.rs.first();
                 do{
                     dados.add(new Object[]{conecta.rs.getString("procod"),conecta.rs.getString("prodes"),conecta.rs.getFloat("proprc1")});
                 
                
            } while (conecta.rs.next());
                 
            } catch(SQLException ex){
                JOptionPane.showMessageDialog(rootPane, "Erro ao preencher o ArrayList! \n Erro: " + ex);
                
            }
           ModeloTabela modelo = new ModeloTabela(dados, colunas);
           
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
            java.util.logging.Logger.getLogger(AjusteManualEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AjusteManualEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
           // java.util.logging.Logger.getLogger(FrmEstado.class.getName()).log(java.util.logging.LeveljTextFieldCodll, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AjusteManualEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AjusteManualEstoque().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldCod;
    private javax.swing.JTextField jTextFieldNomeProduto;
    private javax.swing.JTextField jTextFieldNomeProdutoReduzido;
    private javax.swing.JTextField jTextFieldNovaQtde;
    private javax.swing.JTextField jTextFieldPrecoCompra;
    private javax.swing.JTextField jTextFieldPrecoVenda;
    private javax.swing.JTextField jTextFieldQtde;
    private javax.swing.JTextField jTextFieldTipoEmbalagem;
    private javax.swing.JTextArea jTextMotivo;
    // End of variables declaration//GEN-END:variables
}
