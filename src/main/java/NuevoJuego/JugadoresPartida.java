/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NuevoJuego;

import Usuarios.ArregloJugadores;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author alpha
 */
public class JugadoresPartida extends javax.swing.JDialog {

    /**
     * Creates new form JugadoresPartida
     */
    private int cantidadJugadores;
    private JComboBox[] jugadores;
    private JLabel[] labelJugadores;
    
    public JugadoresPartida(boolean modal) {
        
        cantidadJugadores = NuevoJuego.getcantidadJugadores();
        initComponents();
        
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panelfondo = new javax.swing.JPanel();
        Escoger = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Escoger.setText("Escoger Jugadores ");

        jButton1.setText("jButton1");

        javax.swing.GroupLayout PanelfondoLayout = new javax.swing.GroupLayout(Panelfondo);
        Panelfondo.setLayout(PanelfondoLayout);
        PanelfondoLayout.setHorizontalGroup(
            PanelfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelfondoLayout.createSequentialGroup()
                .addContainerGap(176, Short.MAX_VALUE)
                .addGroup(PanelfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelfondoLayout.createSequentialGroup()
                        .addComponent(Escoger)
                        .addGap(164, 164, 164))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelfondoLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(180, 180, 180))))
        );
        PanelfondoLayout.setVerticalGroup(
            PanelfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelfondoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(Escoger)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 326, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panelfondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panelfondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void CrearComboBox(int cantidad){
        for (int i = 0; i < cantidad; i++) {
            for (int j = 0; j <=cantidadJugadores; j++) {
                if (j>0) {
                    jugadores[i].addItem(NuevoJuego.nombre(j-1));
                } else {
                    jugadores[i].addItem("Seleccione una opcion");
                }
            }
        }
    }
    
    public void CrearLista(int cantidad){
        int posY=70;
        jugadores= new JComboBox[cantidad];
        labelJugadores = new JLabel[cantidad];
        for (int i = 0; i < cantidad; i++) {
            jugadores[i]= new JComboBox();
            Panelfondo.add(jugadores[i]);
            jugadores[i].setBounds(300, posY, 150, 25);
            labelJugadores[i] = new JLabel();
            Panelfondo.add(labelJugadores[i]);
            labelJugadores[i].setBounds(75, posY, 100, 25);
            labelJugadores[i].setText("Jugador "+(i+1));
            posY+=50;
        }
        CrearComboBox(cantidad);
    }
    
    
    /**
     * @param args the command line arguments
     */
   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Escoger;
    private javax.swing.JPanel Panelfondo;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
