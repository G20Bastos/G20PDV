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
import java.sql.PreparedStatement;
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
import javax.swing.SwingConstants;

public class ImpressaoComandaBalcao {
    
    ConectaBanco conecta = new ConectaBanco();
        String impressora = "//localhost/impressora";
    Date d = new Date();
    String dataFormatada = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    Date hora = Calendar.getInstance().getTime();
    String horaFormatada = sdf.format(hora);
    
    
    //Tratando numeros decimais
    
    DecimalFormat df = new DecimalFormat("0.00");
    float totalCupom=0;
    float valorPago=0;
    float troco=0;
    String finalizadora;
public ImpressaoComandaBalcao(int mesa) {
    int mesaLocal = mesa;
    String mesaString=Integer.toString(mesaLocal);
    String funcodString = "";
    try {
            //java.io.InputStream is = new FileInputStream("/src/CuponsNaoFiscal/cupom508.txt");
            Scanner sc = new Scanner ("-----------------------------------------------\n" +
"            COMANDA PARA BALCAO            \n" +
"-----------------------------------------------\n" +
"      PRODUTO                   QUANTIDADE     \n" +
"-----------------------------------------------\n");
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
"A.MESA,\n" +
"A.NOMEFUNC_PRE,\n" +
"A.PRODES_PRE,\n" +
"A.QUANTIDADE_PRE\n" +
"FROM CONSUMO A INNER JOIN PRODUTO B\n" +
"ON\n" +
"A.PROCOD_PRE=B.PROCOD\n" +
"WHERE \n" +
"PROUNID<>'AL' AND IMPRESSO IS NULL AND MESA='"+mesaString+"'");   //"WHERE A.TRNSEQ='"+sequencialString+"'");
    
        try {
            
            while(conecta.rs.next()){
               
                try {
           //java.io.InputStream is = new FileInputStream("/src/CuponsNaoFiscal/cupom507.txt");
             funcodString = conecta.rs.getString("NOMEFUNC_PRE"); 
            String prodesrdz = conecta.rs.getString("PRODES_PRE"); 
                  prodesrdz = String.format("%-20s", prodesrdz);
            Scanner sc = new Scanner 
(" "+prodesrdz+"           "+conecta.rs.getString("quantidade_pre")+"  \n");

            //FileOutputStream fs = new FileOutputStream("D:\\Desktop\\testecupom\\itensCozinha.txt");
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
                
            }   } catch (SQLException ex) {
            Logger.getLogger(ImpressaoComandaBalcao.class.getName()).log(Level.SEVERE, null, ex);
        }
    

       try {
            //java.io.InputStream is = new FileInputStream("/src/CuponsNaoFiscal/cupom508.txt");
            float taxa = (totalCupom*10)/100;
            float totalAPagar = totalCupom + taxa;
            Scanner sc = new Scanner
(
         
"-----------------------------------------------\n" +
" NUMERO DA MESA:   "+mesaString+"  \n"+
" FUNCIONARIO:   "+funcodString+"  \n"+        
"***********************************************\n" );
            //FileOutputStream fs = new FileOutputStream("D:\\Desktop\\testecupom\\rodape.txt");
            FileOutputStream fs = new FileOutputStream(impressora);
            //FileOutputStream fs = new FileOutputStream("D:\\Desktop\\testecupom\\rodape.txt");
            PrintStream ps = new PrintStream(fs);
            while(sc.hasNextLine()){
                String linhas = sc.nextLine();
                ps.println(linhas);
            }
            fs.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro encontrado ao imprimir comanda.");
        }

     
      try { 
            PreparedStatement pst = conecta.conn.prepareStatement("UPDATE CONSUMO SET IMPRESSO='S' WHERE MESA = '"+mesaString+"'\n" +
"AND \n" +
"PROCOD_PRE IN\n" +
"(SELECT A.PROCOD FROM PRODUTO A\n" +
"INNER JOIN CONSUMO B\n" +
"ON A.PROCOD=B.PROCOD_PRE AND B.MESA='"+mesaString+"' AND A.PROUNID<>'AL')"); //passagem do sql a ser executado
           
            pst.executeUpdate(); //chamado do metodo para executar a instrucao
            
                    } catch (SQLException ex) {
            System.out.println("Erro ao editar Erro: " + ex);
        }
   
}
   
public static void main(String args[]){
    int sequencial = 0;
    new ImpressaoComandaBalcao(sequencial);
    
}

}
//Fim do código


