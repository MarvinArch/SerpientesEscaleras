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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getGanadas() {
        return ganadas;
    }

    public void setGanadas(int ganadas) {
        this.ganadas = ganadas;
    }

    public int getPerdidas() {
        return perdidas;
    }

    public void setPerdidas(int perdidas) {
        this.perdidas = perdidas;
    }

    public int getJugadas() {
        return jugadas;
    }

    public void setJugadas(int jugadas) {
        this.jugadas = jugadas;
    }
    
}
