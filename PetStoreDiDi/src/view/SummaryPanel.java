/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.SummaryClickEvent;
import controller.InitialData;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.PetSummaryModel;

/**
 *
 * @author diani
 */
public class SummaryPanel extends JPanel {

    private JLabel lblOwnerLastName;
    private JTextField txtOwnerLastName;
    private JButton btnSearchOwner;
    private JButton btnAddOwner;
    private JLabel lblPetName;
    private JTextField txtPetName;
    private JButton btnSearchPet;
    private JButton btnAddPet;
    private JTable tblResults;
    private JLabel jLabelTitulo;
    private JScrollPane jsp;

    public SummaryPanel(ResultsPanel resultsPanel) {
        this.tblResults = resultsPanel.getTblResults();
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridLayout(2, 6));
        InitialData initialData = new InitialData();

        // Shows summary information
        this.showSummary(initialData.getPetSummary());

        // Pet controls setup
        this.lblPetName = new JLabel("Pet name");
        add(this.getLblPetName());
        this.txtPetName = new JTextField();
        add(this.getTxtPetName());
        this.btnSearchPet = new JButton("Search");
        add(this.btnSearchPet);
        SummaryClickEvent clickEvent = new SummaryClickEvent(this);
        this.btnSearchPet.addActionListener(clickEvent);

        // Owner controls setup
        this.lblOwnerLastName = new JLabel("Owner last name");
        add(this.getLblOwnerLastName());
        this.lblOwnerLastName = new JLabel("");
        add(this.getLblOwnerLastName());
        this.btnAddOwner = new JButton("Add new owner");
        add(this.getBtnAddOwner());
        this.getBtnAddOwner().addActionListener(clickEvent);
    }

    public void showSummary(List<PetSummaryModel> petSummary) {
        String[] headers = {"Pet ID", "Pet Name", "Owner Last name", "# Appointments"};
        tblResults.removeAll();
        tblResults.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 14));
        tblResults.setFont(new java.awt.Font("Tahoma", 0, 12));

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers);
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

    public JLabel getLblOwnerLastName() {
        return lblOwnerLastName;
    }

    public JTextField getTxtOwnerLastName() {
        return txtOwnerLastName;
    }

    public JButton getBtnSearchOwner() {
        return btnSearchOwner;
    }

    public JButton getBtnAddOwner() {
        return btnAddOwner;
    }

    public JTable getTblResults() {
        return tblResults;
    }

    public JLabel getjLabelTitulo() {
        return jLabelTitulo;
    }

    public JScrollPane getJsp() {
        return jsp;
    }

    public JLabel getLblPetName() {
        return lblPetName;
    }

    public JTextField getTxtPetName() {
        return txtPetName;
    }

    public JButton getBtnSearchPet() {
        return btnSearchPet;
    }

    public JButton getBtnAddPet() {
        return btnAddPet;
    }

}
