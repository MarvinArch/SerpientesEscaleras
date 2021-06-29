/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Casilllas;

import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author alpha
 */
public class Serpiente extends Casilla{

    public Serpiente(int posIX, int posIY, int posFX, int posFY) {
        int tmp;
        if (posIX-posFX==0) {
            tmp=Math.abs(posIY-posFY);
        }else if(posIY-posFY==0){
            tmp=Math.abs(posIX-posFX);
        }else{
            tmp=Math.abs((posIX-posFX)*(posIY-posFY));
        }        
        this.accion=0-Math.abs(tmp);
        this.tipo = "Serpiente";
    }
    
    @Override
    public int Accion(){
        return accion;
    }
    
    @Override
    public void PintarFondo(){
        
        ImageIcon Imagen1= new ImageIcon("Imagenes/serpiente.png");
        Icon Fondo1= new ImageIcon(Imagen1.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
        this.add(fondo);
        fondo.setIcon(Fondo1);
        this.setBackground(new Color(75, 0, 130));
        this.setLayout(null);
        this.add(num);
        fondo.setBounds(0, 0, this.getWidth(), this.getHeight());
        num.setBounds(0, 0, 10, 15);
        num.setText(""+Numero);
    }
    @Override
    public String ImpresionAccion(int casillas, String nombre){
        String dev = "El jugador "+nombre +" \navanzo "+ casillas+" casillas"+"\nY resbalo "+accion+"\ncasillas";
        return dev;
    }
}
