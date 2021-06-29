/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Casilllas;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author alpha
 */
public class Casilla extends JPanel{
    protected int Numero;
    protected String tipo;
    protected int accion;
    protected JLabel fondo = new JLabel();
    protected JLabel num = new JLabel();
    
    public void PintarFondo(){
        this.add(fondo);
        Color envio = new Color(0,0,0);
        int aleatorio = (int)(Math.random()*6);
        if (aleatorio==0) {
            envio = new Color(0 , 206, 209);
        }else if(aleatorio==1){
            envio = new Color(0 , 0, 205);
        }else if(aleatorio==2){
            envio = new Color(123 , 104, 238);
        }else if(aleatorio==3){
            envio = new Color(176 , 196, 222);
        }else if(aleatorio==4){
            envio = new Color(255 , 140, 0);
        }else if(aleatorio==5){
            envio = new Color(255 , 255, 0);
        }
        
        
        this.setBackground(envio);
    }

    public Casilla() {
       this.tipo="Casilla Normal";
    }

    public String getTipo() {
        return tipo;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
        this.add(num);
        this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        num.setBounds(0, 0, 10, 15);
        num.setText(""+Numero);
    }
    
    public int Accion(){
        return accion;
    }
    
    public String ImpresionAccion(int casillas, String nombre){
        String dev = "El jugador "+nombre +" \navanzo "+ casillas+" casillas";
        return dev;
    }

    
}
