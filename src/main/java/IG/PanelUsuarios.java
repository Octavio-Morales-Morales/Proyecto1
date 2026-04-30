/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IG;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author moral
 */
public class PanelUsuarios extends JPanel{
 private JTextField txtId, txtNombre, txtPassword, txtRol;
 private JButton btnAgregar, btnEditar, btnEliminar;
 private JTable tablaUsuarios;
 private DefaultTableModel modeloTabla;
 
    public PanelUsuarios() {
       setLayout(new BorderLayout(15, 15));
       setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); 
       
       initFormulario();
       initTabla();
       
    }

        private void initFormulario() {
        JPanel pnlDatos = new JPanel(new GridLayout(8, 1, 5, 5));
        pnlDatos.setBorder(BorderFactory.createTitledBorder("Gestión de Usuario"));
        
        txtId = new JTextField();
        txtNombre = new JTextField();
        txtPassword = new JTextField();
        txtRol = new JTextField();
        
        pnlDatos.add(new JLabel("ID Usuario (Long):"));
        pnlDatos.add(txtId);
        pnlDatos.add(new JLabel("Nombre de Usuario:"));
        pnlDatos.add(txtNombre);
        pnlDatos.add(new JLabel("Contraseña:"));
        pnlDatos.add(txtPassword);
        pnlDatos.add(new JLabel("ID Rol (1=Admin, 2=User):"));
        pnlDatos.add(txtRol);

        JPanel pnlBotones = new JPanel(new GridLayout(3, 1, 5, 5));
        btnAgregar = new JButton("Agregar Usuario");
        btnEditar = new JButton("Actualizar Datos");
        btnEliminar = new JButton("Eliminar Usuario");
        
        pnlBotones.add(btnAgregar);
        pnlBotones.add(btnEditar);
        pnlBotones.add(btnEliminar);
        
        JPanel pnlIzquierdo = new JPanel(new BorderLayout(10, 10));
        pnlIzquierdo.add(pnlDatos, BorderLayout.CENTER);
        pnlIzquierdo.add(pnlBotones, BorderLayout.SOUTH);
        pnlIzquierdo.setPreferredSize(new Dimension(250, 0));

        add(pnlIzquierdo, BorderLayout.WEST);
    }
        

        private void initTabla() {
         String[] columnas = {"ID", "Nombre", "Rol"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaUsuarios = new JTable(modeloTabla);
        
        // ScrollPane para que la tabla tenga barras y cabecera
        JScrollPane scroll = new JScrollPane(tablaUsuarios);
        scroll.setBorder(BorderFactory.createTitledBorder("Lista de Usuarios Registrados"));

        add(scroll, BorderLayout.CENTER);
    }

}

