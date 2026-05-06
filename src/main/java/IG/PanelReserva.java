/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IG;

import com.toedter.calendar.JDateChooser; 
import java.awt.*;
import java.util.Date;
import javax.swing.*;

/**
 *
 * @author moral
 */
public class PanelReserva extends JPanel {

    private JTextField txtIdReserva, txtIdUsuario, txtMotivo;
    private JDateChooser jdFechaInicio, jdFechaFin;
    private JTextField txtNombre, txtEstado, txtMarca, txtSerie, txtCapacidad, txtUbicacion;
    private JPanel pnlEspecífico;
    private CardLayout cardEspecífico;
    private JButton btnAgregarReserva;
    private JList<String> listaDisponibles;
    private DefaultListModel<String> modeloLista;

    public PanelReserva() {
        setLayout(new BorderLayout(15, 15));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        initMenuSuperior();     
        initCuerpoCentral();   
    }

    private void initMenuSuperior() {
        JPanel pnlBotonesTipo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlBotonesTipo.setBorder(BorderFactory.createTitledBorder("1. Seleccione el Tipo de Recurso"));

        JButton btnTipoEquipo = new JButton("Ver Equipos Disponibles");
        JButton btnTipoEspacio = new JButton("Ver Espacios Disponibles");

        pnlBotonesTipo.add(btnTipoEquipo);
        pnlBotonesTipo.add(btnTipoEspacio);

        btnTipoEquipo.addActionListener(e -> {
            cardEspecífico.show(pnlEspecífico, "EQUIPO");
            cargarLista("EQUIPO");
        });
        btnTipoEspacio.addActionListener(e -> {
            cardEspecífico.show(pnlEspecífico, "ESPACIO");
            cargarLista("ESPACIO");
        });

        add(pnlBotonesTipo, BorderLayout.NORTH);
    }

    private void initCuerpoCentral() {
        JPanel pnlContenedor = new JPanel(new BorderLayout(15, 15));

        JPanel pnlLista = new JPanel(new BorderLayout());
        pnlLista.setBorder(BorderFactory.createTitledBorder("2. Disponibles"));
        pnlLista.setPreferredSize(new Dimension(200, 0));
        
        modeloLista = new DefaultListModel<>();
        listaDisponibles = new JList<>(modeloLista);
        pnlLista.add(new JScrollPane(listaDisponibles), BorderLayout.CENTER);

        JPanel pnlFormulario = new JPanel(new BorderLayout(10, 10));

        JPanel pnlDetalles = new JPanel(new BorderLayout());
        pnlDetalles.setBorder(BorderFactory.createTitledBorder("Información Técnica"));
        
        JPanel pnlGeneral = new JPanel(new GridLayout(2, 2, 5, 5));
        txtNombre = new JTextField(); txtNombre.setEditable(false);
        txtEstado = new JTextField(); txtEstado.setEditable(false);
        pnlGeneral.add(new JLabel("Nombre:")); pnlGeneral.add(txtNombre);
        pnlGeneral.add(new JLabel("Estado:")); pnlGeneral.add(txtEstado);

        cardEspecífico = new CardLayout();
        pnlEspecífico = new JPanel(cardEspecífico);

        JPanel pnlEquipo = new JPanel(new GridLayout(2, 2, 5, 5));
        txtMarca = new JTextField(); txtMarca.setEditable(false);
        txtSerie = new JTextField(); txtSerie.setEditable(false);
        pnlEquipo.add(new JLabel("Marca:")); pnlEquipo.add(txtMarca);
        pnlEquipo.add(new JLabel("Serie:")); pnlEquipo.add(txtSerie);

        JPanel pnlEspacio = new JPanel(new GridLayout(2, 2, 5, 5));
        txtCapacidad = new JTextField(); txtCapacidad.setEditable(false);
        txtUbicacion = new JTextField(); txtUbicacion.setEditable(false);
        pnlEspacio.add(new JLabel("Capacidad:")); pnlEspacio.add(txtCapacidad);
        pnlEspacio.add(new JLabel("Ubicación:")); pnlEspacio.add(txtUbicacion);

        pnlEspecífico.add(pnlEquipo, "EQUIPO");
        pnlEspecífico.add(pnlEspacio, "ESPACIO");
        
        pnlDetalles.add(pnlGeneral, BorderLayout.NORTH);
        pnlDetalles.add(pnlEspecífico, BorderLayout.CENTER);

        JPanel pnlReservaFields = new JPanel(new GridLayout(5, 2, 5, 5));
        pnlReservaFields.setBorder(BorderFactory.createTitledBorder("3. Completar Reserva"));
        
        txtIdUsuario = new JTextField();
        jdFechaInicio = new JDateChooser();
        jdFechaInicio.setDateFormatString("yyyy-MM-dd");
        jdFechaInicio.setDate(new Date());
        jdFechaFin = new JDateChooser();
        jdFechaFin.setDateFormatString("yyyy-MM-dd");
        txtMotivo = new JTextField();
        btnAgregarReserva = new JButton("CONFIRMAR RESERVA");
        btnAgregarReserva.setBackground(new Color(0, 153, 76));
        btnAgregarReserva.setForeground(Color.WHITE);

        pnlReservaFields.add(new JLabel("ID Usuario:")); pnlReservaFields.add(txtIdUsuario);
        pnlReservaFields.add(new JLabel("Fecha Inicio:")); pnlReservaFields.add(jdFechaInicio);
        pnlReservaFields.add(new JLabel("Fecha Fin:")); pnlReservaFields.add(jdFechaFin);
        pnlReservaFields.add(new JLabel("Motivo:")); pnlReservaFields.add(txtMotivo);
        pnlReservaFields.add(new JLabel("")); pnlReservaFields.add(btnAgregarReserva);

        pnlFormulario.add(pnlDetalles, BorderLayout.NORTH);
        pnlFormulario.add(pnlReservaFields, BorderLayout.CENTER);

        pnlContenedor.add(pnlLista, BorderLayout.WEST);
        pnlContenedor.add(pnlFormulario, BorderLayout.CENTER);
        
        add(pnlContenedor, BorderLayout.CENTER);
    }

    private void cargarLista(String tipo) {
        modeloLista.clear();
        modeloLista.addElement(tipo + " - Disponible 1");
        modeloLista.addElement(tipo + " - Disponible 2");
    }
}
