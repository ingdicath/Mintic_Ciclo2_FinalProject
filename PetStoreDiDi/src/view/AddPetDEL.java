/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.InitialData;
import dao.PetDAO;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.OwnerModel;
import model.PetModel;

/**
 *
 * @author diani
 */
/*public class AddPet extends JFrame implements ActionListener {

    private JLabel lblId;
    private JTextField txtId;
    private JLabel lblpetName;
    private JTextField txtpetName;
    private JLabel lblOwner;
//    private JTextField txtOwner;
    private JComboBox<OwnerModel> cbxOwner; // check if we can implement as a list
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

        this.lblpetName = new JLabel("Pet Name");
        add(this.lblpetName);
        this.txtpetName = new JTextField();
        add(this.txtpetName);

//        this.lblName = new JLabel("Pet Owner");
//        add(this.lblOwner);
//        this.txtName = new JTextField();
//        add(this.txtOwner);
        this.lblOwner = new JLabel("Select owner:");
        add(this.lblOwner);
        this.cbxOwner = new JComboBox();
        this.cbxOwner.setModel(new DefaultComboBoxModel<>(initialData.getOwners().toArray(new OwnerModel[initialData.getOwners().size()])));
        this.cbxOwner.setSelectedIndex(0);
        add(this.cbxOwner);

        this.btnInsertPet = new JButton("Add to Database");
        add(this.btnInsertPet);

        this.btnInsertPet.addActionListener(this);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pack();
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.btnInsertPet) {
            int id = Integer.parseInt((String) this.txtId.getText());
            String name = (String) this.txtpetName.getText();
            int ownerFK = ((OwnerModel) this.cbxOwner.getSelectedItem()).getId();

            PetModel pet = new PetModel(id, name, ownerFK);
            PetDAO artPieceDAO = new PetDAO();
            PetDAO.insertPet(pet);
        }
    }
}
*/