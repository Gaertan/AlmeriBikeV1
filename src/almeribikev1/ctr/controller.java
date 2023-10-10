/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package almeribikev1.ctr;

import almeribikev1.dto.Usuario;
import almeribikev1.gui.AvisoDialog;
import almeribikev1.gui.login.JFrameLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Gaertan
 */
public class controller implements ActionListener {
    
    private Usuario usuario = null;
    
    private JFrameLogin vistaLogin ;
    
    
    
    
    
    
    
        public static void aviso(String texto){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AvisoDialog dialog = new AvisoDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setText(texto);
                dialog.setVisible(true);
            }
        });}

    @Override
    public void actionPerformed(ActionEvent e) {
   
    
    
    
    
    
    
    
    }
    
    
}
