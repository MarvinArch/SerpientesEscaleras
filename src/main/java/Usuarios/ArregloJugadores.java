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
public class ArregloJugadores {
    private int contador;

    public int getContador() {
        return contador;
    }
    
    try{
            String linea = null;
            BufferedReader leerFichero = new BufferedReader (new FileReader(Archivo));    
            while( (linea = leerFichero.readLine()) != null){
        //este bucle es para meter todos los datos leidos de archivo de texto separlo en atributos y convertirlos a objeto para poder trabajar con el 
                StringTokenizer CadenaLeida = new StringTokenizer(linea, ",");
                long PasaporteLeido =  Long.parseLong(CadenaLeida.nextToken());
                if (PasaporteLeido==Pasaporte) {
                    
                    String ContraseñaLeida= CadenaLeida.nextToken();
                    
                    if (ContraseñaLeida.equals(Contraseña)) {
                        Existe=true;
                        String[] verificarError=new String[12];
                        for (int i = 0; i < 12; i++) {
                            verificarError[i]=CadenaLeida.nextToken();
                        }
                        
                        
                        
                    }
                }
            }
            leerFichero.close();
       
        }catch (Exception ex){  
        //Captura un posible error le imprime en pantalla   
            System.out.println("Algo Salio mal");  
        }
}
