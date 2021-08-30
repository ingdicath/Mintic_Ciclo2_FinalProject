/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.OwnerModel;

/**
 *
 * @author diani
 */
public class AddPet extends JFrame implements ActionListener {

    private JLabel lblId;
    private JTextField txtId;
    private JLabel lblName;
    private JTextField txtName;
    private JLabel lblOwner;
    private JComboBox<OwnerModel> cbxOwner;
    private JButton btnInsertPet;

    public AddPet() {
        initComponents();
    }

    public void initComponents() {
        setTitle("PetStore DiDi - Add Pet");
        setLayout(new GridLayout(8, 2));
        InitialData initialData = new InitialData();

        this.lblId = new JLabel("Pet ID"); // podria ser autogenerado, no ingresado por usuario
        add(this.lblId);
        this.txtId = new JTextField();
        add(this.txtId);

        this.lblName = new JLabel("Pet Name");
        add(this.lblName);
        this.txtName = new JTextField();
        add(this.txtName);

        this.lblName = new JLabel("Pet Owner");
        add(this.lblName);
        this.txtName = new JTextField();
        add(this.txtName);

        this.lblOwner = new JLabel("Select owner:");
        add(this.lblOwner);
        this.cbxOwner = new JComboBox();
        this.cbxOwner.setModel(new DefaultComboBoxModel<>(initialData.getOwners().toArray(new OwnerModel[initialData.getOwners().size()])));
        this.cbxOwner.setSelectedIndex(0);
        add(this.cbxOwner);

    }
}
