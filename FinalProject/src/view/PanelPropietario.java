/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.PropietarioController;
import dao.IPropietarioDAO;
import dao.PropietarioDAO;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import model.Propietario;

/**
 *
 * @author diani
 */
public class PanelPropietario extends JPanel {

    private JLabel jLabelTitulo;
    JTable table = new JTable();
    JScrollPane jsp = new JScrollPane(table);
    PropietarioController controller;
    private boolean editable;

    public PanelPropietario() {
        IPropietarioDAO control = new PropietarioDAO();
        controller = new PropietarioController(control);
        initComponents();
        cargarPropietarios();
    }

    public void cargarPropietarios() {
        table.setModel(controller.consultarPropietarios());
        table.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 14));
        table.setFont(new java.awt.Font("Tahoma", 0, 12));
        adjustTextToTable();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        jLabelTitulo = new JLabel("Owner management", SwingConstants.CENTER);
        add(jLabelTitulo, BorderLayout.NORTH);
        Font aux = jLabelTitulo.getFont();
        jLabelTitulo.setFont(new Font(aux.getFontName(), aux.getStyle(), 20));
        editable = false;
        table = new JTable() {
            @Override
            public boolean isCellEditable(int row, int col) {
                if (col == 0) {
                    return editable;
                }
                return true;
            }
        };
        jsp = new JScrollPane(table);
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem deleteItem = new JMenuItem("Delete selected row..."); // try to setup a buttom
        //lambda
        deleteItem.addActionListener((ActionEvent e) -> {
            removeSelectedRows(table);
        });
        popupMenu.add(deleteItem);

        JMenuItem addItem = new JMenuItem("Add...");
        addItem.addActionListener((ActionEvent e) -> {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            editable = true;
            model.addRow(new Object[]{"Id", "Username", "Last name", "First name", "Phone number"});
        });
        popupMenu.add(addItem);

        table.setComponentPopupMenu(popupMenu);
        TableCellListener tcl = new TableCellListener(table, action);
        add(jsp, BorderLayout.AFTER_LAST_LINE);
    }

    Action action = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            TableCellListener tcl = (TableCellListener) e.getSource();
            System.out.println("Row   : " + tcl.getRow());
            System.out.println("Column: " + tcl.getColumn());
            System.out.println("Old   : " + tcl.getOldValue());
            System.out.println("New   : " + tcl.getNewValue());
            String oldValue = tcl.getOldValue().toString();
            if (!oldValue.equals("Id") && !oldValue.equals("Username") && !oldValue.equals("Last name") && !oldValue.equals("First name")) {
                if (!oldValue.equals("Phone number")) {
                    try {
                        int propId = Integer.parseInt(table.getModel().getValueAt(tcl.getRow(), 0).toString());
                        String propUsuario = table.getModel().getValueAt(tcl.getRow(), 1).toString();
                        String propApellido = table.getModel().getValueAt(tcl.getRow(), 1).toString();
                        String propNombre = table.getModel().getValueAt(tcl.getRow(), 1).toString();
                        String propTelefono = table.getModel().getValueAt(tcl.getRow(), 1).toString();
//                        int mascotaId = 1; //by now!
//                        int citaId = 1; //by now!
                        Propietario p = new Propietario(propId, propUsuario, propApellido, propNombre, propTelefono);
                        controller.actualizarPropietario(p);
                    } catch (Exception NumberFormatException) { // check for logic, could be propUsuario validation, not enter digits!
//                        JOptionPane.showMessageDialog(null, "El año debe ser un número! "); //check for logic
                    }
                } else {
                    int propId = Integer.parseInt(table.getModel().getValueAt(tcl.getRow(), 0).toString());
                    String propUsuario = table.getModel().getValueAt(tcl.getRow(), 1).toString();
                    String propApellido = table.getModel().getValueAt(tcl.getRow(), 1).toString();
                    String propNombre = table.getModel().getValueAt(tcl.getRow(), 1).toString();
                    String propTelefono = table.getModel().getValueAt(tcl.getRow(), 1).toString();
                    Propietario p = new Propietario(propId, propUsuario, propApellido, propNombre, propTelefono);
                    controller.agregarPropietario(p);
                    editable = false;
                }
            }
        }
    };

    private void adjustTextToTable() { //check here to setup with margen
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            if (width > 300) { //check this values
                width = 300;
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }

    private void removeSelectedRows(JTable table) {
        DefaultTableModel model = (DefaultTableModel) this.table.getModel();
        int column = 0;
        int row = table.getSelectedRow();
        String value = model.getValueAt(row, column).toString();
        controller.eliminarPropietario(Integer.parseInt(value));
        model.removeRow(row);
    }
}
