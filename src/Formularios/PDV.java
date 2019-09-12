/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import static Formularios.Retaguarda.TEMPO;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.UnsupportedEncodingException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

//import javax.swing.Timer;
import utilitarios.ConectaBanco;
import utilitarios.FechaFrame; 

/**
 *
 * @author gabrielbastos
 */
public class PDV extends javax.swing.JFrame {
    boolean relogio=true; 
    ConectaBanco conecta = new ConectaBanco();
    
    //VARIAVEIS: FUNCIONARIO QUE FEZ A PREVENDA E NUMERO DA MESA
    int funcod_pre;
    int mesa_preVenda;
    
    //Tratando numeros decimais
    float subTotal=0;
    DecimalFormat df = new DecimalFormat("0.00");
    
    //Tratando hora
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    Date hora = Calendar.getInstance().getTime();
    String horaFormatada = sdf.format(hora);
    
    //Tratando data
    Date d = new Date();// sou uma variavel do tipo java.util.Date, porem o banco nao me aceita
    java.sql.Date dataSql = new java.sql.Date(d.getTime());//convertrendo a variavel 'd' para java.sql.date e jogando seu valor em dataSql, agora o BD me aceita
    
    //Determinando tempo para execução de método
public static final long TEMPO = (1000 * 1); // atualizar metodos a cada 10 segundos, aplicado na exibição da hora na tela    
    
    String dataFormatada = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
   
    int sequencial;
    String operadorAtual;
    String codOperador;
    int cxanum;
    String versao;
    
