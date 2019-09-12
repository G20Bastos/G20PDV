/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitarios;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author gabrielbastos
 */
public class ConectaBanco {
    
    public Statement stm;// Responsavel por preparar e realizar pesquisas no BD
    public ResultSet rs;// Responsavel por armazenar o resultado de uma pesquisa passada pelo o statement
    private String driver = "org.postgresql.Driver";//Responsavel por identificar o servico de BD
    //private String caminho = "jdbc:postgresql://localhost:5432/g20pdv_food";// Responsavel por setar o local do BD
    private String caminho = "jdbc:postgresql://localhost:5432/g20pdv_food";// Responsavel por setar o local do BD
    private String usuario = "postgres";
    private String senha = "masterkey";
    public Connection conn; //Responsavel por realizar a conexao com o BD
    
    public void conexao() { // metodo responsavel pela conexao com o BD
    
        try { //Tentativa inicial
            System.setProperty("jdbc.Drivers", driver); //Seta com qual driver iremos trbalahr
            conn = DriverManager.getConnection(caminho, usuario, senha); // Realiza a conexao com BD passando os dados para acesso
          // JOptionPane.showMessageDialog(null, "Conectado com sucesso!"); 
            
        } catch (SQLException ex) { // Excessao
            
           JOptionPane.showMessageDialog(null, "Erro de conexão!\nErro: "+ex.getMessage());
        }
}
    
    public void executaSQL (String sql){
        
        try {
            
            stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
            
        } catch (SQLException ex) {
            
            //JOptionPane.showMessageDialog(null, "Erro no métdo ExecutaSQL!\nErro: "+ex.getMessage());
        }
        
    }
    public void desconecta(){
        try {
            conn.close();
            //JOptionPane.showMessageDialog(null, "Desconectado com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão!\nErro: "+ex.getMessage());
        }
    }
    
}
