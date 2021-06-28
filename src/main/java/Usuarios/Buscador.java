/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
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
    
    public static void EscribirUsuarioArchivo(String nombre, String nickname, int ganadas, int perdidas, int jugadas){
        File ruta = new File("Recursos/Aiourssu.txt");   
        try {
            BufferedWriter pw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ruta,true), "utf-8"));
            pw.write("Usuario("+nombre+","+nickname+","+ganadas+","+perdidas+","+jugadas+")"+"\n");
            pw.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
    }
    
    public static void LimpiarArchivo(){
        File ruta = new File("Recursos/Aiourssu.txt");
        
        ruta.delete();
    }
}
