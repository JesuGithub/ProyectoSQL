/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Ventanas;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author j2a0a
 */
public class Operacion4 extends javax.swing.JPanel {
    private JLabel[][] matriz;

    public JLabel[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(JLabel[][] matriz) {
        this.matriz = matriz;
    }
    
    public void showPanel(JPanel panel){
        panel.setSize(1010,350);
        panel.setLocation(0,0);
        
        this.removeAll();
        this.add(panel, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }

    /**
     * Creates new form Operacion1
     */
    public Operacion4() {
        initComponents();
        
    }
    
    public void llamador(){
        mostrarMayor.setText(String.valueOf(mayor(matriz)));
        mostrarMayor.setEditable(false);
        mostrarSerie.setText(generarFibonacciHasta(mayor(matriz))); 
        mostrarSerie.setEditable(false);
    }
    
    public static String generarFibonacciHasta(int limite) {
        String fibonacciSeries = "";
        
        int a = 0, b = 1;
        while (a <= limite) {
            fibonacciSeries += a + "  ";
            int temp = a + b;
            a = b;
            b = temp;
        
        }
        return fibonacciSeries;
    }
    
    public int mayor(JLabel[][] matriz){
        int mayor = Integer.parseInt(matriz[0][0].getText());
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (mayor < Integer.parseInt(matriz[i][j].getText())){
                    mayor = Integer.parseInt(matriz[i][j].getText()); 
                }
            }  
        }
        return mayor;
    }
        
    
       

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        mostrarSerie = new javax.swing.JTextPane();
        tituloLabel6 = new javax.swing.JLabel();
        tituloLabel7 = new javax.swing.JLabel();
        tituloLabel8 = new javax.swing.JLabel();
        izquierdaBtn = new javax.swing.JButton();
        mostrarMayor = new javax.swing.JTextPane();

        setBackground(new java.awt.Color(255, 255, 255));

        mostrarSerie.setFont(new java.awt.Font("Dubai Light", 1, 16)); // NOI18N
        mostrarSerie.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(mostrarSerie);

        tituloLabel6.setFont(new java.awt.Font("Dubai Light", 1, 16)); // NOI18N
        tituloLabel6.setText("      4_Serie Fibonacci hasta número mayor");

        tituloLabel7.setFont(new java.awt.Font("Dubai Light", 1, 16)); // NOI18N
        tituloLabel7.setText("Número mayor: ");

        tituloLabel8.setFont(new java.awt.Font("Dubai Light", 1, 16)); // NOI18N
        tituloLabel8.setText("Serie Fibonacci:");

        izquierdaBtn.setText("Anterior");
        izquierdaBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        izquierdaBtn.setPreferredSize(new java.awt.Dimension(79, 28));
        izquierdaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izquierdaBtnActionPerformed(evt);
            }
        });

        mostrarMayor.setFont(new java.awt.Font("Dubai Light", 1, 16)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tituloLabel8)
                    .addComponent(tituloLabel7))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(518, 518, 518)
                        .addComponent(izquierdaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mostrarMayor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(335, 335, 335)
                .addComponent(tituloLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tituloLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mostrarMayor, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                    .addComponent(izquierdaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(tituloLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(96, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void izquierdaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izquierdaBtnActionPerformed
        Operacion3 panel3 = new Operacion3();
        showPanel(panel3);
        panel3.setMatriz(matriz);
        panel3.llamador();
    }//GEN-LAST:event_izquierdaBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton izquierdaBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane mostrarMayor;
    private javax.swing.JTextPane mostrarSerie;
    private javax.swing.JLabel tituloLabel6;
    private javax.swing.JLabel tituloLabel7;
    private javax.swing.JLabel tituloLabel8;
    // End of variables declaration//GEN-END:variables
}
