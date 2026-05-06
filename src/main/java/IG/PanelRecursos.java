/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IG;

import Config.ConexionBD;
import Model.Equipo;
import Model.Espacio;
import Model.Recurso;
import Services.RecursosDAO;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author moral
 */
public class PanelRecursos extends JPanel{

    private JTextField txtIdRecurso, txtNombre, txtDescripcion, txtEstado;
    private JTextField txtMarca, txtSerie;
    private JTextField txtCapacidad, txtUbicacion;

    private JPanel pnlEspecífico;
    private CardLayout cardEspecífico;
    
    private JButton btnAgregar, btnEditar, btnEliminar, btnRefrescar;;
    private JTable tablaRecursos;
    private DefaultTableModel modeloTabla;
    private RecursosDAO dao = new RecursosDAO();
    
    public PanelRecursos() {
        setLayout(new BorderLayout(15, 15));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        initMenuSuperior();
        initFormularioBase();
        initTabla();
        
        configurarEventos();
        cargarDatosTabla();
        
    }

    private void initMenuSuperior() {
        JPanel pnlBotonesTipo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlBotonesTipo.setBorder(BorderFactory.createTitledBorder("Seleccione Tipo de Recurso"));

        JButton btnTipoEquipo = new JButton("Gestionar EQUIPOS");
        JButton btnTipoEspacio = new JButton("Gestionar ESPACIOS");

        pnlBotonesTipo.add(btnTipoEquipo);
        pnlBotonesTipo.add(btnTipoEspacio);

        btnTipoEquipo.addActionListener(e -> cardEspecífico.show(pnlEspecífico, "EQUIPO"));
        btnTipoEspacio.addActionListener(e -> cardEspecífico.show(pnlEspecífico, "ESPACIO"));

        add(pnlBotonesTipo, BorderLayout.NORTH);
    }

    private void initFormularioBase() {
        JPanel pnlIzquierdo = new JPanel(new BorderLayout(10, 10));
        pnlIzquierdo.setPreferredSize(new Dimension(300, 0));

        JPanel pnlGeneral = new JPanel(new GridLayout(8, 1, 2, 2));
        pnlGeneral.setBorder(BorderFactory.createTitledBorder("Datos Generales"));
        
        txtIdRecurso = new JTextField();
        txtNombre = new JTextField();
        txtDescripcion = new JTextField();
        txtEstado = new JTextField();

        pnlGeneral.add(new JLabel("ID Recurso:"));
        pnlGeneral.add(txtIdRecurso);
        pnlGeneral.add(new JLabel("Nombre:"));
        pnlGeneral.add(txtNombre);
        pnlGeneral.add(new JLabel("Descripción:"));
        pnlGeneral.add(txtDescripcion);
        pnlGeneral.add(new JLabel("Estado:"));
        pnlGeneral.add(txtEstado);

        cardEspecífico = new CardLayout();
        pnlEspecífico = new JPanel(cardEspecífico);

        JPanel pnlEquipo = new JPanel(new GridLayout(4, 1, 2, 2));
        pnlEquipo.setBorder(BorderFactory.createTitledBorder("Detalle Equipo"));
        txtMarca = new JTextField();
        txtSerie = new JTextField();
        pnlEquipo.add(new JLabel("Marca:"));
        pnlEquipo.add(txtMarca);
        pnlEquipo.add(new JLabel("Serie:"));
        pnlEquipo.add(txtSerie);

        JPanel pnlEspacio = new JPanel(new GridLayout(4, 1, 2, 2));
        pnlEspacio.setBorder(BorderFactory.createTitledBorder("Detalle Espacio"));
        txtCapacidad = new JTextField();
        txtUbicacion = new JTextField();
        pnlEspacio.add(new JLabel("Capacidad:"));
        pnlEspacio.add(txtCapacidad);
        pnlEspacio.add(new JLabel("Ubicación:"));
        pnlEspacio.add(txtUbicacion);

        pnlEspecífico.add(pnlEquipo, "EQUIPO");
        pnlEspecífico.add(pnlEspacio, "ESPACIO");

        JPanel pnlAcciones = new JPanel(new GridLayout(3, 1, 5, 5));
        btnAgregar = new JButton("Guardar Recurso");
        btnEditar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");
        pnlAcciones.add(btnAgregar);
        pnlAcciones.add(btnEditar);
        pnlAcciones.add(btnEliminar);

        JPanel pnlFormCompleto = new JPanel(new BorderLayout());
        pnlFormCompleto.add(pnlGeneral, BorderLayout.NORTH);
        pnlFormCompleto.add(pnlEspecífico, BorderLayout.CENTER);
        pnlFormCompleto.add(pnlAcciones, BorderLayout.SOUTH);

        pnlIzquierdo.add(pnlFormCompleto, BorderLayout.CENTER);
        add(pnlIzquierdo, BorderLayout.WEST);
    }

