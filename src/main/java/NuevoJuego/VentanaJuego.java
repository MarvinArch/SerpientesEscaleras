/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NuevoJuego;

import Casilllas.*;
import Usuarios.Jugador;
import java.awt.Color;

/**
 *
 * @author alpha
 */
public class VentanaJuego extends javax.swing.JFrame {
    
    private int accionDado=0;
    private boolean movimiento=false;
    private Dados dad= new Dados();
    private Casilla[][] tab;
    private int ancho;
    private int alto;
    private Thread hilo1;
    private int turno;
    private int cantidadJuga;
    private Jugador[] jugadores;
    private int filas;
    private int columnas;
    /**
     * Creates new form VentanaJuego
     */
    public VentanaJuego() {
        initComponents();
        jPanelInfo.add(dad);
        dad.setBounds(20,150,175,80);
        dibujarArreglo(10,10);
        dad.IniciarDado(1,1);
        jPanelTablero.setBackground(Color.yellow);
        turno=0;
    }
    
    public void dibujarArreglo(int columnas, int filas){
        this.filas=filas;
        this.columnas=columnas;
        ancho=Math.abs(750/columnas);
        alto =Math.abs(670/filas);
        int casilla = 1;
        jPanelTablero.setBounds(0, 0, 750, 675);
        int inicioX=0;
        int inicioY=670-alto;
        tab = new Casilla[filas][columnas];
        CasillasInicioFinal(columnas, filas);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (tab[i][j]==null) {
                    tab[i][j]=new Casilla();
                    tab[i][j].setBackground(Color.blue);
                }
                jPanelTablero.add(tab[i][j]);
                tab[i][j].setBounds(inicioX, inicioY, ancho, alto);
                tab[i][j].setNumero(casilla);
                casilla++;
                
                if (i%2==0) {
                    inicioX+=ancho;
                }else{
                    inicioX-=ancho;
                }
                if (j==(columnas-1) && i%2==0) {
                    inicioX=750-ancho;
                }else if(j==(columnas-1) && i%2!=0){
                    inicioX=0;
                }
            }
            inicioY-=alto;
        }
        
    }
    
    public void CasillasInicioFinal(int columnas, int filas){
        tab[0][0]= new Inicio();
        tab[0][0].setBackground(Color.green);
        tab[filas-1][columnas-1]= new Final();
        tab[filas-1][columnas-1].setBackground(Color.red);
    }
    
    public void CrearArreglo(Jugador juga){
        jugadores[turno]=juga;
        tab[0][0].add(jugadores[turno]);
        jugadores[turno].EstablecerImagen(turno+1);
        jugadores[turno].setPosicion(1);
        turno++;
        if (turno==cantidadJuga) {
            turno=0;
        }
    }

    public void setCantidadJuga(int cantidadJuga) {
        this.cantidadJuga = cantidadJuga;
        jugadores = new Jugador[cantidadJuga];
        
    }
    public void MoverFicha(int casillas){
        int tmp=casillas+jugadores[turno].getPosicion();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (jugadores[turno].getPosicion()== tab[i][j].getNumero()) {
                    tab[i][j].remove(jugadores[turno]);
                }
                if (tmp==tab[i][j].getNumero()) {
                    tab[i][j].add(jugadores[turno]);
                    jugadores[turno].setPosicion(jugadores[turno].getPosicion()+casillas);
                    jugadores[turno].EstablecerImagen(turno+1);
                }
            }
        }
        turno++;
        if (turno==jugadores.length) {
            turno=0;
        }
        
            
        
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
        Dado1 = new javax.swing.JLabel();
        Dado2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanelTableroLayout = new javax.swing.GroupLayout(jPanelTablero);
        jPanelTablero.setLayout(jPanelTableroLayout);
        jPanelTableroLayout.setHorizontalGroup(
            jPanelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
        jPanelTableroLayout.setVerticalGroup(
            jPanelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jButtonDados.setText("Tirar Dados");
        jButtonDados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonDadosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelInfoLayout = new javax.swing.GroupLayout(jPanelInfo);
        jPanelInfo.setLayout(jPanelInfoLayout);
        jPanelInfoLayout.setHorizontalGroup(
            jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInfoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(Dado1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Dado2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInfoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonDados)
                .addGap(48, 48, 48))
        );
        jPanelInfoLayout.setVerticalGroup(
            jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInfoLayout.createSequentialGroup()
                .addContainerGap(138, Short.MAX_VALUE)
                .addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Dado1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Dado2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87)
                .addComponent(jButtonDados)
                .addGap(346, 346, 346))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDadosMouseClicked
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
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Dado1;
    private javax.swing.JLabel Dado2;
    private javax.swing.JButton jButtonDados;
    private javax.swing.JPanel jPanelInfo;
    private javax.swing.JPanel jPanelTablero;
    // End of variables declaration//GEN-END:variables

    
}
