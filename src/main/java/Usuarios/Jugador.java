/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

/**
 *
 * @author alpha
 */
public class Jugador {
    private String nombre;
    private String nickName;
    private int ganadas;
    private int perdidas;
    private int jugadas;

    public Jugador(String nombre, String nickName, int ganadas, int perdidas, int jugadas) {
        this.nombre = nombre;
        this.nickName = nickName;
        this.ganadas = ganadas;
        this.perdidas = perdidas;
        this.jugadas = jugadas;
    }
    
    public Jugador(){
        
    }
}
