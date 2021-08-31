/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.InitialData;
import dao.OwnerDAO;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import model.OwnerModel;

/**
 *
 * @author diani
 */
public class OwnerFrame extends JFrame implements ActionListener {

    private JLabel lblOwnerId;
    private JTextField txtOwnerId;
    private JLabel lblOwnerUsername;
    private JTextField txtOwnerUsername;
    private JLabel lblOwnerLastName;
    private JTextField txtOwnerLastName;
    private JLabel lblOwnerFirstName;
    private JTextField txtOwnerFirstName;
    private JLabel lblPhoneNumber;
    private JTextField txtPhoneNumber;
    private JButton btnAddOwnerDB;
    private JLabel jLabelTitulo;
    private JScrollPane jsp;
    private JTable tblResults;

    public OwnerFrame() {
        initComponents();
    }

    public void initComponents() {
        setTitle("Owner management");
        setLayout(new GridLayout(8, 2));
        InitialData initialData = new InitialData();

        this.lblOwnerId = new JLabel("Owner ID");
        add(this.lblOwnerId);
        this.txtOwnerId = new JTextField();
        add(this.txtOwnerId);

        this.lblOwnerUsername = new JLabel("Username");
        add(this.lblOwnerUsername);
        this.txtOwnerUsername = new JTextField();
        add(this.txtOwnerUsername);

        this.lblOwnerLastName = new JLabel("Owner Last name");
        add(this.lblOwnerLastName);
        this.txtOwnerLastName = new JTextField();
        add(this.txtOwnerLastName);

        this.lblOwnerFirstName = new JLabel("Owner First name");
        add(this.lblOwnerFirstName);
        this.txtOwnerFirstName = new JTextField();
        add(this.txtOwnerFirstName);

        this.lblPhoneNumber = new JLabel("Phone number");
        add(this.lblPhoneNumber);
        this.txtPhoneNumber = new JTextField();
        add(this.txtPhoneNumber);

        this.btnAddOwnerDB = new JButton("Add to DB");
        add(this.btnAddOwnerDB);

        this.btnAddOwnerDB.addActionListener(this);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

                // Permite ubicar la ventana en el centro de la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation((screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2);
        
        
        
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.btnAddOwnerDB) {
            int id = Integer.parseInt((String) this.txtOwnerId.getText());
            String username = (String) this.txtOwnerUsername.getText();
            String lastName = (String) this.txtOwnerLastName.getText();
            String firstName = (String) this.txtOwnerFirstName.getText();
            String phone = (String) this.txtPhoneNumber.getText();

            OwnerModel owner = new OwnerModel(id, username, lastName, firstName, phone);
            OwnerDAO ownerDAO = new OwnerDAO();
            ownerDAO.insertOwner(owner);

            // Clean the form for the next owner addition
            this.txtOwnerId.setText("");
            this.txtOwnerUsername.setText("");
            this.txtOwnerLastName.setText("");
            this.txtOwnerFirstName.setText("");
            this.txtPhoneNumber.setText("");
        }
    }

    public JLabel getLblOwnerId() {
        return lblOwnerId;
    }

    public JTextField getTxtOwnerId() {
        return txtOwnerId;
    }

    public JLabel getLblOwnerUsername() {
        return lblOwnerUsername;
    }

    public JTextField getTxtOwnerUsername() {
        return txtOwnerUsername;
    }

    public JLabel getLblOwnerLastName() {
        return lblOwnerLastName;
    }

    public JTextField getTxtOwnerLastName() {
        return txtOwnerLastName;
    }

    public JLabel getLblOwnerFirstName() {
        return lblOwnerFirstName;
    }

    public JTextField getTxtOwnerFirstName() {
        return txtOwnerFirstName;
    }

    public JLabel getLblPhoneNumber() {
        return lblPhoneNumber;
    }

    public JTextField getTxtPhoneNumber() {
        return txtPhoneNumber;
    }

    public JButton getBtnAddOwnerDB() {
        return btnAddOwnerDB;
    }

    public JLabel getjLabelTitulo() {
        return jLabelTitulo;
    }

    public JScrollPane getJsp() {
        return jsp;
    }

    public JTable getTblResults() {
        return tblResults;
    }
}
