/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IG;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author moral
 */
public class PanelPerfil extends JPanel {
 private JLabel lblIdUsuario, lblNombreUsuario;
    private JButton btnCerrarSesion;
public PanelPerfil() {
    this("000", "Usuario General"); 
}
    public PanelPerfil(String id, String nombre) {
        setLayout(new GridBagLayout()); 
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setBackground(new Color(245, 245, 245));

        initComponentes(id, nombre);
    }

    private void initComponentes(String id, String nombre) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new java.awt.Insets(10, 10, 10, 10);
        gbc.gridx = 0;

        JLabel lblTitulo = new JLabel("MI PERFIL");
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 24));
        gbc.gridy = 0;
        add(lblTitulo, gbc);

        JPanel pnlDatos = new JPanel(new GridLayout(2, 2, 10, 20));
        pnlDatos.setOpaque(false);
        
        JLabel l1 = new JLabel("ID Usuario:");
        l1.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblIdUsuario = new JLabel(id);
        lblIdUsuario.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JLabel l2 = new JLabel("Nombre:");
        l2.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblNombreUsuario = new JLabel(nombre);
        lblNombreUsuario.setFont(new Font("SansSerif", Font.PLAIN, 14));

        pnlDatos.add(l1); pnlDatos.add(lblIdUsuario);
        pnlDatos.add(l2); pnlDatos.add(lblNombreUsuario);

        gbc.gridy = 1;
        add(pnlDatos, gbc);

        btnCerrarSesion = new JButton("CERRAR SESIÓN");
        btnCerrarSesion.setBackground(new Color(192, 57, 43)); 
        btnCerrarSesion.setForeground(Color.WHITE);
        btnCerrarSesion.setFocusPainted(false);
        btnCerrarSesion.setPreferredSize(new Dimension(150, 40));

        gbc.gridy = 2;
        gbc.insets = new java.awt.Insets(40, 10, 10, 10);
        add(btnCerrarSesion, gbc);

        btnCerrarSesion.addActionListener(e -> {
            int respuesta = JOptionPane.showConfirmDialog(this, 
                "¿Estás seguro de que deseas cerrar sesión?", 
                "Cerrar Sesión", JOptionPane.YES_NO_OPTION);
            
            if (respuesta == JOptionPane.YES_OPTION) {
                cerrarYVolverAlLogin();
            }
        });
    }

    private void cerrarYVolverAlLogin() {
 
        Window ventanaActual = SwingUtilities.getWindowAncestor(this);
        ventanaActual.dispose();

  
        new EntradaPantalla().setVisible(true); 
        System.out.println("Redirigiendo al Login..."); 
    }
}
