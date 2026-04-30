/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IG;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;
/**
 *
 * @author moral
 */
public class PanelReservas extends JPanel {
private JTextField txtIdReserva, txtIdUsuario, txtEstado, txtMotivo, txtIdRecurso;
private JDateChooser jdFechaInicio, jdFechaFin;
private JButton btnAgregar, btnEditar, btnEliminar;
private JTable tablaReservas;
private DefaultTableModel modeloTabla;

    public PanelReservas() {
        setLayout(new BorderLayout(15, 15));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        initFormulario();
        initTabla();
    }

    private void initFormulario() {
        JPanel pnlDatos = new JPanel(new GridLayout(14, 1, 2, 2));
        pnlDatos.setBorder(BorderFactory.createTitledBorder("Gestión de Reservas"));

        txtIdReserva = new JTextField();
        txtIdUsuario = new JTextField();
        txtEstado = new JTextField();
        txtMotivo = new JTextField();
        txtIdRecurso = new JTextField();

        // Inicializamos los calendarios
        jdFechaInicio = new JDateChooser();
        jdFechaInicio.setDateFormatString("dd/MM/yyyy"); // Formato visual
        
        jdFechaFin = new JDateChooser();
        jdFechaFin.setDateFormatString("dd/MM/yyyy");

        pnlDatos.add(new JLabel("ID Reserva:"));
        pnlDatos.add(txtIdReserva);
        pnlDatos.add(new JLabel("ID Usuario:"));
        pnlDatos.add(txtIdUsuario);
        pnlDatos.add(new JLabel("Fecha Inicio:"));
        pnlDatos.add(jdFechaInicio); // Agregamos el calendario
        pnlDatos.add(new JLabel("Fecha Fin:"));
        pnlDatos.add(jdFechaFin);    // Agregamos el calendario
        pnlDatos.add(new JLabel("Estado:"));
        pnlDatos.add(txtEstado);
        pnlDatos.add(new JLabel("Motivo:"));
        pnlDatos.add(txtMotivo);
        pnlDatos.add(new JLabel("ID Recurso:"));
        pnlDatos.add(txtIdRecurso);

        // ... resto de botones y panel izquierdo (igual que el anterior) ...
        JPanel pnlBotones = new JPanel(new GridLayout(3, 1, 5, 5));
        btnAgregar = new JButton("Registrar Reserva");
        btnEditar = new JButton("Modificar Reserva");
        btnEliminar = new JButton("Cancelar/Eliminar");
        
        btnAgregar.setBackground(new Color(46, 204, 113));
        btnEditar.setBackground(new Color(52, 152, 219));
        btnEliminar.setBackground(new Color(231, 76, 60));
        btnAgregar.setForeground(Color.WHITE);
        btnEditar.setForeground(Color.WHITE);
        btnEliminar.setForeground(Color.WHITE);

        pnlBotones.add(btnAgregar);
        pnlBotones.add(btnEditar);
        pnlBotones.add(btnEliminar);

        JPanel pnlIzquierdo = new JPanel(new BorderLayout(10, 10));
        pnlIzquierdo.add(pnlDatos, BorderLayout.CENTER);
        pnlIzquierdo.add(pnlBotones, BorderLayout.SOUTH);
        pnlIzquierdo.setPreferredSize(new Dimension(280, 0));

        add(pnlIzquierdo, BorderLayout.WEST);
    }

    private void initTabla() {
        String[] columnas = {"ID", "Usuario", "Inicio", "Fin", "Estado", "Motivo", "Recurso"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaReservas = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tablaReservas);
        scroll.setBorder(BorderFactory.createTitledBorder("Historial de Reservas"));
        add(scroll, BorderLayout.CENTER);
    }
}
