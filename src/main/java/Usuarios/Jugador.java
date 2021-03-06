/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author alpha
 */
public class Jugador extends JLabel implements Comparable<Jugador>{
    private String nombre;
    private String nickName;
    private int ganadas;
    private int perdidas;
    private int jugadas;
    private int posicion;
    private int turno;
    private int hora, minuto, segundo;
    private boolean ganador;

    public Jugador(String nombre, String nickName, int ganadas, int perdidas, int jugadas, int hora, int minuto, int segundo) {
        this.nombre = nombre;
        this.nickName = nickName;
        this.ganadas = ganadas;
        this.perdidas = perdidas;
        this.jugadas = jugadas;
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
        this.turno=0;
    }

    
    
    public Jugador(){
        
    }
    
    public void partida(boolean ganador){
        if (ganador==true) {
            this.ganadas++;
        }else{
            this.perdidas++;
        }
        this.jugadas++;
    }
    
    public void tiempo(int hora, int minuto, int segundo){
        this.hora += hora;
        this.minuto += minuto;
        this. segundo += segundo;
    }
    
    public void timepoArreglado(){
        if (segundo>59) {
            minuto++;
            segundo=0;
        }
        if (minuto>59) {
            hora++;
            minuto=0;
        }
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

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    
    
    public void EstablecerImagen(int num){
        ImageIcon Imagen1= new ImageIcon("Imagenes/ficha"+num+".png");
        Icon Fondo1= new ImageIcon(Imagen1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        this.setIcon(Fondo1);
    }
    
    public void EliminarImagen(){
        this.setIcon(null);
    }

    public boolean isGanador() {
        return ganador;
    }

    public void setGanador(boolean ganador) {
        this.ganador = ganador;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }

    @Override
    public int compareTo(Jugador t) {
        if (t.getGanadas()<ganadas) {
            return -1;
        }else if(t.getGanadas()>ganadas){
            return 0;
        }else{
            return 1;
        }
    }
    
}
