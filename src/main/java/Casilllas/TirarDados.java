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
public class TirarDados extends Casilla{

    public TirarDados() {
        this.tipo = "TurnoExtra";
    }
    
    @Override
    public String ImpresionAccion(int casillas, String nombre){
        String dev = "El jugador "+nombre +" \navanzo "+ casillas+" casillas"+"\nY ha ganado 1 \nturno extra";
        return dev;
    }
    
    @Override
    public void PintarFondo(){
        ImageIcon Imagen1= new ImageIcon("Imagenes/pierde.png");
        Icon Fondo1= new ImageIcon(Imagen1.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
        this.add(fondo);
        fondo.setIcon(Fondo1);
        this.setBackground(new Color(0, 0, 0));
        this.setLayout(null);
        this.add(num);
        fondo.setBounds(0, 0, this.getWidth(), this.getHeight());
        num.setBounds(0, 0, 10, 15);
        num.setText(""+Numero);
    }
    
}
