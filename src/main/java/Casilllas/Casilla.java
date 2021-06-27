/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Casilllas;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author alpha
 */
public class Casilla extends JPanel{
    protected int Numero;
    protected boolean ocupado;
    protected String tipo;
    protected JLabel fondo = new JLabel();
    
    public void PintarFondo(){
        this.add(fondo);
        fondo.setBackground(Color.red);
    }

    public Casilla() {
       this.tipo="Casilla Normal";
    }

    
}
