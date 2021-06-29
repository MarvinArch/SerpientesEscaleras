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
    }

    public Casilla() {
       this.tipo="Casilla Normal";
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

    
}
