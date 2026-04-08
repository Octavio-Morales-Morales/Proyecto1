/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package IG;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.Usuario;
/**
 *
 * @author moral
 */
public class MenuPrincipal extends javax.swing.JFrame {
//meter roles, para hacer los if 

    public MenuPrincipal() {
       
        initComponents();
        setTitle("Menu");
       setSize(600, 400);
       setLocationRelativeTo(null);
      setLayout(new GridLayout(1, 2,20,20));
 JPanel panel1 = CrearPanel("/Recursos/Espacio.jpeg","Opción Espacio", e ->{
new PantallaEspacios().setVisible(true);
this.dispose();
 });  
 JPanel panel2 = CrearPanel("/Recursos/Equipo.jpg","Opción Equipo", e ->{
//new PantallaEspacios().setVisible(true);

 }); 
 
       add(panel1);
       add(panel2);
    }
    private JPanel CrearPanel(String ruta, String texto, ActionListener accion){
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
    //Boton
   JButton boton = CrearBtnImagen(ruta);
   boton.addActionListener(accion);
   boton.setAlignmentX(Component.CENTER_ALIGNMENT);
   //Etiqueta
   JLabel TP_reserva = new JLabel(texto);
   TP_reserva.setFont(new Font("Arial",Font.BOLD,16));
   TP_reserva.setAlignmentX(Component.CENTER_ALIGNMENT);
   panel.add(Box.createVerticalGlue()); 
    panel.add(boton);
    panel.add(Box.createRigidArea(new Dimension(0, 10))); 
    panel.add(TP_reserva);
    panel.add(Box.createVerticalGlue());
       return panel; 
    }
    
    
    
    private JButton CrearBtnImagen(String ruta){

        ImageIcon icono = new ImageIcon(getClass().getResource(ruta));
        Image img = icono.getImage().getScaledInstance(200, -1, Image.SCALE_SMOOTH);
        JButton boton = new JButton(new ImageIcon(img));
        boton.setBorderPainted(false);
        boton.setContentAreaFilled(false);
        boton.setFocusPainted(false);
        
        return boton;
        
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
