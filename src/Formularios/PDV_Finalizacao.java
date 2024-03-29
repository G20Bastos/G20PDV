/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import utilitarios.ConectaBanco;
import utilitarios.ImpressaoCupom;

/**
 *
 * @author gabrielbastos
 */
public class PDV_Finalizacao extends javax.swing.JFrame  {

   
    /**
     * Creates new form PDV_Finalizacao
     */
    
    private JFrame pdvAberto;
    
    //Tratando numeros decimais
    
    DecimalFormat df = new DecimalFormat("0.00");
    ConectaBanco conecta = new ConectaBanco();
    ConectaBanco conecta1 = new ConectaBanco(); 
    
    
    
    //Tratando data
    Date d = new Date();
    java.sql.Date dataSql = new java.sql.Date(d.getTime());
    String dataFormatada = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
    
    float saldo;
    float troco;
    float vlr;
     int mesa_preVenda;
    int funcod_preVenda;
    int sequencial;
    String codOperador1;
    String codigo_cliente;
    String nomeCliente;
 float quantidade_atual_estoque;
 float quantidade_a_ser_retirada;
 float pagamento;
 String produto_a_ser_baixado;
    
    public PDV_Finalizacao(float valor, JFrame pdvAberto, String codOperador, int funcodPre, int mesaPre) {
        
        initComponents();
        conecta.conexao();
        vlr=valor;
        System.out.println(vlr);
        jLabelValorCompra.setText(df.format(valor));
        jLabelObg.setVisible(false);
        this.pdvAberto = pdvAberto;
        codOperador1 = codOperador;
        mesa_preVenda = mesaPre;
        funcod_preVenda = funcodPre;
        
        
    }
    
   
  // public void fecharJanela1() {
  // pdvAberto.dispose();
//}
    
   
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextFieldCodFinalizadora = new javax.swing.JTextField();
        jLabelObg = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelFinalizadora = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelValorCompra = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaCupomFinalizacao = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabelTroco = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelTipoOperacao1 = new javax.swing.JLabel();
        jTextFieldValorPago = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabelSaldo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldCodFinalizadora.setFont(new java.awt.Font("SFNS Display", 1, 36)); // NOI18N
        jTextFieldCodFinalizadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodFinalizadoraActionPerformed(evt);
            }
        });
        jTextFieldCodFinalizadora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldCodFinalizadoraKeyPressed(evt);
            }
        });
        jPanel1.add(jTextFieldCodFinalizadora, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 60, 42));

        jLabelObg.setFont(new java.awt.Font("SFNS Display", 1, 24)); // NOI18N
        jLabelObg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelObg.setText("*******Obrigado e volte sempre! *******");
        jPanel1.add(jLabelObg, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 650, 630, 43));

        jLabel3.setFont(new java.awt.Font("SFNS Display", 1, 36)); // NOI18N
        jLabel3.setText("Código da finalizadora");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 410, 42));

        jLabelFinalizadora.setFont(new java.awt.Font("SFNS Display", 1, 36)); // NOI18N
        jPanel1.add(jLabelFinalizadora, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 770, 42));

        jLabel4.setFont(new java.awt.Font("SFNS Display", 1, 36)); // NOI18N
        jLabel4.setText("Valor total da compra");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 410, 41));

        jLabelValorCompra.setFont(new java.awt.Font("SFNS Display", 1, 36)); // NOI18N
        jPanel1.add(jLabelValorCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 150, 40));

        jTextAreaCupomFinalizacao.setColumns(20);
        jTextAreaCupomFinalizacao.setFont(new java.awt.Font("SFNS Display", 1, 30)); // NOI18N
        jTextAreaCupomFinalizacao.setRows(5);
        jScrollPane1.setViewportView(jTextAreaCupomFinalizacao);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 170, 520, 460));

        jLabel5.setFont(new java.awt.Font("SFNS Display", 1, 36)); // NOI18N
        jLabel5.setText("Valor pago");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 210, 50));

        jLabelTroco.setFont(new java.awt.Font("SFNS Display", 1, 36)); // NOI18N
        jLabelTroco.setText("0");
        jPanel1.add(jLabelTroco, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 500, 300, 70));

        jLabel6.setFont(new java.awt.Font("SFNS Display", 1, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("*****Cupom de finalização*****");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 120, -1, 33));

        jLabel7.setFont(new java.awt.Font("SFNS Display", 1, 36)); // NOI18N
        jLabel7.setText("Saldo");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 130, 70));

        jLabelTipoOperacao1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jPanel1.add(jLabelTipoOperacao1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 687, 335, 43));

        jTextFieldValorPago.setFont(new java.awt.Font("SFNS Display", 1, 36)); // NOI18N
        jTextFieldValorPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldValorPagoActionPerformed(evt);
            }
        });
        jTextFieldValorPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldValorPagoKeyPressed(evt);
            }
        });
        jPanel1.add(jTextFieldValorPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, 130, 42));

        jLabel8.setFont(new java.awt.Font("SFNS Display", 1, 36)); // NOI18N
        jLabel8.setText("Troco");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 130, 70));

        jLabelSaldo.setFont(new java.awt.Font("SFNS Display", 1, 36)); // NOI18N
        jLabelSaldo.setText("0");
        jPanel1.add(jLabelSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, 360, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  //   METODO PARA RECEBER CODIGO DO CLIENTE DO FRAME HELP CLIENTE 
      public void setarCodCliente(String codCliente){
                              
          
                            }
                                
                          
    
    
    private void jTextFieldCodFinalizadoraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCodFinalizadoraKeyPressed
            if(evt.getKeyCode() == KeyEvent.VK_ENTER){
           
           conecta.executaSQL("SELECT * FROM finalizadora WHERE cod_finalizadora='"+ jTextFieldCodFinalizadora.getText()+"'");
           
            try {
               
                if(conecta.rs.next()){
                    String codFinalizadora = jTextFieldCodFinalizadora.getText();
                    if("5".equals(codFinalizadora)){
                        String descricao_finalizadora = conecta.rs.getString("descricao_finalizadora");
                        jLabelFinalizadora.setText(descricao_finalizadora);
                        UIManager.put("OptionPane.cancelButtonText", "Cancelar");
                        UIManager.put("OptionPane.noButtonText", "Ajuda");
                        UIManager.put("OptionPane.yesButtonText", "Sim");
                        int resposta = JOptionPane.showConfirmDialog(rootPane, "Inserir dados do cliente - Crédito facilitado?");
                        
                        if(resposta==0){
                            
                           
                           codigo_cliente = JOptionPane.showInputDialog(rootPane, "Digite o código do cliente");
                          
                           
                            conecta.executaSQL("SELECT * from cliente WHERE CODIGO_CLIENTE='"+ codigo_cliente+"'");
                            
                           
                            
                                try {
                                    if(conecta.rs.next()){
                                        
                                        
                                        nomeCliente = conecta.rs.getString("nome");
                                        
                                        JOptionPane.showMessageDialog(rootPane,"Confirma o nome do cliente? "+ nomeCliente);
                                        
                                        jTextFieldValorPago.requestFocusInWindow();
                                    } else if(codigo_cliente!=null) {
                                        int resposta2 = JOptionPane.showConfirmDialog(rootPane, "Cliente não cadastrado! Deseja Cadastrar?");
                                                if(resposta2==0){
                                                    new FrmCliente().setVisible(true);
                                                }else if(resposta2==1){
                                                     jLabelFinalizadora.setText("");
                            jTextFieldCodFinalizadora.setText("");
                            jTextFieldCodFinalizadora.requestFocusInWindow();
                                                } else {
                                                     jLabelFinalizadora.setText("");
                            jTextFieldCodFinalizadora.setText("");
                            jTextFieldCodFinalizadora.requestFocusInWindow();
                                                
                                                }
                                                
                                    } else{
                                        jLabelFinalizadora.setText("");
                            jTextFieldCodFinalizadora.setText("");
                            jTextFieldCodFinalizadora.requestFocusInWindow();
                                        
                                    }
                                } catch (SQLException ex) {
                                    JOptionPane.showMessageDialog(null,ex) ;
                                }
                            
                        } else if(resposta==1){
                            new HelpCliente().setVisible(true);
                        } else{
                        jLabelFinalizadora.setText("");
                            jTextFieldCodFinalizadora.setText("");
                            jTextFieldCodFinalizadora.requestFocusInWindow();
                        }
                           
                           
                            
                    } else{   
                   String descricao_finalizadora = conecta.rs.getString("descricao_finalizadora");
                   jLabelFinalizadora.setText(descricao_finalizadora);
                    jTextFieldValorPago.requestFocusInWindow();
                    }
                }else{
                    
                    JOptionPane.showMessageDialog(null,"FINALIZADORA NAO CADASTRADA!");
                }
                
                
                
                
            }  catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, ex);
            }
            
            
        }
            if(evt.getKeyCode() == KeyEvent.VK_ESCAPE){
                
                dispose();
                
               
            }
    }//GEN-LAST:event_jTextFieldCodFinalizadoraKeyPressed
    
 
    
    
    
    
    private void jTextFieldCodFinalizadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodFinalizadoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodFinalizadoraActionPerformed

    private void jTextFieldValorPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldValorPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldValorPagoActionPerformed

    private void jTextFieldValorPagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldValorPagoKeyPressed
        
        //DecimalFormat  df = new DecimalFormat();
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            
             conecta.executaSQL("SELECT * FROM TRANSACAO WHERE TRNSEQ = (SELECT MAX(TRNSEQ) FROM TRANSACAO)");
            
            try {
                while(conecta.rs.next()){
                    sequencial = conecta.rs.getInt("trnseq");
                }
            } catch (SQLException ex) {
                Logger.getLogger(PDV.class.getName()).log(Level.SEVERE, null, ex);
            }
                
          String vlrString = df.format(vlr);
                 vlrString = vlrString.replace(",",".");
                 float vlrFormatado = Float.parseFloat(vlrString);
                 vlr = vlrFormatado;
            
            float valorTotalCompra = vlr;
            
            float valorPago = Float.parseFloat(jTextFieldValorPago.getText());
            
            saldo = valorTotalCompra;
            
            
            //TRATANDO EXIBIÇÃO DO TROCO / SALDO
           if (vlr > 0){
               jLabelTroco.setVisible(false);
               jLabelSaldo.setVisible(true);
               
           }else{ 
                       jLabelTroco.setVisible(true);
                       jLabelSaldo.setVisible(false);
           }
           
                 
                         
                if (vlr > 0 && valorPago < saldo ){
                
                    
                vlr = saldo - valorPago;
                troco = vlr;  
                jTextAreaCupomFinalizacao.insert(jTextFieldCodFinalizadora.getText() + "  " + jLabelFinalizadora.getText(), jTextAreaCupomFinalizacao.getCaretPosition());  
                jTextAreaCupomFinalizacao.append("\n");
                jTextAreaCupomFinalizacao.insert("VALOR PAGO: R$ " + jTextFieldValorPago.getText() + ",00", jTextAreaCupomFinalizacao.getCaretPosition());
                jTextAreaCupomFinalizacao.append("\n");
                jTextAreaCupomFinalizacao.insert("VALOR A PAGAR: " + "       " + NumberFormat.getCurrencyInstance().format(vlr), jTextAreaCupomFinalizacao.getCaretPosition());
                jTextAreaCupomFinalizacao.append("\n");
                jTextFieldCodFinalizadora.selectAll();
                jLabelFinalizadora.setText("");
                jTextFieldValorPago.setText("");
                jLabelSaldo.setText(NumberFormat.getCurrencyInstance().format(vlr));
                jTextFieldCodFinalizadora.requestFocus();
                
                //VERIFICANDO SE É A PRIMEIRA INSERÇÃO
               
                try{
                     conecta.executaSQL("SELECT MAX(SEQUENCIAL_FINALIZADORA) AS SEQUENCIAL_FINALIZADORA FROM FINALIZACAO WHERE TRNSEQ=" + sequencial);
                     if (conecta.rs.next()){
                         //ADCIONA + 1 AO SEQUENCIAL_FINALIZADORA
                         int valorAtualSeqFinalizadora = conecta.rs.getInt("SEQUENCIAL_FINALIZADORA");
                          PreparedStatement pst1;
                 
                     pst1 = conecta.conn.prepareStatement("INSERT INTO finalizacao(cod_finalizadora, valor_pago, troco, trndat, trnseq, valor_total_compra, sequencial_finalizadora) VALUES (?,?,?,?,?,?,?)");
                     pst1.setString(1, jTextFieldCodFinalizadora.getText());
                    pst1.setDouble(2,valorPago);
                    pst1.setDouble(3,0);
                    pst1.setDate(4, dataSql);
                    pst1.setInt(5, sequencial); 
                    String vlrCompraString = jLabelValorCompra.getText();
                    vlrCompraString = vlrCompraString.replace(",",".");
                    pst1.setDouble(6, Float.parseFloat(vlrCompraString));
                    pst1.setInt(7, valorAtualSeqFinalizadora + 1);
                    
                     pst1.executeUpdate(); //chamado do metodo para executar a instrucao
                     
                     }else{
                       
                         //REALIZA O PRIMEIRO INSERT
                    PreparedStatement pst1;
                    pst1 = conecta.conn.prepareStatement("INSERT INTO finalizacao(cod_finalizadora, valor_pago, troco, trndat, trnseq, valor_total_compra, sequencial_finalizadora) VALUES (?,?,?,?,?,?,?)");
                    pst1.setString(1, jTextFieldCodFinalizadora.getText());
                    pst1.setDouble(2,valorPago);
                    pst1.setDouble(3,0);
                    pst1.setDate(4, dataSql);
                    pst1.setInt(5, sequencial); 
                    String vlrCompraString = jLabelValorCompra.getText();
                    vlrCompraString = vlrCompraString.replace(",",".");
                    pst1.setDouble(6, Float.parseFloat(vlrCompraString));
                    pst1.setInt(7, 1);  
                                 
                     pst1.executeUpdate(); //chamado do metodo para executar a instrucao    
                                 }
                     
                } catch (SQLException ex) {
                     Logger.getLogger(PDV_Finalizacao.class.getName()).log(Level.SEVERE, null, ex);
                 }
                
                 
            } else {
             
                 
                 troco= valorPago - vlr;
                 
                 jLabelTroco.setText(df.format(troco));
                 jTextAreaCupomFinalizacao.insert("VALOR TOTAL R$               "+ jLabelValorCompra.getText(), jTextAreaCupomFinalizacao.getCaretPosition());
                 jTextAreaCupomFinalizacao.append("\n");
                 jTextAreaCupomFinalizacao.insert(jTextFieldCodFinalizadora.getText() + "      " + jLabelFinalizadora.getText() + "              " + jTextFieldValorPago.getText(), jTextAreaCupomFinalizacao.getCaretPosition());
                 jTextAreaCupomFinalizacao.append("\n");
                 jTextAreaCupomFinalizacao.insert("TROCO R$                        "+jLabelTroco.getText(), jTextAreaCupomFinalizacao.getCaretPosition());
                 jTextAreaCupomFinalizacao.append("\n");
                
                 //POPULANDO NA TABELA FINALIZACAO
                   //VERIFICANDO SE É A PRIMEIRA INSERÇÃO
               
                try{
                     conecta.executaSQL("SELECT MAX(SEQUENCIAL_FINALIZADORA) AS SEQUENCIAL_FINALIZADORA FROM FINALIZACAO WHERE TRNSEQ=" + sequencial);
                     if (conecta.rs.next()){
                         //ADCIONA + 1 AO SEQUENCIAL_FINALIZADORA
                         int valorAtualSeqFinalizadora = conecta.rs.getInt("SEQUENCIAL_FINALIZADORA");
                          PreparedStatement pst1;
                 
                          
                     pst1 = conecta.conn.prepareStatement("INSERT INTO finalizacao(cod_finalizadora, valor_pago, troco, trndat, trnseq, valor_total_compra, sequencial_finalizadora) VALUES (?,?,?,?,?,?,?)");
                     pst1.setString(1, jTextFieldCodFinalizadora.getText());
                    pst1.setDouble(2,valorPago);
                    pst1.setDouble(3, troco);
                    pst1.setDate(4, dataSql);
                    pst1.setInt(5, sequencial); 
                    String vlrCompraString = jLabelValorCompra.getText();
                    vlrCompraString = vlrCompraString.replace(",",".");
                    pst1.setDouble(6, Float.parseFloat(vlrCompraString));
                    pst1.setInt(7, valorAtualSeqFinalizadora + 1);
                    
                     pst1.executeUpdate(); //chamado do metodo para executar a instrucao
                     
                     }else{
                       
                         //REALIZA O PRIMEIRO INSERT
                    PreparedStatement pst1;
                    pst1 = conecta.conn.prepareStatement("INSERT INTO finalizacao(cod_finalizadora, valor_pago, troco, trndat, trnseq, valor_total_compra, sequencial_finalizadora) VALUES (?,?,?,?,?,?,?)");
                    pst1.setString(1, jTextFieldCodFinalizadora.getText());
                    pst1.setDouble(2,valorPago);
                    pst1.setDouble(3,troco);
                    pst1.setDate(4, dataSql);
                    pst1.setInt(5, sequencial); 
                    String vlrCompraString = jLabelValorCompra.getText();
                    vlrCompraString = vlrCompraString.replace(",",".");
                    pst1.setDouble(6, Float.parseFloat(vlrCompraString));
                    pst1.setInt(7, 1);  
                                 
                     pst1.executeUpdate(); //chamado do metodo para executar a instrucao    
                                 }
                 } catch (SQLException ex) {
                     Logger.getLogger(PDV_Finalizacao.class.getName()).log(Level.SEVERE, null, ex);
                 }
                  
                //POPULANDO NA TABELA TRANSACAO
                 
                 try {
                    
                    PreparedStatement pst = conecta.conn.prepareStatement("UPDATE transacao SET trndat=?, funcod=?, trnvlr=? , trntip=?, cod_cliente=?,nome_cliente=?,funcod_pre=?,mesa=? WHERE trnseq='" + sequencial + "'");
                    
                    String vlrReplace = jLabelValorCompra.getText().replace(",",".");
                    double vlrDouble = Double.parseDouble(vlrReplace);
                    pst.setDate(1, dataSql);
                    pst.setString(2,codOperador1);
                    pst.setDouble(3, vlrDouble);
                    pst.setString(4, "1");
                    pst.setString(5,codigo_cliente);
                    pst.setString(6,nomeCliente);
                    pst.setInt(7,funcod_preVenda);
                    pst.setInt(8,mesa_preVenda);
                    
                    
                    pst.executeUpdate(); //chamado do metodo para executar a instrucao
                    //LIBERANDO A MESA PARA O CONSUMO
                    
                    if(mesa_preVenda==0){
                        
                        
                    } else{
                        conecta.executaSQL("DELETE FROM consumo WHERE mesa='"+mesa_preVenda+"'");
                        JOptionPane.showMessageDialog(rootPane,"MESA "+mesa_preVenda+" LIBERADA!");
                    }
                    
                    
                    jLabelObg.setVisible(true);
                     jLabelFinalizadora.setText("");
                    jLabelValorCompra.setText("");
                    jLabelTipoOperacao1.setText("");
                    
                    jTextFieldCodFinalizadora.setText("");
                    jTextFieldValorPago.setText("");
                    
                    JOptionPane.showMessageDialog(rootPane, "TROCO: R$  " + jLabelTroco.getText());
                    UIManager.put("OptionPane.cancelButtonText", "Cancelar");
                        UIManager.put("OptionPane.noButtonText", "Não");
                        UIManager.put("OptionPane.yesButtonText", "Sim");
                    int confirmaImpressao = JOptionPane.showConfirmDialog(rootPane, "Deseja imprimir o cupom? ");
                    if(confirmaImpressao==0){
                    conecta.executaSQL("SELECT * FROM TRANSACAO WHERE TRNSEQ = (SELECT MAX(TRNSEQ) FROM TRANSACAO)");
                    try {
                while(conecta.rs.next()){
                    
                    System.out.println("SEQUENCIAL: "+conecta.rs.getInt("trnseq"));
                    ImpressaoCupom impressaoCupom = new ImpressaoCupom(conecta.rs.getInt("trnseq"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(PDV.class.getName()).log(Level.SEVERE, null, ex);
            }
                    }
                    
                    //RETIRANDO DO ESTOQUE
                    conecta.executaSQL("SELECT procod, quantidade from itevda where TRNSEQ='"+sequencial+"'"); 
                  
                    try {
                       
                while(conecta.rs.next()){
                     
                        produto_a_ser_baixado= conecta.rs.getString("PROCOD");
                    quantidade_a_ser_retirada= conecta.rs.getFloat("QUANTIDADE");
                    System.out.println("antes do metodo "+produto_a_ser_baixado+"   "+quantidade_a_ser_retirada);
                    baixarEstoque(produto_a_ser_baixado,quantidade_a_ser_retirada);
                   
                }
            } catch (SQLException ex) {
                Logger.getLogger(PDV.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                    pdvAberto.dispose();
                  
                    dispose();
                    
                    
                    
                   
                  new PDV().setVisible(true);
                  
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
                 
                 
             
                }
             
        }
        
        
    }//GEN-LAST:event_jTextFieldValorPagoKeyPressed

    
 
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
            java.util.logging.Logger.getLogger(PDV_Finalizacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PDV_Finalizacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PDV_Finalizacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PDV_Finalizacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               float vlr=0;
               JFrame jf=null;
               int mesaaa=0;
               int funcodpree=0;
               String codOperador2="000020";
                new PDV_Finalizacao(vlr,jf, codOperador2, mesaaa, funcodpree).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelFinalizadora;
    private javax.swing.JLabel jLabelObg;
    private javax.swing.JLabel jLabelSaldo;
    private javax.swing.JLabel jLabelTipoOperacao1;
    private javax.swing.JLabel jLabelTroco;
    private javax.swing.JLabel jLabelValorCompra;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaCupomFinalizacao;
    private javax.swing.JTextField jTextFieldCodFinalizadora;
    private javax.swing.JTextField jTextFieldValorPago;
    // End of variables declaration//GEN-END:variables

    private void baixarEstoque(String PROCOD_VENDIDO, float quantidade) {
        String procod=PROCOD_VENDIDO;
        float qtde = quantidade;
                
                PreparedStatement pst;
        try {
            pst = conecta.conn.prepareStatement("UPDATE produto SET quantidade=quantidade-'"+qtde+"' WHERE procod='" + procod + "'");
             pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PDV_Finalizacao.class.getName()).log(Level.SEVERE, null, ex);
        }
                   
                
            
    }
   
        
   }

