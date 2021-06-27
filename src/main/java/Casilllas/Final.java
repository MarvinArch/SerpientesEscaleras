/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Casilllas;

import java.awt.Color;

/**
 *
 * @author alpha
 */
public class Final extends Casilla{
    @Override
    public void PintarFondo(){
        this.add(fondo);
        fondo.setBackground(Color.blue);
    }
}
