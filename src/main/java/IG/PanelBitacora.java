/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IG;

import com.toedter.calendar.JDateChooser;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author moral
 */
public class PanelBitacora extends JPanel{

    private JTextField txtBuscarUsuario, txtBuscarReserva;
    private JDateChooser jdFechaFiltro;
    private JButton btnFiltrar, btnLimpiar;

    private JTable tablaBitacora;
    private DefaultTableModel modeloTabla;

    public PanelBitacora() {
        setLayout(new BorderLayout(15, 15));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        initCabeceraFiltros();
        initTabla();
    }

    private void initCabeceraFiltros() {
        JPanel pnlFiltros = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        pnlFiltros.setBorder(BorderFactory.createTitledBorder("Filtros de Auditoría"));

        txtBuscarUsuario = new JTextField(10);
        txtBuscarReserva = new JTextField(10);
        jdFechaFiltro = new JDateChooser();
        jdFechaFiltro.setPreferredSize(new Dimension(120, 20));
        
        btnFiltrar = new JButton("Filtrar");
        btnLimpiar = new JButton("Refrescar");

        pnlFiltros.add(new JLabel("ID Usuario:"));
        pnlFiltros.add(txtBuscarUsuario);
        pnlFiltros.add(new JLabel("ID Reserva:"));
        pnlFiltros.add(txtBuscarReserva);
        pnlFiltros.add(new JLabel("Fecha:"));
        pnlFiltros.add(jdFechaFiltro);
        pnlFiltros.add(btnFiltrar);
        pnlFiltros.add(btnLimpiar);

        add(pnlFiltros, BorderLayout.NORTH);
    }

    private void initTabla() {
        String[] columnas = {
            "ID REGISTRO", 
            "ID RESERVA", 
            "ID USUARIO", 
            "ESTADO RES", 
            "DETALLE", 
            "FECHA REGISTRO"
        };

        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaBitacora = new JTable(modeloTabla);
        
        tablaBitacora.setDefaultEditor(Object.class, null);
        
        tablaBitacora.getColumnModel().getColumn(4).setPreferredWidth(200); // Columna Detalle más ancha

        JScrollPane scroll = new JScrollPane(tablaBitacora);
        scroll.setBorder(BorderFactory.createTitledBorder("Registros de Actividad del Sistema"));

        add(scroll, BorderLayout.CENTER);
    }
}
