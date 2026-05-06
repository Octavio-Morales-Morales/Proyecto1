/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IG;

import Model.Usuario;
import Services.UsuariosDAO;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author moral
 */
public class PanelUsuarios extends JPanel{
 private JTextField txtId, txtNombre, txtPassword, txtRol;
 private JButton btnAgregar, btnEditar, btnEliminar, btnRefrescar;
 private JTable tablaUsuarios;
 private DefaultTableModel modeloTabla;
 private UsuariosDAO dao = new UsuariosDAO();
 private List<Usuario> lista = new ArrayList<>();
 
    public PanelUsuarios() {
       setLayout(new BorderLayout(15, 15));
       setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); 
       
       initFormulario();
       initTabla();
       configurarEventos();
      cargarDatosTabla();
       
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
        JPanel pnlCabeceraTabla = new JPanel(new BorderLayout());
        JLabel lblTitulo = new JLabel("Lista de Usuarios Registrados");
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 12));
        
        btnRefrescar = new JButton(" Refrescar");
        pnlCabeceraTabla.add(lblTitulo, BorderLayout.WEST);
        pnlCabeceraTabla.add(btnRefrescar, BorderLayout.EAST);

        String[] columnas = {"ID", "Nombre", "Rol"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaUsuarios = new JTable(modeloTabla);

        JPanel pnlDerecho = new JPanel(new BorderLayout(5, 5));
        pnlDerecho.add(pnlCabeceraTabla, BorderLayout.NORTH);
        pnlDerecho.add(new JScrollPane(tablaUsuarios), BorderLayout.CENTER);

        add(pnlDerecho, BorderLayout.CENTER);
    }
          private void cargarDatosTabla() {
        modeloTabla.setRowCount(0);
        
     lista = dao.obtenerListaUsuarios();
        for (Usuario u : lista) {
            modeloTabla.addRow(new Object[]{u.getIdUsuario(), u.getNombreUsuario(), u.getIDRolUsuario()});
        }
          }
          
        private void configurarEventos(){
            
           btnAgregar.addActionListener(e -> {
               
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(Long.parseLong(txtId.getText()));
            usuario.setNombreUsuario(txtNombre.getText());
            usuario.setContraseña(txtPassword.getText());
            usuario.setIDRolUsuario(Long.parseLong(txtRol.getText()));
            
            dao.InsertarUsuario(usuario);
            cargarDatosTabla();
            limpiarCampos();
            
        });

        btnEditar.addActionListener(e -> {
            Usuario u = new Usuario();
            u.setIdUsuario(Long.parseLong(txtId.getText()));
            u.setNombreUsuario(txtNombre.getText());
            u.setContraseña(txtPassword.getText());
            u.setIDRolUsuario(Long.parseLong(txtRol.getText()));
            
            if(dao.EditarUsuario(u)) {
                JOptionPane.showMessageDialog(this, "Usuario Actualizado");
                cargarDatosTabla();
            }
        });

        btnEliminar.addActionListener(e -> {
            Usuario u = new Usuario();
            u.setIdUsuario(Long.parseLong(txtId.getText()));
            if(dao.EliminarUsuario(u)) {
                cargarDatosTabla();
                limpiarCampos();
            }
        });

        btnRefrescar.addActionListener(e -> cargarDatosTabla());
        
        tablaUsuarios.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tablaUsuarios.getSelectedRow() != -1) {
                int fila = tablaUsuarios.getSelectedRow();
                txtId.setText(modeloTabla.getValueAt(fila, 0).toString());
                txtNombre.setText(modeloTabla.getValueAt(fila, 1).toString());
                txtRol.setText(modeloTabla.getValueAt(fila, 2).toString());
            }
        });
        }

    private void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        txtPassword.setText("");
        txtRol.setText("");
    }

    

}


