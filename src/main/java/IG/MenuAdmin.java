/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package IG;

import java.awt.*;
import javax.swing.*;


/**
 *
 * @author moral
 */
public class MenuAdmin extends javax.swing.JFrame {
     private JLabel lblTitulo;
     private JPanel pnlMenuLateral;
     private JPanel pnlContenidoPrincipal;
     private CardLayout tarjetas;
     
    public MenuAdmin() {
       setTitle("Panel de Administración - Sistema de Reservas");
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setSize(900, 600);
       setLocationRelativeTo(null);
       setLayout(new BorderLayout());
      initComponentsUsuario();
     
    }
    private void initComponentsUsuario() {
     //Panel Lateral
     pnlMenuLateral = new JPanel();
     pnlMenuLateral.setBackground(new Color(45, 52, 71));
     pnlMenuLateral.setPreferredSize(new Dimension(200, 0));
     pnlMenuLateral.setLayout(new GridLayout(10, 1, 0, 5)); 
      
     //Botones del menu 
     JButton btnUsuarios = crearBotonMenu("Usuarios");
     JButton btnReservas = crearBotonMenu("Reservas");
     JButton btnRecursos = crearBotonMenu("Recursos");
     JButton btnBitacora = crearBotonMenu("Bitácora");
     
     pnlMenuLateral.add(new JLabel("  MENÚ ADMIN", JLabel.CENTER)); // Título menú
     pnlMenuLateral.add(btnUsuarios);
     pnlMenuLateral.add(btnReservas);
     pnlMenuLateral.add(btnRecursos);
     pnlMenuLateral.add(btnBitacora);
       
     //Panel derecho pantallas de edicion 
     tarjetas = new CardLayout();
     pnlContenidoPrincipal = new JPanel(tarjetas);
     pnlContenidoPrincipal.setBackground(Color.WHITE);
     
     pnlContenidoPrincipal.add(crearPanel("Bienvenido", Color.LIGHT_GRAY), "Default");
     pnlContenidoPrincipal.add(new PanelUsuarios(), "Usuarios");
     pnlContenidoPrincipal.add(new PanelReservas(), "Reservas");
     pnlContenidoPrincipal.add(crearPanel("Inventario de Recursos", Color.LIGHT_GRAY), "Recursos");
     pnlContenidoPrincipal.add(crearPanel("Bitácora de Sistema", Color.WHITE), "Bitacora");
     
     tarjetas.show(pnlContenidoPrincipal, "Default");
     btnUsuarios.addActionListener(e -> tarjetas.show(pnlContenidoPrincipal, "Usuarios"));
     btnReservas.addActionListener(e -> tarjetas.show(pnlContenidoPrincipal, "Reservas"));
     btnRecursos.addActionListener(e -> tarjetas.show(pnlContenidoPrincipal, "Recursos"));
     btnBitacora.addActionListener(e -> tarjetas.show(pnlContenidoPrincipal, "Bitacora"));
     
     add(pnlMenuLateral, BorderLayout.WEST);
     add(pnlContenidoPrincipal, BorderLayout.CENTER);
   
    }
    private JButton crearBotonMenu(String texto) {
        JButton boton = new JButton(texto);
        boton.setFocusPainted(false);
        boton.setBackground(new Color(60, 70, 92));
        boton.setForeground(Color.WHITE);
        boton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return boton;
    }
    private JPanel crearPanel(String titulo, Color color) {
        JPanel panel = new JPanel();
        panel.setBackground(color);
        panel.add(new JLabel("Estás en: " + titulo));
        return panel;
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
