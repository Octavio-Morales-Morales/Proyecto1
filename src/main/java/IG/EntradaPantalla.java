/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package IG;
import Services.UsuariosDAO;
import Model.Usuario;

import javax.swing.*;
import java.awt.*;
import static java.awt.Color.black;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.control.Alert;

/**
 *
 * @author moral
 */
public class EntradaPantalla extends javax.swing.JFrame { 
    
    private JTextField txtUsuario;
    private JLabel lblUsuario; 
    private JPasswordField contratxt;
    private JCheckBox chkVerPassword;
    private JButton btnIngresar;
    private JLabel lblContra;
    private JButton btnCrearUsuario;
    
    public EntradaPantalla() {
        initComponents();
       setTitle("Loggin");
       setLayout(null);
       this.setPreferredSize(new Dimension(400,500));
    
       //Objetos
    lblUsuario = new JLabel("Escriba su ID Usuario");
    txtUsuario = new JTextField(15);
    lblContra = new JLabel("Contraseña:");
    contratxt = new JPasswordField(15);
    contratxt.setEchoChar('*');
    chkVerPassword = new JCheckBox("Ver");
    chkVerPassword.setBackground( null);
    btnIngresar = new JButton("Ingresar");
    btnCrearUsuario = new JButton("Agregar usuario");
    
    
 //Tamaños
 lblUsuario.setBounds(100,50,200,30);
 txtUsuario.setBounds(100,85,200,35);
 lblContra.setBounds(100, 150,200, 35);
 contratxt.setBounds(100, 200, 200, 35);
 chkVerPassword.setBounds(300, 200, 20, 20);
 btnIngresar.setBounds(100, 260, 200, 45);
 btnCrearUsuario.setBounds(100, 320, 200, 45); 
 
 
    add(lblUsuario);
    add(txtUsuario);
    add(lblContra);
    add(btnIngresar);
    add(chkVerPassword);
    add(contratxt);
    add(btnCrearUsuario);
    pack(); 
    
    //Ingresar
    btnIngresar.addActionListener( e -> {
    String usuarioInput = txtUsuario.getText().trim();
    String passInput = new String(contratxt.getPassword());

    MenuAdmin AdminMenu = new MenuAdmin();
    AdminMenu.setVisible(true);
    this.dispose();   
 
    });
    
    
    //BTN ver
    chkVerPassword.addActionListener(e -> {
    if (chkVerPassword.isSelected()) {
        contratxt.setEchoChar((char) 0); 
    } else {
        contratxt.setEchoChar('*');
    }
    contratxt.repaint();
});
   
btnCrearUsuario.addActionListener(e -> {
    CrearUsuario ventanaRegistro = new CrearUsuario(); 
    ventanaRegistro.setVisible(true);
    this.dispose(); 
});  

    }    
    
      public void mostrarAlerta(String mensaje){
      JOptionPane.showMessageDialog(this, mensaje, "Validación", JOptionPane.WARNING_MESSAGE);
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

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
