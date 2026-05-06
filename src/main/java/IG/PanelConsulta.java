/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IG;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author moral
 */
public class PanelConsulta extends JPanel {
 private JTable tablaReservas;
    private DefaultTableModel modeloTabla;
    private JLabel lblUsuario;

    public PanelConsulta() {
        setLayout(new BorderLayout(15, 15));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        initEncabezado();
        initTabla();
    }

    private void initEncabezado() {
        JPanel pnlNorte = new JPanel(new BorderLayout());
        lblUsuario = new JLabel("Mis Reservas Activas - Usuario: [ID_VALIDO]");
        lblUsuario.setFont(new Font("SansSerif", Font.BOLD, 16));
        
        JButton btnRefrescar = new JButton("Actualizar Tabla");
        
        pnlNorte.add(lblUsuario, BorderLayout.WEST);
        pnlNorte.add(btnRefrescar, BorderLayout.EAST);
        add(pnlNorte, BorderLayout.NORTH);
        
        btnRefrescar.addActionListener(e -> cargarDatosReserva());
    }

    private void initTabla() {
        
        String[] columnas = {"ID Reserva", "Recurso", "Fecha Inicio", "Fecha Fin", "Motivo", "Acción"};
        
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 5; 
            }
        };

        tablaReservas = new JTable(modeloTabla);
        tablaReservas.setRowHeight(30);

        
        tablaReservas.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
        tablaReservas.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(new JCheckBox()));

        JScrollPane scroll = new JScrollPane(tablaReservas);
        add(scroll, BorderLayout.CENTER);
        
        cargarDatosReserva();
    }

    private void cargarDatosReserva() {
        modeloTabla.setRowCount(0);
        modeloTabla.addRow(new Object[]{"101", "Laptop Dell", "2023-10-01", "2023-10-05", "Proyecto Final", "Cancelar"});
        modeloTabla.addRow(new Object[]{"102", "Sala de Juntas", "2023-10-10", "2023-10-10", "Reunión", "Cancelar"});
    }

  
    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
            setForeground(Color.WHITE);
            setBackground(new Color(231, 76, 60)); 
        }
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "Cancelar" : value.toString());
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {
        protected JButton button;
        private String label;
        private boolean isPushed;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(e -> fireEditingStopped());
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            label = (value == null) ? "Cancelar" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            if (isPushed) {
           
                int fila = tablaReservas.getSelectedRow();
                String idReserva = tablaReservas.getValueAt(fila, 0).toString();
                
                int confirm = JOptionPane.showConfirmDialog(button, 
                    "¿Seguro que deseas cancelar la reserva #" + idReserva + "?", 
                    "Confirmar Cancelación", JOptionPane.YES_NO_OPTION);
                
                if (confirm == JOptionPane.YES_OPTION) {
                    
                    modeloTabla.removeRow(fila);
                    JOptionPane.showMessageDialog(button, "Reserva cancelada con éxito.");
                }
            }
            isPushed = false;
            return label;
        }
    }
}