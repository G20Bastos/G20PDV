/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorios;

import Formularios.Retaguarda;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import utilitarios.ConectaBanco;

/**
 *
 * @author Gabriel Bastos
 */
public class RelatorioVendaGeral extends javax.swing.JFrame {

    /**
     * Creates new form RelatorioVendaPorCliente
     */
    ConectaBanco conecta = new ConectaBanco();
    public RelatorioVendaGeral() {
        initComponents();
        this.setLocationRelativeTo(null);
        conecta.conexao();
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
        jLabelSelecaoIntervalo = new javax.swing.JLabel();
        jDateChooserDataInicial = new com.toedter.calendar.JDateChooser();
        jButtonGerarRelatorios = new javax.swing.JButton();
        jDateChooserDataFinal = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelSelecaoIntervalo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelSelecaoIntervalo.setText("Insira o intervalo desejado e clique em \"Gerar\".");

        jButtonGerarRelatorios.setText("Gerar");
        jButtonGerarRelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerarRelatoriosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelSelecaoIntervalo)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jDateChooserDataInicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonGerarRelatorios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooserDataFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(149, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabelSelecaoIntervalo)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonGerarRelatorios)
                    .addComponent(jDateChooserDataFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jDateChooserDataInicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGerarRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerarRelatoriosActionPerformed
        
        Date relDataIni = jDateChooserDataInicial.getDate();
        Date relDataFin = jDateChooserDataFinal.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        
        
            
         
          try {
              
                   conecta.executaSQL("SELECT\n" +
            "(SELECT to_char(CAST(SUM (TRNVLR)AS DECIMAL(18,2)), 'L9G999G990D99')FROM TRANSACAO WHERE TRNTIP='1' AND TRNDAT BETWEEN '"+sdf.format(relDataIni)+"' AND '"+sdf.format(relDataFin)+"' ) AS TOTAL_PELO_PERIODO,\n" +
            "TRNDAT,\n" +
            "to_char(CAST(SUM (TRNVLR)AS DECIMAL(18,2)), 'L9G999G990D99') AS SUM\n" +
            "FROM TRANSACAO\n" +
            "WHERE TRNTIP='1'\n" +
            "AND TRNDAT BETWEEN '"+sdf.format(relDataIni)+"' AND '"+sdf.format(relDataFin)+"'\n" +
            "GROUP BY TRNDAT\n" +
            "ORDER BY TRNDAT DESC");
  
             
                 
                  System.out.println(sdf.format(relDataIni));
                  System.out.println(sdf.format(relDataFin));
        HashMap filtro = new HashMap<>();
                  
                filtro.put("dataIni", sdf.format(relDataIni));
                filtro.put("dataFin", sdf.format(relDataFin));
                 
                  
                  JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs);
                  JasperPrint jpPrint = JasperFillManager.fillReport("relatorios_ireport/RelatorioVendaGeral.jasper",filtro, relatResul);
                  JasperViewer jv = new JasperViewer(jpPrint, false);
                  jv.setVisible(true);
                  
              
                  
             
               
          } catch (JRException ex) {
              System.out.println("Erro Relatorio: "+ex);  
          
                Logger.getLogger(Retaguarda.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Erro no sql: "+ex);
                
            }
          
     
    }//GEN-LAST:event_jButtonGerarRelatoriosActionPerformed

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
            java.util.logging.Logger.getLogger(RelatorioVendaGeral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatorioVendaGeral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatorioVendaGeral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatorioVendaGeral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatorioVendaGeral().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGerarRelatorios;
    private com.toedter.calendar.JDateChooser jDateChooserDataFinal;
    private com.toedter.calendar.JDateChooser jDateChooserDataInicial;
    private javax.swing.JLabel jLabelSelecaoIntervalo;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
