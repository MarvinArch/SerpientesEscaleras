/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NuevoJuego;

import Casilllas.*;
import Juego.Reloj;
import Usuarios.Buscador;
import Usuarios.Jugador;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author alpha
 */
public class VentanaJuego extends javax.swing.JFrame {
    
    private int accionDado=0;
    private boolean movimiento=false;
    private Dados dad= new Dados();
    private Casilla[][] tab;
    private Thread hilo1;
    private Jugador[] jugadores;
    private int filas,columnas, accion, turno, cantidadJuga, ancho, alto, auxX, auxY;
    private Reloj tiempo;
    private boolean inicio;
    
    /**
     * Creates new form VentanaJuego
     */
    public VentanaJuego() {
        initComponents();
        jPanelInfo.add(dad);
        dad.setBounds(40,150,175,80);
        dad.IniciarDado(1,1);
        CrearArregloCasillasEspeciales();
        ButtonAceptar.setVisible(false);
        turno=0;
        inicio=false;
    }
    //dibuja el tablero y rellena con casillas normales las posisciones que no contengan una casilla especial
    public void DibujarArreglo(int columnas, int filas){
        ancho=Math.abs(750/columnas);
        alto =Math.abs(670/filas);
        CasillasInicioFinal(columnas, filas);
        int casilla = 1;
        jPanelTablero.setBounds(0, 0, 750, 675);
        int inicioX=0;
        int inicioY=670-alto;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (tab[i][j]==null) {
                    tab[i][j]=new Casilla();
                }
                jPanelTablero.add(tab[i][j]);
                tab[i][j].setBounds(inicioX, inicioY, ancho, alto);
                tab[i][j].setNumero(casilla);
                tab[i][j].PintarFondo();
                casilla++;
                
                if (i%2==0) {
                    inicioX+=ancho;
                }else{
                    inicioX-=ancho;
                }
                if (j==(columnas-1) && i%2==0) {
                    inicioX-=ancho;
                }else if(j==(columnas-1) && i%2!=0){
                    inicioX=0;
                }
            }
            inicioY-=alto;
        }
        tiempo = new Reloj();
        this.add(tiempo);
        tiempo.setBounds(765, 525, 250, 70);
        
    }
    //define la posicion de la casilla Final y la casilla de inicio
    public void CasillasInicioFinal(int columnas, int filas){
        tab[0][0]= new Inicio();
        tab[0][0].setBackground(Color.green);
        tab[filas-1][columnas-1]= new Final();
        tab[filas-1][columnas-1].setBackground(Color.red);
        
    }
   //Crear el arreglo de Jugadores que van a jugar una partida
    public void CrearArreglo(Jugador juga){
        jugadores[turno]=juga;
        tab[0][0].add(jugadores[turno]);
        jugadores[turno].EstablecerImagen(turno+1);
        jugadores[turno].setPosicion(1);
        turno++;
        if (turno==cantidadJuga) {
            turno=0;
            labelTurno.setText(jugadores[turno].getNickName());
        }
    }

    public void setCantidadJuga(int cantidadJuga) {
        this.cantidadJuga = cantidadJuga;
        jugadores = new Jugador[cantidadJuga];
        
    }
    //mueve la posicion del jugador y recibe el resultado del lanzamiento de dados
    public void MoverFicha(int casillas){
        boolean turnoextra=false;
        int tmp=casillas+jugadores[turno].getPosicion();
        if (tmp>(filas*columnas)) tmp=(filas*columnas);
        if (tmp<=0) tmp=1;
        if(jugadores[turno].getTurno()==0){
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    if (jugadores[turno].getPosicion()== tab[i][j].getNumero()) {
                        tab[i][j].remove(jugadores[turno]);
                    }
                    if (tmp==tab[i][j].getNumero()) {
                        tab[i][j].add(jugadores[turno]);
                        jugadores[turno].setPosicion(jugadores[turno].getPosicion()+casillas);
                    // identificar la casilla en la que el jugador se ha posicionado
                        LabelInfo.setText(tab[i][j].ImpresionAccion(casillas, jugadores[turno].getNombre()));
                        if (tab[i][j].getTipo().equalsIgnoreCase("Casilla Normal")) {
                            
                        }else if(tab[i][j].getTipo().equalsIgnoreCase("Pierdeturno")){
                            jugadores[turno].setTurno(1);
                        }else if(tab[i][j].getTipo().equalsIgnoreCase("TurnoExtra")){
                            tab[i][j].ImpresionAccion(0, jugadores[turno].getNombre());
                            turnoextra=true;
                        }else if(tab[i][j].getTipo().equalsIgnoreCase("Casilla Inicio")){
                            
                        }else {
                            Auxiliares(i, j);
                            turnoextra=true;
                            accion=1;
                        }
                    }
                    tab[i][j].repaint();
                }
            }
        }else{
            LabelInfo.setText("el Jugador "+ jugadores[turno].getNombre()+" tiene \npenalizacion hasta \nel siguiente turno");
            jugadores[turno].setTurno(0);
        }
        
        if (turnoextra==true) turno--;
        turno++;
        if (turno==jugadores.length) turno=0;
        labelTurno.setText(jugadores[turno].getNickName());
        if (jugadores[turno].getPosicion()>=(filas*columnas)-1) {
            jugadores[turno].setGanador(true);
            DeclararGanador(turno);
        }
    }
    
    public void DeclararGanador(int ganador){
        System.out.println("Entro??");
        JOptionPane.showMessageDialog(this, "El ganador a sido "+jugadores[ganador].getNombre());
        NuevoJuego.TiempoPartida(tiempo.getHora(), tiempo.getMinuto(), tiempo.getSegundo());
        for (int i = 0; i < cantidadJuga; i++) {
            NuevoJuego.AcreditarJuego(jugadores[i].getNickName(), jugadores[i].isGanador());
        }
        NuevoJuego.Reescribir();
        this.dispose();
    }
    //leer archivo y armar tablero unico requisito la primera lenea debe de ser la medida del archivo
    public void CrearArregloCasillasEspeciales(){
        try{
            String linea = null;
            BufferedReader leerFichero = new BufferedReader (new FileReader(Buscador.Archivo()));    
            while( (linea = leerFichero.readLine()) != null){
        //este bucle es para meter todos los datos leidos de archivo de texto separlo en atributos y convertirlos a objeto para poder trabajar con el 
                StringTokenizer cadenaLeida = new StringTokenizer(linea, "(");
                String ussr =  cadenaLeida.nextToken();
                StringTokenizer cadenaDatos = new StringTokenizer(cadenaLeida.nextToken(), ")");
                if(ussr.equalsIgnoreCase("Tablero")){
                    InicializarTablero(cadenaDatos.nextToken());
                }else if(ussr.equalsIgnoreCase("pierdeturno")){
                    PerdeTurnoTirarDados(cadenaDatos.nextToken(), 1);
                }else if(ussr.equalsIgnoreCase("tiradados")){
                    PerdeTurnoTirarDados(cadenaDatos.nextToken(), 2);
                }else if(ussr.equalsIgnoreCase("bajada")){
                    SubidaBajada(cadenaDatos.nextToken(), false);
                }else if(ussr.equalsIgnoreCase("subida")){
                    SubidaBajada(cadenaDatos.nextToken(), true);
                }else if(ussr.equalsIgnoreCase("avanza")){
                    AvanzaRetrocede(cadenaDatos.nextToken(), true);
                } else if(ussr.equalsIgnoreCase("retrocede")){
                    AvanzaRetrocede(cadenaDatos.nextToken(), false);
                }  
            }
            leerFichero.close();
       
        }catch (Exception ex){  
        //Captura un posible error le imprime en pantalla   
            System.out.println("Algo Salio mal ventana Juego");  
        }
        DibujarArreglo(columnas, filas);
    }
    //Iniciar tablero con la primera linea del txt
    public void InicializarTablero(String Cadena){
        try{
            StringTokenizer datosUser = new StringTokenizer(Cadena,",");
            int posY= Integer.parseInt(datosUser.nextToken().trim());
            int posX= Integer.parseInt(datosUser.nextToken().trim());
            tab = new Casilla[posY][posX];
            this.filas=posY;
            this.columnas=posX;
        }catch(Exception ex){
        }
    }
    // Instanciar en el arreglo las casillas de perder turno y tirar dados
    public void PerdeTurnoTirarDados(String Cadena, int tmp){
        try{
            StringTokenizer datosUser = new StringTokenizer(Cadena,",");
            int posY= Integer.parseInt(datosUser.nextToken().trim());
            int posX= Integer.parseInt(datosUser.nextToken().trim());
            if (tmp==1) {
                tab[posY][posX]= new PierdeTurno();
            }else if (tmp==2){
                tab[posY][posX]= new TirarDados();
            }
        }catch(Exception ex){
        }
    }
    
    public void SubidaBajada(String Cadena, boolean subida){
        try{
            StringTokenizer datosUser = new StringTokenizer(Cadena,",");
            int posYI= Integer.parseInt(datosUser.nextToken().trim());
            int posXI= Integer.parseInt(datosUser.nextToken().trim());
            int posYF= Integer.parseInt(datosUser.nextToken().trim());
            int posXF= Integer.parseInt(datosUser.nextToken().trim());
            if (subida==true) {
                tab[posYI][posXI]= new Escalera(posXI, posYI, posXF, posYF);
            }else if (subida==false){
                tab[posYI][posXI]= new Serpiente(posXI, posYI, posXF, posYF);
            }
        }catch(Exception ex){
        }
    }
    
    public void AvanzaRetrocede(String Cadena, boolean avanza){
        try{
            StringTokenizer datosUser = new StringTokenizer(Cadena,",");
            int posYI= Integer.parseInt(datosUser.nextToken().trim());
            int posXI= Integer.parseInt(datosUser.nextToken().trim());
            int posiciones=Integer.parseInt(datosUser.nextToken().trim());
            if (avanza==true) {
                tab[posYI][posXI]= new Avanzar(posiciones);
            }else if (avanza==false){
                tab[posYI][posXI]= new Retrocede(posiciones);
            }
        }catch(Exception ex){
        }
    }
    
    public void Auxiliares(int y, int x){
        this.auxX=x;
        this.auxY=y;
        ButtonAceptar.setVisible(true);
        jButtonDados.setVisible(false);
        
    }
    
    public void AccionCasilla(){
        MoverFicha(tab[auxY][auxX].Accion());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTablero = new javax.swing.JPanel();
        jPanelInfo = new javax.swing.JPanel();
        jButtonDados = new javax.swing.JButton();
        labelTurno = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        LabelInfo = new javax.swing.JTextArea();
        ButtonAceptar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        Menu = new javax.swing.JMenu();
        Reiniciar = new javax.swing.JMenuItem();
        jMenuSalir = new javax.swing.JMenuItem();
        jMenuAcerca = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Juego Serpientes y Escaleras");

        javax.swing.GroupLayout jPanelTableroLayout = new javax.swing.GroupLayout(jPanelTablero);
        jPanelTablero.setLayout(jPanelTableroLayout);
        jPanelTableroLayout.setHorizontalGroup(
            jPanelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
        jPanelTableroLayout.setVerticalGroup(
            jPanelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 677, Short.MAX_VALUE)
        );

        jButtonDados.setText("Tirar Dados");
        jButtonDados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonDadosMouseClicked(evt);
            }
        });

        labelTurno.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelTurno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTurno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("TURNO");

        LabelInfo.setColumns(20);
        LabelInfo.setRows(5);
        jScrollPane2.setViewportView(LabelInfo);

        ButtonAceptar.setText("Aceptar");
        ButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelInfoLayout = new javax.swing.GroupLayout(jPanelInfo);
        jPanelInfo.setLayout(jPanelInfoLayout);
        jPanelInfoLayout.setHorizontalGroup(
            jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInfoLayout.createSequentialGroup()
                        .addGap(16, 72, Short.MAX_VALUE)
                        .addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInfoLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(88, 88, 88))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInfoLayout.createSequentialGroup()
                                .addComponent(ButtonAceptar)
                                .addGap(72, 72, 72))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInfoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(labelTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInfoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonDados)
                .addGap(56, 56, 56))
        );
        jPanelInfoLayout.setVerticalGroup(
            jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInfoLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                .addComponent(jButtonDados)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonAceptar)
                .addContainerGap())
        );

        Menu.setText("Menu");

        Reiniciar.setText("Reiniciar Juego");
        Reiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReiniciarActionPerformed(evt);
            }
        });
        Menu.add(Reiniciar);

        jMenuSalir.setText("Salir");
        jMenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSalirActionPerformed(evt);
            }
        });
        Menu.add(jMenuSalir);

        jMenuBar1.add(Menu);

        jMenuAcerca.setText("Acerca de");
        jMenuBar1.add(jMenuAcerca);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelTablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDadosMouseClicked
        if(inicio==false){
            tiempo.setCorrer(true);
            hilo1=new Thread(tiempo);
            hilo1.start();
            inicio=true;
        }
        if (accionDado==0) {
            
            accionDado=1;
            dad.setMover(true);
            hilo1=new Thread(dad);
            hilo1.start();
        }else if(accionDado==1){
            accionDado=0;
            hilo1.stop();
            dad.setMover(false);
            int tmp1= (int)(Math.random()*6)+1;
            int tmp2= (int)(Math.random()*6)+1;
            dad.IniciarDado(tmp1,tmp2);
            MoverFicha((tmp1+tmp2));
            
        }
    }//GEN-LAST:event_jButtonDadosMouseClicked

    private void ReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReiniciarActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < cantidadJuga; i++) {
            turno=i;
            MoverFicha(1-jugadores[turno].getPosicion());
            jugadores[i].setPosicion(0);
            
        }
        
        turno=0;
    }//GEN-LAST:event_ReiniciarActionPerformed

    private void ButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAceptarActionPerformed
        ButtonAceptar.setVisible(false);
        jButtonDados.setVisible(true);
        AccionCasilla();
    }//GEN-LAST:event_ButtonAceptarActionPerformed

    private void jMenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMenuSalirActionPerformed
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAceptar;
    private javax.swing.JTextArea LabelInfo;
    private javax.swing.JMenu Menu;
    private javax.swing.JMenuItem Reiniciar;
    private javax.swing.JButton jButtonDados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenuAcerca;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuSalir;
    private javax.swing.JPanel jPanelInfo;
    private javax.swing.JPanel jPanelTablero;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelTurno;
    // End of variables declaration//GEN-END:variables

    
}
