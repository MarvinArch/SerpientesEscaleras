/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import NuevoJuego.Dados;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alpha
 */
public class Reloj extends javax.swing.JPanel implements Runnable {
    
    private boolean correr;
    private int hora=0;
    private int minuto=0;
    private int segundo=0;
    /**
     * Creates new form Reloj
     */
    public Reloj() {
        initComponents();
        correr = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelHora = new javax.swing.JLabel();
        jLabelMinuto = new javax.swing.JLabel();
        jLabelSegundo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 255, 0));

        jLabelHora.setBackground(new java.awt.Color(255, 255, 255));
        jLabelHora.setFont(new java.awt.Font("Dialog", 1, 40)); // NOI18N
        jLabelHora.setForeground(new java.awt.Color(0, 0, 0));
        jLabelHora.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelHora.setText("00:");

        jLabelMinuto.setFont(new java.awt.Font("Dialog", 1, 40)); // NOI18N
        jLabelMinuto.setForeground(new java.awt.Color(0, 0, 0));
        jLabelMinuto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelMinuto.setText("00:");

        jLabelSegundo.setFont(new java.awt.Font("Dialog", 1, 40)); // NOI18N
        jLabelSegundo.setForeground(new java.awt.Color(0, 0, 0));
        jLabelSegundo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelSegundo.setText("00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelHora, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelSegundo, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSegundo)
                    .addComponent(jLabelMinuto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelHora)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelHora;
    private javax.swing.JLabel jLabelMinuto;
    private javax.swing.JLabel jLabelSegundo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        while(hora<24){
            while(correr==true){
                segundo++;
                if (segundo<10) {
                    jLabelSegundo.setText("0"+segundo);
                }else{
                    jLabelSegundo.setText(""+segundo);
                }
                if (segundo>59) {
                    minuto++;
                    if (minuto<10) {
                        jLabelMinuto.setText("0"+minuto+":");
                    }else {
                        jLabelMinuto.setText(minuto+":");
                    }
                    if (minuto>59) {
                        hora++;
                        if (hora<10) {
                            jLabelHora.setText("0"+hora+":");
                        }
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        
    }

    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public int getSegundo() {
        return segundo;
    }

    public boolean isCorrer() {
        return correr;
    }

    public void setCorrer(boolean correr) {
        this.correr = correr;
    }
    
}
