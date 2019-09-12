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

public class ImpressaoCupom {
    
    ConectaBanco conectaValorPago = new ConectaBanco();
    ConectaBanco conectaItens = new ConectaBanco();
    ConectaBanco conectaTiposFinalizacao = new ConectaBanco();
    ConectaBanco conectaTotalCupom = new ConectaBanco();
    ConectaBanco conectaSomaItensCupom = new ConectaBanco();
    ConectaBanco conectaTroco = new ConectaBanco();
    String impressora = "//localhost/impressora";
    Date d = new Date();
    String dataFormatada = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    Date hora = Calendar.getInstance().getTime();
    String horaFormatada = sdf.format(hora);
    
    DecimalFormat df1 = new DecimalFormat("0.000");
    //Tratando numeros decimais
    
    DecimalFormat df = new DecimalFormat("0.00");
    float somaItensCupom = 0;
    float totalCupom=0;
    float valorPagoPorFinalizadora = 0;
    float valorPago=0;
    float troco=0;
    float qtde=0;
    String finalizadora;
public ImpressaoCupom(int trnseq) {
    int sequencial = trnseq;
    String sequencialString=Integer.toString(sequencial);
    try {
            //java.io.InputStream is = new FileInputStream("/src/CuponsNaoFiscal/cupom508.txt");
            Scanner sc = new Scanner ("-----------------------------------------------\n" +
"              BOTECARIA            \n" +
"        AV GODOFREDO MACIEL - N 2169      \n" + 
"-----------------------------------------------\n" +
"      \n" +
"-----------------------------------------------\n" +
" PRODUTO               QUANTIDADE      PRECO    \n" +
"-----------------------------------------------\n");
            //FileOutputStream fs = new FileOutputStream("D:\\Desktop\\testecupom\\cabecalho.txt");
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
    
  
    conectaItens.conexao();
    conectaTiposFinalizacao.conexao();
    conectaTotalCupom.conexao();
    conectaTroco.conexao();
    conectaValorPago.conexao();
    conectaSomaItensCupom.conexao();
    
    //CONSULTA DOS ITENS
    conectaItens.executaSQL("SELECT \n" +
"B.PRODESRDZ AS PRODESRDZ,\n" +
"A.QUANTIDADE AS QUANTIDADE,\n" +
"A.ITVVLRTOT AS ITVVLRTOT\n" +
"FROM ITEVDA A INNER JOIN PRODUTO B\n" +
"ON A.PROCOD=B.PROCOD\n" +
"WHERE A.TRNSEQ='"+sequencialString+"'");
    
        try {
            
            
            while(conectaItens.rs.next()){
                
                
                qtde = conectaItens.rs.getFloat("QUANTIDADE");
                try {
            
            float itvvlrtot = Float.parseFloat(conectaItens.rs.getString("ITVVLRTOT"));
         
           String prodesrdz = conectaItens.rs.getString("PRODESRDZ"); 
                  prodesrdz = String.format("%-20s", prodesrdz);
           Scanner sc = new Scanner
                    
         (" "+prodesrdz+"      "+df1.format(qtde)+"           "+df.format(itvvlrtot)+"  \n");
         
            //FileOutputStream fs = new FileOutputStream("D:\\Desktop\\testecupom\\itens.txt");
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
            Logger.getLogger(ImpressaoCupom.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
        //REALIZANDO CONSULTA TIPOS DE FINALIZACAO
        
        conectaTiposFinalizacao.executaSQL("SELECT\n" +
"C.VALOR_PAGO AS VALOR_PAGO_FINALIZACAO,\n" +
"D.DESCRICAO_FINALIZADORA AS DESCRICAO_FINALIZADORA\n" +
"FROM\n" +
"FINALIZACAO C INNER JOIN\n" +
"FINALIZADORA D\n" +
"ON C.COD_FINALIZADORA=CAST(D.COD_FINALIZADORA AS TEXT)\n" +
"WHERE C.TRNSEQ='"+sequencialString+"'");
        
        //REALIZANDO CONSULTA TOTAL CUPOM
        conectaTotalCupom.executaSQL("SELECT TRNVLR AS VALOR_TOTAL_COMPRA\n" +
"FROM TRANSACAO \n" +
"WHERE TRNSEQ='"+sequencialString+"'");
        
         //REALIZANDO SOMA ITENS CUPOM
        conectaSomaItensCupom.executaSQL("SELECT SUM (ITVVLRTOT) AS SOMA_ITENS_CUPOM\n" +
"FROM ITEVDA \n" +
"WHERE TRNSEQ='"+sequencialString+"'");
        
        //REALIZANDO CONSULTA TROCO
        conectaTroco.executaSQL("SELECT SUM(TROCO) AS TROCO\n" +
"FROM FINALIZACAO\n" +
"WHERE\n" +
"TRNSEQ='"+sequencialString+"'");
   
        //REALIZANDO CONSULTA TOTAL PAGO PELO CLIENTE
        conectaValorPago.executaSQL("SELECT SUM (VALOR_PAGO) AS VALOR_PAGO\n" +
"FROM FINALIZACAO \n" +
"WHERE TRNSEQ='"+sequencialString+"'");
        
        //TIPOS DE FINALIZACAO
        try{
           
            
            while(conectaTotalCupom.rs.next()){
                
            
                totalCupom = conectaTotalCupom.rs.getFloat("VALOR_TOTAL_COMPRA");
               
            
        }
            
            while(conectaSomaItensCupom.rs.next()){
                
            
                somaItensCupom = conectaSomaItensCupom.rs.getFloat("SOMA_ITENS_CUPOM");
               
            
        }
            while(conectaTroco.rs.next()){
                
               troco=Float.parseFloat(conectaTroco.rs.getString("TROCO")); 
            }
            
            while(conectaValorPago.rs.next()){
                
                 valorPago=Float.parseFloat(conectaValorPago.rs.getString("VALOR_PAGO"));
                
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ImpressaoCupom.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
             
            float taxa = (somaItensCupom*10)/100;
            
            //java.io.InputStream is = new FileInputStream("/src/CuponsNaoFiscal/cupom508.txt");
            Scanner sc = new Scanner
(
         
"-----------------------------------------------\n" +
" Total do consumo:                     "+df.format(somaItensCupom)+"  \n"+
" Taxa de serviço:                      "+df.format(taxa)+"  \n"+             
" Total a pagar:                        "+df.format(totalCupom)+"  \n"+
" Valor pago:                           "+df.format(valorPago)+"  \n"+
" Troco:                                "+df.format(troco)+"  \n"+
" Detalhes do Pagamento :                                      \n"+
" "+finalizadora+ " R$ " + df.format(valorPagoPorFinalizadora)+" \n"+
"-----------------------------------------------\n" +
"                   TELEFONE:                    \n" +
"               085 99979-6878                   \n" +
"***********************************************\n" +
"          OBRIGADO PELA PREFERENCIA  \n" +        
"      Fortaleza, "+dataFormatada+"  "+horaFormatada+"   \n " +       
"***********************************************");
            
            //FileOutputStream fs = new FileOutputStream("D:\\Desktop\\testecupom\\rodapeCupomPrincipal.txt");
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

}
public static void main(String args[]){
    int sequencial = 0;
    new ImpressaoCupom(sequencial);
    
}
}
//Fim do código


