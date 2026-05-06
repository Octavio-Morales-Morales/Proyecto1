/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package IG;

import javax.swing.*;
import java.awt.*;


/**
 *
 * @author moral
 */
public class MenuPrincipal extends javax.swing.JFrame {

     private JPanel pnlMenuLateral;
     private JPanel pnlContenidoPrincipal;
     private CardLayout tarjetas;

    public MenuPrincipal() {
       setTitle("Panel de Usuario - Sistema de Reservas UNA");
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setSize(900, 600);
       setLocationRelativeTo(null);
       setLayout(new BorderLayout());
      initComponentsUsuario();
     
    }
    private void  initComponentsUsuario(){
   
     pnlMenuLateral = new JPanel();
     pnlMenuLateral.setBackground(new Color(45, 52, 71));
     pnlMenuLateral.setPreferredSize(new Dimension(200, 0));
     pnlMenuLateral.setLayout(new GridLayout(10, 1, 0, 5)); 
 
     JButton btnReservas = crearBotonMenu("Agregar Reserva");
     JButton btnConsultaRes = crearBotonMenu("Ver Reservas");
     JButton btnPerfil = crearBotonMenu("Perfil");
    
     
     pnlMenuLateral.add(new JLabel("  MENÚ ", JLabel.CENTER)); 
     pnlMenuLateral.add(btnReservas);
     pnlMenuLateral.add(btnConsultaRes);
     pnlMenuLateral.add(btnPerfil);
     
     tarjetas = new CardLayout();
     pnlContenidoPrincipal = new JPanel(tarjetas);
     pnlContenidoPrincipal.setBackground(Color.WHITE);
     
     pnlContenidoPrincipal.add(crearPanel("Bienvenido", Color.LIGHT_GRAY), "Default");
     pnlContenidoPrincipal.add(new PanelReserva(), "Reserva");
     pnlContenidoPrincipal.add(new PanelConsulta(), "Consulta");
     pnlContenidoPrincipal.add(new PanelPerfil("69", "raul"), "Perfil");
     
     tarjetas.show(pnlContenidoPrincipal, "Default");
     
     btnReservas.addActionListener(e -> tarjetas.show(pnlContenidoPrincipal, "Reserva"));
     btnConsultaRes.addActionListener(e -> tarjetas.show(pnlContenidoPrincipal, "Consulta"));
     btnPerfil.addActionListener(e -> tarjetas.show(pnlContenidoPrincipal, "Perfil"));
     
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