    private void initTabla() {
        JPanel pnlCabeceraTabla = new JPanel(new BorderLayout());
        JLabel lblTitulo = new JLabel("Lista de Usuarios Registrados");
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 12));
        
        btnRefrescar = new JButton(" Refrescar");
        pnlCabeceraTabla.add(lblTitulo,BorderLayout.WEST );
        pnlCabeceraTabla.add(btnRefrescar, BorderLayout.EAST);

        String[] columnas = {"ID", "Nombre", "Tipo", "Estado", "Extra"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaRecursos = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tablaRecursos);
        scroll.setBorder(BorderFactory.createTitledBorder("Inventario de Recursos"));
        add(scroll, BorderLayout.CENTER);
        JPanel pnlDerecho = new JPanel(new BorderLayout(5, 5));
        pnlDerecho.add(pnlCabeceraTabla, BorderLayout.NORTH);
        pnlDerecho.add(new JScrollPane(tablaRecursos), BorderLayout.CENTER);

        add(pnlDerecho, BorderLayout.CENTER);
    }

    
     private void cargarDatosTabla() {
        modeloTabla.setRowCount(0);
        List<Recurso> lista = dao.ListaRecursos();
        for (Recurso r : lista) {
            modeloTabla.addRow(new Object[]{r.getIdRecurso(), r.getNombre(), "GENERAL", r.getEstado(), r.getDescripcion()});
        }
    }
         private void configurarEventos() {
             
        btnAgregar.addActionListener(e -> {
            Recurso r;
        if (pnlEspecífico.getComponent(0).isVisible()) { 
        Equipo eq = new Equipo();
        eq.setMarcaEquipo(txtMarca.getText());
        eq.setSerieEquipo(txtSerie.getText());
        r = eq;
        }else {
        Espacio es = new Espacio();
        es.setcapacidadEspacio(Long.parseLong(txtCapacidad.getText()));
        es.setUbicacionEspacio(txtUbicacion.getText());
        r = es;  
        }
        
            r.setIdRecurso(Long.parseLong(txtIdRecurso.getText()));
            r.setNombre(txtNombre.getText());
            r.setDescripcion(txtDescripcion.getText());
            r.setEstado(txtEstado.getText());
            
            try {
            dao.InsertarRecurso(r);
            cargarDatosTabla();
            limpiarCampos();
            
            } catch (SQLException ex) {
                System.getLogger(PanelRecursos.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        });

        btnEliminar.addActionListener(e -> {
       if (txtIdRecurso.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione un recurso de la tabla o ingrese un ID.");
        return;
       
    }

    try {
        Recurso r = new Recurso() {}; 
        r.setIdRecurso(Long.parseLong(txtIdRecurso.getText()));

        int confirmacion = JOptionPane.showConfirmDialog(this, 
                "¿Está seguro de eliminar este recurso? Se borrarán sus datos técnicos también.", 
                "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            if (dao.EliminarRecurso(r)) {
                JOptionPane.showMessageDialog(this, "Recurso eliminado correctamente.");
                cargarDatosTabla();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo eliminar. Verifique si el ID existe.");
            }
        }

    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "El ID debe ser un número válido.");
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error al procesar la eliminación: " + ex.getMessage());
    }
});
         btnRefrescar.addActionListener(e -> cargarDatosTabla());

        tablaRecursos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tablaRecursos.getSelectedRow() != -1) {
                int fila = tablaRecursos.getSelectedRow();
                txtIdRecurso.setText(modeloTabla.getValueAt(fila, 0).toString());
                txtNombre.setText(modeloTabla.getValueAt(fila, 1).toString());
                txtEstado.setText(modeloTabla.getValueAt(fila, 3).toString());
                txtDescripcion.setText(modeloTabla.getValueAt(fila, 4).toString());
            }
        });
    }

    private void limpiarCampos() {
        txtIdRecurso.setText("");
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtEstado.setText("");
        txtMarca.setText("");
        txtSerie.setText("");
        txtCapacidad.setText("");
        txtUbicacion.setText("");
    }
    
    
}
