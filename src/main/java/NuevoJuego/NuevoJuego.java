/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NuevoJuego;

import Juego.Inicial;
import Usuarios.ArregloJugadores;
import Usuarios.Jugador;

/**
 *
 * @author alpha
 */
public class NuevoJuego {
    private static ArregloJugadores var = new ArregloJugadores();
    private JugadoresPartida seleccion = new JugadoresPartida(true);
    private static int cantidadJugadores;
    private static int contador; 
    private int jugadores;
    private static VentanaJuego juego;
    
    public NuevoJuego(){
        
    }
    
    public static String nombre(int posicion){
        String nombre = var.Nickname(posicion);
        return nombre;
    }
    
    public static int getcantidadJugadores(){
        cantidadJugadores=var.tamañoArreglo();
        juego= new VentanaJuego();
        juego.setCantidadJuga(cantidadJugadores);
        return cantidadJugadores;
    }
    
    public void IniciarJuago(int cantidadJuga){
        contador=0;
        jugadores=cantidadJuga;
        seleccion.CrearLista(cantidadJuga);
        seleccion.setVisible(true);
    }
    
    
   // agregar el asuario al arreglo actual para poder acceder al juego
   public static void AgregarUsuario(String nombre, String nickname){
       var.AgregarUsuario(nombre, nickname);
   }
   // se definen los jugadores que entraran al juego
   public static void definirJugadoresPartida(String nickname){
       for (int i = 0; i < cantidadJugadores; i++) {
           if (nombre(i).equalsIgnoreCase(nickname)) {
               juego.CrearArreglo(var.Jugador(i));
               contador++;
           }
       }
       
   }
   public static void DibujarTablero(){
       
       juego.setVisible(true);
   }
   
}
