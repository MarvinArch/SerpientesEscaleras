/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import javax.swing.JFileChooser;

/**
 *
 * @author alpha
 */
public class Buscador {
    
    public static String Archivo(){
        String archivo;
        
       JFileChooser var = new JFileChooser();
       var.showOpenDialog(null);
       archivo = var.getSelectedFile().toString();
       return archivo;
    }
}
