/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitarios;

/**
 *
 * @author Gabriel Bastos
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Inicio do código
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ImpressaoComandaCompleta {
    
    ConectaBanco conecta = new ConectaBanco();
        String impressora = "//localhost/impressora";
    Date d = new Date();
    String dataFormatada = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    Date hora = Calendar.getInstance().getTime();
    String horaFormatada = sdf.format(hora);
    
    
    //Tratando numeros decimais
    
    DecimalFormat df = new DecimalFormat("0.00");
    DecimalFormat df1 = new DecimalFormat("0.000");
    
    float totalCupom=0;
    float valorPago=0;
    float troco=0;
    String finalizadora;
public ImpressaoComandaCompleta(int mesa) {
    int mesaLocal = mesa;
    String mesaString=Integer.toString(mesaLocal);
    try {
            //java.io.InputStream is = new FileInputStream("/src/CuponsNaoFiscal/cupom508.txt");
            Scanner sc = new Scanner 
("------------------------------------------------\n" +
"                 COMANDA COMPLETA                \n" +
"------------------------------------------------\n" +
"   PRODUTO         UNITARIO   QUANTIDADE  VALOR  \n" +
"------------------------------------------------\n");

            FileOutputStream fs = new FileOutputStream(impressora);
            PrintStream ps = new PrintStream(fs);
            while(sc.hasNextLine()){
                String linhas = sc.nextLine();
                ps.println(linhas);
            }
            fs.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro encontrado ao imprimir comanda.");
        }
    
    conecta.conexao();
    
    conecta.executaSQL("SELECT\n" +
"MESA,\n" +
"NOMEFUNC_PRE,\n" +
"PRECOUNIT_PRE AS VALOR_UNITARIO, \n" +            
"PRECOUNIT_PRE,\n" +
"PRODES_PRE,\n" +
"SUM(QUANTIDADE_PRE) AS QUANTIDADE_PRE\n" +
"FROM CONSUMO\n" +
"WHERE \n" +
"MESA='"+mesaString+"' GROUP BY PRODES_PRE, MESA, NOMEFUNC_PRE, VALOR_UNITARIO");   //"WHERE A.TRNSEQ='"+sequencialString+"'");
    
        try {
            
            
            
            while(conecta.rs.next()){
               
                float qtde = conecta.rs.getFloat("QUANTIDADE_PRE");
                try {
            float itvvlrtot = Float.parseFloat(conecta.rs.getString("PRECOUNIT_PRE"));
            
            
            
            
           String prodesrdz = conecta.rs.getString("PRODES_PRE"); 
                  prodesrdz = String.format("%-20s", prodesrdz);
            float unitario = conecta.rs.getFloat("VALOR_UNITARIO");
            float vlrTotalPorItem= unitario * qtde;
            totalCupom = totalCupom + vlrTotalPorItem;
            
            Scanner sc = new Scanner 
(" "+prodesrdz+"  "+df1.format(unitario)+"  "+df1.format(qtde)+"     "+df.format(vlrTotalPorItem)+"  \n");

            FileOutputStream fs = new FileOutputStream(impressora);
            //FileOutputStream fs = new FileOutputStream("D:\\Desktop\\testecupom\\itensComandaMesa.txt");
            PrintStream ps = new PrintStream(fs);
            while(sc.hasNextLine()){
                String linhas = sc.nextLine();
                ps.println(linhas);
            }
            fs.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro encontrado ao imprimir comanda.");
        }
                
                
                
                
                
                
                
            }   } catch (SQLException ex) {
            Logger.getLogger(ImpressaoComandaCompleta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            //java.io.InputStream is = new FileInputStream("/src/CuponsNaoFiscal/cupom508.txt");
            float taxa = (totalCupom*10)/100;
            float totalAPagar = totalCupom + taxa;
            Scanner sc = new Scanner
(
         
"-----------------------------------------------\n" +
" Numero da mesa:                       "+mesaString+"  \n"+
" Total do consumo:                     "+df.format(totalCupom)+"  \n"+
" Taxa de servico:                      "+df.format(taxa)+"  \n"+        
" Total a pagar:                        "+df.format(totalAPagar)+"  \n"+
"***********************************************\n" +
"          OBRIGADO PELA PREFERENCIA  \n" +      
"      Fortaleza, "+dataFormatada+"  "+horaFormatada+"   \n " +       
"***********************************************");
            //FileOutputStream fs = new FileOutputStream("D:\\Desktop\\testecupom\\rodapeCupomPrincipal.txt");
            FileOutputStream fs = new FileOutputStream(impressora);
            //FileOutputStream fs = new FileOutputStream("D:\\Desktop\\testecupom\\rodapeComandaMesa.txt");
            PrintStream ps = new PrintStream(fs);
            while(sc.hasNextLine()){
                String linhas = sc.nextLine();
                ps.println(linhas);
            }
            fs.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro encontrado ao imprimir comanda.");
        }

    

      

}
public static void main(String args[]){
    int sequencial = 0;
    new ImpressaoComandaCompleta(sequencial);
    
}
}
//Fim do código


