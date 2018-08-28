/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import java.util.List;
import javax.swing.JOptionPane;
import objetos.Arista;
import objetos.ManejoDatos;
import objetos.Nodo;

public class conectar extends javax.swing.JFrame {

    private ManejoDatos manejo;

    public conectar(ManejoDatos manejo) {
        this.manejo = manejo;
        initComponents();
        cargar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nodo1Box = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        nodo2Box = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        aristaBox = new javax.swing.JComboBox<>();
        guardarButton = new javax.swing.JButton();
        volverButton = new javax.swing.JButton();

        jLabel1.setText("Nodo 1:");

        jLabel2.setText("Nodo 2:");

        jLabel3.setText("Arista");

        guardarButton.setText("Guardar");
        guardarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarButtonActionPerformed(evt);
            }
        });

        volverButton.setText("Volver");
        volverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(nodo1Box, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nodo2Box, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(aristaBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(guardarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverButton)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nodo1Box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nodo2Box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(aristaBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardarButton)
                    .addComponent(volverButton))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_volverButtonActionPerformed

    private void guardarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarButtonActionPerformed
        if (manejo.insertarConexion(String.valueOf(nodo1Box.getSelectedItem()), String.valueOf(nodo2Box.getSelectedItem()), String.valueOf(aristaBox.getSelectedItem()))){
            JOptionPane.showMessageDialog(null, "Se ha creado la conexion");
        }else{
            JOptionPane.showMessageDialog(null, "No se pudo crear la conexion");
        }
    }//GEN-LAST:event_guardarButtonActionPerformed
    public void cargar() {
        cargarNodo1();
        cargarNodo2();
        cargarArista();
    }

    public void cargarNodo1() {
        List<Nodo> nodos = manejo.getNodos();
        for (int i = 0; i < nodos.size(); i++) {
            this.nodo1Box.addItem(nodos.get(i).getNombre());
        }
    }

    public void cargarNodo2() {
        List<Nodo> nodos = manejo.getNodos();
        for (int i = 0; i < nodos.size(); i++) {
            this.nodo2Box.addItem(nodos.get(i).getNombre());
        }
    }

    public void cargarArista() {
        List<Arista> aristas = manejo.getAristas();
        for (int i = 0; i < aristas.size(); i++) {
            this.aristaBox.addItem(aristas.get(i).getNombre());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> aristaBox;
    private javax.swing.JButton guardarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox<String> nodo1Box;
    private javax.swing.JComboBox<String> nodo2Box;
    private javax.swing.JButton volverButton;
    // End of variables declaration//GEN-END:variables
}