    //Variavel que receberá o peso capturado
    float pesoCapturado;
    float pesoCapturadoEnviado;
    
    
    String tipoEmbalagem;
   public float subTotalEnviado;
       
    
    public PDV() {
        initComponents();
        conecta.conexao();
        jLabelDataHora.setText(dataFormatada + " " + horaFormatada);
         jTextFieldCodProd.requestFocusInWindow();
    
        //PEGANDO INFORMÇÕES DO FUNCIONÁRIO QUE SE LOGOU NO SISTEMA
        conecta.executaSQL("SELECT * FROM CAIXA");
        
        try {
            if (conecta.rs.next()){
            operadorAtual = conecta.rs.getString("nome_operador");   
            codOperador = conecta.rs.getString("cod_operador");   
            cxanum = conecta.rs.getInt("cxanum");
            versao = conecta.rs.getString("versao");
            
            jLabelCodOperador.setText(codOperador);
            jLabelNomeOperador.setText(operadorAtual);
            jLabelVersao.setText(versao);
            jLabelNumCaixa.setText(Integer.toString(cxanum));
            jLabelAbertura.setText(horaFormatada);
            
            
            
                
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao realizar inserção inicial, erro: " + ex);
        }
                
        
        
        
        //jTextAreaCupom.setLineWrap(true);
        //Exibindo data e hora na tela e atualizando automaticamente
        
        
        
        
         //GERANDO SEQUENCIAL 
     
            try {
                     PreparedStatement pst = conecta.conn.prepareStatement("INSERT INTO transacao (trndat,funcod,trnvlr,trntip,cod_cliente,nome_cliente,mesa,funcod_pre) values (?,?,?,?,?,?,?,?)");
                    pst.setDate(1,dataSql);
                    pst.setString(2,"000000");
                    pst.setDouble(3,0.00);
                    pst.setString(4, "0");
                    pst.setString(5,"00000000000");
                    pst.setString(6,"SEM DADOS");
                    pst.setInt(7,0);
                    pst.setInt(8,0);
                    
                    
                    pst.executeUpdate(); //chamado do metodo para executar a instrucao
                    
                    
                
            } catch (SQLException ex) {
                Logger.getLogger(PDV.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        
        
                
    
    }
   
    void atualizaDataHora() { 
            
         
        Timer timer = null;
		if (timer == null) {
			timer = new Timer();
			TimerTask tarefa = new TimerTask() {
				public void run() {
					try {
                                            System.out.println("putz");
                                           jLabelDataHora.setText(dataFormatada + " " + horaFormatada);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			timer.scheduleAtFixedRate(tarefa, TEMPO, TEMPO);
		}
        
    }

   public void envia(float valor){
       
       int respostaAcrescimo = JOptionPane.showConfirmDialog(rootPane, "Cobrar taxa de serviço?");
            if(respostaAcrescimo ==0){
            valor = valor + (valor*10)/100;
            }
        new PDV_Finalizacao(valor, this, jLabelCodOperador.getText(),funcod_pre,mesa_preVenda).setVisible(true);
        
        
        
        
       
   }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelNomeOperador = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelNumCaixa = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldCodProd = new javax.swing.JTextField();
        jTextFieldQtdeProd = new javax.swing.JTextField();
        jTextFieldPrecoUnit = new javax.swing.JTextField();
        jTextFieldPrecoTot = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabelNomeProd = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabelSubTotal = new javax.swing.JLabel();
        jLabelTipoOperacao = new javax.swing.JLabel();
        jLabelVersao = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabelAbertura = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabelDataHora = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabelCodOperador = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabelLogoEmpresa = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaCupom = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 1024));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Telugu MN", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/if_lollypop-lollipop.png"))); // NOI18N
        jLabel1.setText("G20PDV");
        jLabel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 160, 110));

        jLabelNomeOperador.setFont(new java.awt.Font("SFNS Display", 1, 18)); // NOI18N
        jLabelNomeOperador.setText("Gabriel Bastos");
        jPanel1.add(jLabelNomeOperador, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 138, 40));

        jLabel3.setFont(new java.awt.Font("SFNS Display", 1, 18)); // NOI18N
        jLabel3.setText("Operador:");
        jLabel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 100, 40));

        jLabel4.setFont(new java.awt.Font("SFNS Display", 1, 18)); // NOI18N
        jLabel4.setText("Caixa:");
        jLabel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 20, -1, 24));

        jLabelNumCaixa.setFont(new java.awt.Font("SFNS Display", 1, 18)); // NOI18N
        jLabelNumCaixa.setText("001");
        jPanel1.add(jLabelNumCaixa, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 20, 45, 24));

        jLabel5.setFont(new java.awt.Font("SFNS Display", 1, 18)); // NOI18N
        jLabel5.setText("PRODUTO");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, -1, -1));

        jLabel6.setFont(new java.awt.Font("SFNS Display", 1, 18)); // NOI18N
        jLabel6.setText("QUANTIDADE");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, -1, -1));

        jLabel8.setFont(new java.awt.Font("SFNS Display", 1, 18)); // NOI18N
        jLabel8.setText("PREÇO UNITARIO");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, -1, -1));

        jLabel10.setFont(new java.awt.Font("SFNS Display", 1, 18)); // NOI18N
        jLabel10.setText("PREÇO TOTAL");
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 450, -1, -1));

        jTextFieldCodProd.setFont(new java.awt.Font("SFNS Display", 1, 18)); // NOI18N
        jTextFieldCodProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodProdActionPerformed(evt);
            }
        });
        jTextFieldCodProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldCodProdKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldCodProdKeyReleased(evt);
            }
        });
        jPanel1.add(jTextFieldCodProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 420, 50));

        jTextFieldQtdeProd.setFont(new java.awt.Font("SFNS Display", 1, 18)); // NOI18N
        jTextFieldQtdeProd.setText("1");
        jTextFieldQtdeProd.setPreferredSize(new java.awt.Dimension(6, 20));
        jTextFieldQtdeProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldQtdeProdActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldQtdeProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 420, 50));

        jTextFieldPrecoUnit.setFont(new java.awt.Font("SFNS Display", 1, 18)); // NOI18N
        jTextFieldPrecoUnit.setEnabled(false);
        jPanel1.add(jTextFieldPrecoUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 420, 50));

        jTextFieldPrecoTot.setFont(new java.awt.Font("SFNS Display", 1, 18)); // NOI18N
        jTextFieldPrecoTot.setEnabled(false);
        jPanel1.add(jTextFieldPrecoTot, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 490, 420, 50));

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel7.setText("CUPOM");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 140, -1, -1));

        jLabelNomeProd.setBackground(new java.awt.Color(153, 255, 153));
        jLabelNomeProd.setFont(new java.awt.Font("SFNS Display", 1, 36)); // NOI18N
        jLabelNomeProd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNomeProd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabelNomeProd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabelNomeProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 1120, 70));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel2.setText("Item código");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 170, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel9.setText("Descrição");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 170, -1, -1));

        jLabelSubTotal.setBackground(new java.awt.Color(153, 255, 153));
        jLabelSubTotal.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabelSubTotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelSubTotal.setAlignmentY(0.0F);
        jLabelSubTotal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jLabelSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 600, 540, 60));

        jLabelTipoOperacao.setBackground(new java.awt.Color(153, 255, 153));
        jLabelTipoOperacao.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabelTipoOperacao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTipoOperacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jLabelTipoOperacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 520, 60));

        jLabelVersao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(jLabelVersao, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 710, 110, 20));

        jLabel14.setFont(new java.awt.Font("SFNS Display", 1, 18)); // NOI18N
        jLabel14.setText("Versão:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 710, -1, -1));

        jLabel15.setFont(new java.awt.Font("SFNS Display", 1, 18)); // NOI18N
        jLabel15.setText("Abertura:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 710, -1, -1));

        jLabelAbertura.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(jLabelAbertura, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 710, 73, 20));

        jLabel16.setFont(new java.awt.Font("SFNS Display", 1, 18)); // NOI18N
        jLabel16.setText("Data/Hora:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 710, -1, -1));

        jLabelDataHora.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(jLabelDataHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 710, 150, 20));

        jLabel13.setFont(new java.awt.Font("SFNS Display", 1, 18)); // NOI18N
        jLabel13.setText("Subtotal");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 570, -1, -1));

        jLabel17.setFont(new java.awt.Font("SFNS Display", 1, 18)); // NOI18N
        jLabel17.setText("Operações");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, -1, -1));

        jLabelCodOperador.setFont(new java.awt.Font("SFNS Display", 1, 18)); // NOI18N
        jLabelCodOperador.setText("000020");
        jPanel1.add(jLabelCodOperador, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, 40));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel18.setText("comercial");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, 40));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel19.setText("Automação ");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, 50));

        jLabelLogoEmpresa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLogoEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logo-botecaria.jpeg"))); // NOI18N
        jPanel1.add(jLabelLogoEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 240, 340));

        jTextAreaCupom.setColumns(20);
        jTextAreaCupom.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextAreaCupom.setRows(5);
        jScrollPane2.setViewportView(jTextAreaCupom);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 210, 560, 340));

        jLabel20.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel20.setText("Qtde.");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 190, -1, -1));

        jLabel21.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel21.setText("Valor total por item (R$)");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 190, -1, -1));

        jLabel22.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel22.setText("Un.");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 190, -1, -1));

        jLabel23.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel23.setText("Valor unitário(R$)");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 190, -1, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("PRÉ-VENDA");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 128, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1329, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1033, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldCodProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodProdActionPerformed

    private void jTextFieldCodProdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCodProdKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            
                String numero = jTextFieldCodProd.getText();
                final String ZEROS = "00000000000000";
                String s = String.valueOf(numero);
                String novoNumero = ZEROS.substring(s.length()) + s;   
                jTextFieldCodProd.setText(novoNumero);
            
            conecta.executaSQL("SELECT * FROM TRANSACAO WHERE TRNSEQ = (SELECT MAX(TRNSEQ) FROM TRANSACAO)");
            
            try {
                while(conecta.rs.next()){
                    sequencial = conecta.rs.getInt("trnseq");
                }
            } catch (SQLException ex) {
                Logger.getLogger(PDV.class.getName()).log(Level.SEVERE, null, ex);
                
            }
             
           conecta.executaSQL("SELECT * FROM produto WHERE procod='"+ jTextFieldCodProd.getText()+"'");

  
               
            try {
               
                
                if(conecta.rs.next()){
                    
                    /*
                    tipoEmbalagem = conecta.rs.getString("PROUNID");
                    if("KG".equals(tipoEmbalagem)){
                        System.out.println("produto de peso");
                        try {
                            capturarPeso();
                jTextFieldQtdeProd.setText(Float.toString(pesoCapturadoEnviado));
                            
                        } catch (UnsupportedEncodingException ex) {
                            Logger.getLogger(PDV.class.getName()).log(Level.SEVERE, null, ex);
                        }
                
                    }
                    */
                    jLabelTipoOperacao.setText("VENDA");
                   String nomeProdutoCompleto= conecta.rs.getString("prodes"); 
                   String nomeProduto= conecta.rs.getString("prodesrdz");
                   jLabelNomeProd.setText(nomeProdutoCompleto);
                   float qtdeProd = Float.parseFloat(jTextFieldQtdeProd.getText());
                   float precoUnit = conecta.rs.getFloat("proprc1");
                  
                   float precoTotal = precoUnit*qtdeProd;
                   jTextFieldPrecoUnit.setText(df.format(precoUnit));
                   jTextFieldPrecoTot.setText(df.format(precoTotal));
                   subTotal=subTotal + precoTotal;
                   
                
                   
                   
                  PreparedStatement pst = conecta.conn.prepareStatement("INSERT INTO ITEVDA (procod,quantidade,trndat,cxanum,trnseq,itvvlrtot) values (?,?,?,?,?,?)");
                    pst.setString(1, jTextFieldCodProd.getText());
                    pst.setDouble(2,Double.parseDouble(jTextFieldQtdeProd.getText()));
                    pst.setDate(3,dataSql);//nao te ouço
                    pst.setString(4,jLabelNumCaixa.getText());
                    pst.setInt(5, sequencial);
                    pst.setDouble(6, precoTotal);
                    
                    
                    pst.executeUpdate(); //chamado do metodo para executar a instrucao
                    
               
                nomeProduto = String.format("%35s", nomeProduto);
                
                String precoU = jTextFieldPrecoUnit.getText();
                precoU = String.format("%6s", precoU);
                String qtde = Float.toString(qtdeProd);
                qtde = String.format("%8s", qtde); 
                float qt = Float.parseFloat(qtde);
                   //String qtde = Float.toString(qtdeProd);
               
              DecimalFormat df1 = new DecimalFormat("0.000");
                  //System.out.println(nomeProduto+qtde+"  "+ precoTotal); 
                jTextAreaCupom.insert(jTextFieldCodProd.getText()+nomeProduto,jTextAreaCupom.getCaretPosition()); 
                jTextAreaCupom.append("\n");
                jTextAreaCupom.insert("      "+df1.format(qt)+" UN              x                         "+precoU+"                                     =    "+ df.format(precoTotal),jTextAreaCupom.getCaretPosition());
                jTextAreaCupom.append("\n");
                jTextAreaCupom.append("\n");
                
                
                
                    //jTextAreaCupom.setText("teste");
                    
                   
                  //jTextAreaCupom.setText(jTextFieldCodProd.getText()+"  " + nomeProduto + qtdeProd+"   " + precoTotal);  
                  
                  
                   
                   
                   
                   
                   jTextFieldCodProd.setText("");
                   //jTextFieldPrecoTot.setText("");
                   jTextFieldQtdeProd.setText("1");
                   //jTextFieldPrecoUnit.setText("");
                   jLabelSubTotal.setText("R$ " +(df.format(subTotal)));
                    
                   subTotalEnviado=subTotal;
                   
                   
          
            
                   
                    
                
                   
                 
                }else{
                    
                    JOptionPane.showMessageDialog(null,"PRODUTO NAO CADASTRADO!");
                    jTextFieldCodProd.setText("");
                }
                 
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, ex);
            }
            
            
             
             
        } 
        if(evt.getKeyCode() == KeyEvent.VK_SHIFT){
            
            jLabelTipoOperacao.setText("CANCELAMENTO");
            int resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente cancelar o cupom?");
            if(resposta ==0){
                
             int resposta2 = JOptionPane.showConfirmDialog(rootPane, "Confirma o cancelamento do cupom?");
             if (resposta2 == 0){
                int sequencialCancelamento=1;
                conecta.executaSQL("SELECT * FROM TRANSACAO WHERE TRNSEQ = (SELECT MAX(TRNSEQ) FROM TRANSACAO)");
            
            try {
                while(conecta.rs.next()){
                    sequencialCancelamento = conecta.rs.getInt("trnseq");
                }
            } catch (SQLException ex) {
                Logger.getLogger(PDV.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                    //POPULANDO NA TABELA TRANSACAO
                    PreparedStatement pst = conecta.conn.prepareStatement("UPDATE transacao SET trndat=?, funcod=?, trnvlr=?, trntip=? WHERE trnseq='" + sequencialCancelamento + "'");
                    
                    pst.setDate(1, dataSql);
                    pst.setString(2,jLabelCodOperador.getText());
                    pst.setDouble(3,subTotalEnviado);
                    pst.setString(4, "7");
                    
                    pst.executeUpdate(); //chamado do metodo para executar a instrucao
                    
                    jLabelNomeProd.setText("");
                    jTextFieldCodProd.setText("");
                    jTextFieldPrecoTot.setText("");
                    jTextFieldPrecoUnit.setText("");
                    jLabelSubTotal.setText("");
                    jTextAreaCupom.setText("");
                    
            
                    JOptionPane.showMessageDialog(null,"CUPOM CANCELADO");
                    if(mesa_preVenda==0){
                        
                        
                    } else{
                        conecta.executaSQL("DELETE FROM consumo WHERE mesa='"+mesa_preVenda+"'");
                        JOptionPane.showMessageDialog(rootPane,"MESA "+mesa_preVenda+" LIBERADA!");
                    }
                    
                    dispose();
                    new PDV().setVisible(true);
                
                  } catch (SQLException ex) {
                    Logger.getLogger(PDV_Finalizacao.class.getName()).log(Level.SEVERE, null, ex);
                }
                 
             } else{
                 //nao faz nada
             }
                
            } else{
                //não faz nada
                
            }
          
            
            
            
            
            
            
            
            
        }
        if(evt.getKeyCode() == KeyEvent.VK_CONTROL){
            
           
            envia(subTotal);
           
          
                       
      
            
           
           
            
         
            
            
           
        }
        
        if(evt.getKeyCode() == KeyEvent.VK_END){
            jTextFieldCodProd.setText("");
            new ConsultaProduto().setVisible(true);
            
        }
        
        
         if(evt.getKeyCode() == KeyEvent.VK_HOME){
            
            jTextFieldQtdeProd.setText(jTextFieldCodProd.getText());
            //jTextFieldCodProd.setText("");
            jTextFieldCodProd.requestFocusInWindow();
            jTextFieldCodProd.setText("");
            
        }
          if(evt.getKeyCode() == KeyEvent.VK_F1){
            
            new Help().setVisible(true);
            
        }
          if(evt.getKeyCode() == KeyEvent.VK_F2){
              conecta.executaSQL("SELECT * FROM TRANSACAO WHERE TRNSEQ = (SELECT MAX(TRNSEQ) FROM TRANSACAO)");
            
            try {
                while(conecta.rs.next()){
                    sequencial = conecta.rs.getInt("trnseq");
                }
            } catch (SQLException ex) {
                Logger.getLogger(PDV.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
            int chamarMesa = JOptionPane.showConfirmDialog(rootPane, "FINALIZAR PRÉ-VENDA?");
            if(chamarMesa==0){
                 String mesa = JOptionPane.showInputDialog(rootPane, "INSIRA O NUMERO DA MESA");
                
                try {
                    conecta.executaSQL("SELECT * FROM CONSUMO WHERE MESA='"+mesa+"'");
                   
                    
    while(conecta.rs.next()){
        jLabelTipoOperacao.setText("VENDA - PRÉ VENDA");
                   funcod_pre=(conecta.rs.getInt("funcod_pre")); 
                   mesa_preVenda =(conecta.rs.getInt("mesa")); 
                   String nomeProdutoCompleto= conecta.rs.getString("prodes_pre"); 
                   String nomeProduto= conecta.rs.getString("prodes_pre");
                   String procod = conecta.rs.getString("procod_pre");
                   jLabelNomeProd.setText(nomeProdutoCompleto);
                   jTextFieldQtdeProd.setText(Float.toString(conecta.rs.getFloat("quantidade_pre"))); 
                   float qtdeProd = Float.parseFloat(jTextFieldQtdeProd.getText());
                   float precoUnit = conecta.rs.getFloat("precounit_pre");
                  
                   float precoTotal = precoUnit*qtdeProd;
                   jTextFieldPrecoUnit.setText(df.format(precoUnit));
                   jTextFieldPrecoTot.setText(df.format(precoTotal));
                   subTotal=subTotal + precoTotal;
                   
                
                   
                   
                  PreparedStatement pst = conecta.conn.prepareStatement("INSERT INTO ITEVDA (procod,quantidade,trndat,cxanum,trnseq,itvvlrtot) values (?,?,?,?,?,?)");
                    pst.setString(1, procod);
                    pst.setDouble(2,Double.parseDouble(jTextFieldQtdeProd.getText()));
                    pst.setDate(3,dataSql);//nao te ouço
                    pst.setString(4,jLabelNumCaixa.getText());
                    pst.setInt(5, sequencial);
                    pst.setDouble(6, precoTotal);
                    
                    pst.executeUpdate(); //chamado do metodo para executar a instrucao
                    
               
                nomeProduto = String.format("%35s", nomeProduto);
                
                String precoU = jTextFieldPrecoUnit.getText();
                precoU = String.format("%6s", precoU);
                String qtde = Float.toString(qtdeProd);
                qtde = String.format("%8s", qtde); 
                float qt = Float.parseFloat(qtde);
                   //String qtde = Float.toString(qtdeProd);
               
              DecimalFormat df1 = new DecimalFormat("0.000");
                  //System.out.println(nomeProduto+qtde+"  "+ precoTotal); 
                jTextAreaCupom.insert(jTextFieldCodProd.getText()+nomeProduto,jTextAreaCupom.getCaretPosition()); 
                jTextAreaCupom.append("\n");
                jTextAreaCupom.insert("      "+df1.format(qt)+" UN              x                         "+precoU+"                                     =    "+ df.format(precoTotal),jTextAreaCupom.getCaretPosition());
                jTextAreaCupom.append("\n");
                jTextAreaCupom.append("\n");
                
                
                
                    //jTextAreaCupom.setText("teste");
                    
                   
                  //jTextAreaCupom.setText(jTextFieldCodProd.getText()+"  " + nomeProduto + qtdeProd+"   " + precoTotal);  
                  
                  
                   
                   
                   
                   
                   jTextFieldCodProd.setText("");
                   //jTextFieldPrecoTot.setText("");
                   jTextFieldQtdeProd.setText("1");
                   //jTextFieldPrecoUnit.setText("");
                   jLabelSubTotal.setText("R$ " +(df.format(subTotal)));
                    
                   subTotalEnviado=subTotal;
                   
                   
          
            
                   
                    
                
                   
                 
               
                }
                 
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, ex);
            }
            
                   
         
               
            }
            
        }
          
         
         
    }//GEN-LAST:event_jTextFieldCodProdKeyPressed

    
   public void teclarEnter(){
       Robot robot;
                        try {
                            robot = new Robot();
                            robot.keyPress(KeyEvent.VK_ENTER);
                            jTextFieldCodProd.requestFocusInWindow();
                        } catch (AWTException ex) {
                            Logger.getLogger(PDV.class.getName()).log(Level.SEVERE, null, ex);
                        }
   }

   
   
    
    
    
    
    private void jTextFieldQtdeProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldQtdeProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldQtdeProdActionPerformed

    private void jTextFieldCodProdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCodProdKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodProdKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new TerminalPreVenda().setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(PDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PDV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAbertura;
    private javax.swing.JLabel jLabelCodOperador;
    private javax.swing.JLabel jLabelDataHora;
    private javax.swing.JLabel jLabelLogoEmpresa;
    private javax.swing.JLabel jLabelNomeOperador;
    private javax.swing.JLabel jLabelNomeProd;
    private javax.swing.JLabel jLabelNumCaixa;
    private javax.swing.JLabel jLabelSubTotal;
    private javax.swing.JLabel jLabelTipoOperacao;
    private javax.swing.JLabel jLabelVersao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaCupom;
    private javax.swing.JTextField jTextFieldCodProd;
    private javax.swing.JTextField jTextFieldPrecoTot;
    private javax.swing.JTextField jTextFieldPrecoUnit;
    private javax.swing.JTextField jTextFieldQtdeProd;
    // End of variables declaration//GEN-END:variables
}
