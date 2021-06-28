/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Casilllas;

import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author alpha
 */
public class Inicio extends Casilla{
    private JLabel inicio= new JLabel();
    public Inicio() {
        this.tipo="Casilla Inicio";
        this.add(inicio);
        inicio.setBounds(0,0,this.getWidth(), this.getHeight());
        inicio.setText("Inicio");
    }

    
    
    @Override
    public void PintarFondo(){
        this.add(fondo);
        
        fondo.setBackground(Color.green);
    }
}
