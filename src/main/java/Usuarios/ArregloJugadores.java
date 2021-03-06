/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import Juego.Estadisticas;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 *
 * @author alpha
 */
public class ArregloJugadores {
    private int contador;

    public ArregloJugadores() {
        CrearArreglo();
    }
    
    
    static ArrayList<Jugador> juga = new ArrayList();

    public int getContador() {
        return contador;
    }
    
    public void CrearArreglo(){
         try{
            String linea = null;
            BufferedReader leerFichero = new BufferedReader (new FileReader("Recursos/Aiourssu.txt"));    
            while( (linea = leerFichero.readLine()) != null){
        //este bucle es para meter todos los datos leidos de archivo de texto separlo en atributos y convertirlos a objeto para poder trabajar con el 
                StringTokenizer cadenaLeida = new StringTokenizer(linea, "(");
                String ussr =  cadenaLeida.nextToken();
                StringTokenizer cadenaDatos = new StringTokenizer(cadenaLeida.nextToken(), ")");
                if(ussr.equalsIgnoreCase("Usuario")){
                    StringTokenizer datosUser = new StringTokenizer(cadenaDatos.nextToken(),",");
                    String nombre =datosUser.nextToken();
                    String nickname = datosUser.nextToken();
                    int ganadas= Integer.parseInt(datosUser.nextToken());
                    int perdidas= Integer.parseInt(datosUser.nextToken());
                    int jugadas = Integer.parseInt(datosUser.nextToken());
                    int hora = Integer.parseInt(datosUser.nextToken());
                    int minuto = Integer.parseInt(datosUser.nextToken());
                    int segundo = Integer.parseInt(datosUser.nextToken());
                    juga.add(new Jugador(nombre,nickname,ganadas,perdidas,jugadas,hora,minuto,segundo));
                    
                }
                    
            }
            leerFichero.close();
       
        }catch (Exception ex){  
        //Captura un posible error le imprime en pantalla   
            System.out.println("Algo Salio mal Arreglo de Jugadores");  
        }
    }
    
    public int tama??oArreglo(){
        int tama??o= juga.size();
        return tama??o;
    }
    
    public String Nickname(int posicion){
        String nombre= juga.get(posicion).getNickName();
        return nombre;
    }
    
    public void AgregarUsuario(String nombre, String nickname){
        juga.add(new Jugador(nombre,nickname,0,0,0,0,0,0));
        Buscador.LimpiarArchivo();
        ReEscribirArchivo();
    }
    
    public Jugador Jugador(int posicion){
        Jugador dev= juga.get(posicion);
        return dev;
    }
    
    public void ReEscribirArchivo(){
        for (int i = 0; i < juga.size(); i++) {
            Buscador.EscribirUsuarioArchivo(juga.get(i).getNombre(), juga.get(i).getNickName(), juga.get(i).getGanadas(), juga.get(i).getPerdidas(), 
                    juga.get(i).getJugadas(),juga.get(i).getHora(),juga.get(i).getMinuto(),juga.get(i).getSegundo());
        }
    }
    
    public void acreditarPartida(String nickname, boolean ganador, int hora, int minuto, int segundo){
        for (int i = 0; i < juga.size(); i++) {
            if (juga.get(i).getNickName().equalsIgnoreCase(nickname)) {
                juga.get(i).partida(ganador);
                juga.get(i).tiempo(hora, minuto, segundo);
            }
        }
    }
    
    public void OrdenarJugadores(){
        Collections.sort(juga);
    }
    
    public void Estadisticas(){
        Estadisticas var= new Estadisticas();
        var.inicilizarArreglos(juga.size());
        for (int i = 0; i < juga.size(); i++) {
            var.PintarArreglo(juga.get(i).getNickName(), juga.get(i).getNombre(), juga.get(i).getGanadas(), juga.get(i).getPerdidas(), juga.get(i).getJugadas(), juga.get(i).getHora(), juga.get(i).getMinuto(), juga.get(i).getSegundo());
        }
        var.setVisible(true);
    }
}
