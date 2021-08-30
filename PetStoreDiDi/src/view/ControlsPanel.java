/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.InitialData;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import model.PetSummaryModel;

/**
 *
 * @author diani
 */
public class ControlsPanel extends JPanel {

    private JLabel lblOwnerLastName;
    private JTextField txtOwnerLastName;
    private JButton btnSearchOwner;
    private JButton btnAddOwner;
    private JTable tblResults;
    private JLabel jLabelTitulo;
    private JScrollPane jsp;

    /**
     * Constructor of the ControlsPanel class.
     *
     * @param resultsPanel
     */
    public ControlsPanel(ResultsPanel resultsPanel) {
        this.tblResults = resultsPanel.getTblResults();
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridLayout(2, 1));
//        setLayout(new BorderLayout());
//        jsp = new JScrollPane(tblResults);
        InitialData initialData = new InitialData();

        // Complete Summary info
        this.showSummary(initialData.getPetSummary());
        //adjustTextToTable();
//        add(jsp, BorderLayout.AFTER_LAST_LINE);
    }

    private void showSummary(List<PetSummaryModel> petSummary) {
        String[] headers = {"Pet ID", "Pet Name", "Owner Last name", "# Appointments"};
        tblResults.removeAll();
        tblResults.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 14));
        tblResults.setFont(new java.awt.Font("Tahoma", 0, 12));

//        jLabelTitulo = new JLabel("Owner management", SwingConstants.CENTER);
//        add(jLabelTitulo, BorderLayout.NORTH);
//        Font aux = jLabelTitulo.getFont();
//        jLabelTitulo.setFont(new Font(aux.getFontName(), aux.getStyle(), 20));
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers); 

//        tableModel.setColumnIdentifiers(headers);
        this.tblResults.setModel(tableModel);
        for (PetSummaryModel pet : petSummary) {
            String[] registro = new String[4];
            registro[0] = pet.getPetId() + "";
            registro[1] = pet.getPetName();
            registro[2] = pet.getOwnerLastName();
            registro[3] = pet.getAppointments() + "";
            tableModel.addRow(registro);
        }
    }

    private void adjustTextToTable() {
        final TableColumnModel columnModel = tblResults.getColumnModel();
        for (int column = 0; column < tblResults.getColumnCount(); column++) {
            int width = 15; // Min width
            for (int row = 0; row < tblResults.getRowCount(); row++) {
                TableCellRenderer renderer = tblResults.getCellRenderer(row, column);
                Component comp = tblResults.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            if (width > 300) {
                width = 300;
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }
}
