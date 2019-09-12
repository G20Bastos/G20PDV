/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitarios;

import Formularios.PDV;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel Bastos
 */
public class FechaFrame {
    PDV pdv = new PDV();
    public FechaFrame(){
        fecharFrame(pdv);
        
    }
           
     
    public static void fecharFrame(JFrame jFrame){
        try {
            Thread.sleep(5000);
            jFrame.dispose();
        // jFrame.setVisible(false) vai funcionar melhor se vc for usar a janela depois
        // ai vc pode usar  jFrame.setVisible(true) para ela aparecer
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao iniciar tempoizador: " + ex);
        }
    }
}
    
    

