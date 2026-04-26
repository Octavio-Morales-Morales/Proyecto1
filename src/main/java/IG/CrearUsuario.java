/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package IG;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author moral
 */

    //(ID_USUARIO, NOMBRE_USUARIO, CONTRASEÑA_USUARIO, ID_ROL)
    
public class CrearUsuario extends javax.swing.JFrame {
 private JTextField txtId, txtNombre;
 private JPasswordField txtPass;
 private JButton btnGuardar, btnVolver;
 
    public CrearUsuario() {
        setTitle("Registro de Usuario");
        setLayout(null);
        this.setPreferredSize(new Dimension(400, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        txtId = new JTextField();
        txtNombre = new JTextField();
        txtPass = new JPasswordField();
        btnGuardar = new JButton("Guardar Usuario");
        btnVolver = new JButton("Volver");
        
        
        JLabel lblId = new JLabel("ID Usuario:");
        lblId.setBounds(100, 30, 200, 25);
        txtId.setBounds(100, 55, 200, 35);

        JLabel lblNom = new JLabel("Nombre:");
        lblNom.setBounds(100, 100, 200, 25);
        txtNombre.setBounds(100, 125, 200, 35);

        JLabel lblPass = new JLabel("Contraseña:");
        lblPass.setBounds(100, 170, 200, 25);
        txtPass.setBounds(100, 195, 200, 35);
        
        btnGuardar.setBounds(100, 330, 200, 45);
        btnVolver.setBounds(100, 390, 200, 40); 
        
        add(lblId); add(txtId);
        add(lblNom); add(txtNombre);
        add(lblPass); add(txtPass);
 
        add(btnGuardar); 
        add(btnVolver);

        pack();
        setLocationRelativeTo(null);
        
        btnVolver.addActionListener(e -> {
            new EntradaPantalla().setVisible(true);
            this.dispose();
        });
        
        btnGuardar.addActionListener(e -> {
            String password = new String(txtPass.getPassword());
            JOptionPane.showMessageDialog(this, "Usuario " + txtNombre.getText() + " registrado con éxito.");
        });
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
