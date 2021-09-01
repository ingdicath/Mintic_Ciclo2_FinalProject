/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.InitialData;
import controller.OwnerController;
import dao.OwnerDAO;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
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
    private JScrollPane jspPane;
    private InitialData initialData;
    private JPanel contentPanel;
    private JPanel editPanel;
    private OwnerController controller;

    public OwnerFrame() {
        controller = new OwnerController();
        initComponents();
    }

    private void initComponents() {
        setTitle("Owner management");
        editPanel = new JPanel();
        editPanel.setLayout(new GridLayout(8, 2));
        initialData = new InitialData();

        // Displays all owners information
        this.showOwners(initialData.getAllOwners());

        this.lblOwnerUsername = new JLabel("Username");
        editPanel.add(this.lblOwnerUsername);
        this.txtOwnerUsername = new JTextField();
        editPanel.add(this.txtOwnerUsername);

        this.lblOwnerLastName = new JLabel("Owner Last name");
        editPanel.add(this.lblOwnerLastName);
        this.txtOwnerLastName = new JTextField();
        editPanel.add(this.txtOwnerLastName);

        this.lblOwnerFirstName = new JLabel("Owner First name");
        editPanel.add(this.lblOwnerFirstName);
        this.txtOwnerFirstName = new JTextField();
        editPanel.add(this.txtOwnerFirstName);

        this.lblPhoneNumber = new JLabel("Phone number");
        editPanel.add(this.lblPhoneNumber);
        this.txtPhoneNumber = new JTextField();
        editPanel.add(this.txtPhoneNumber);

        this.btnAddOwnerDB = new JButton("Add to DB");
        editPanel.add(this.btnAddOwnerDB);

        this.btnAddOwnerDB.addActionListener(this);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        // Allows to place the window in the center of the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation((screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2);
        add(editPanel);
        pack();
        setVisible(true);
        setResizable(false);
    }

    /**
     * Panel owners setup
     *
     * @param owners
     */
    public void showOwners(List<OwnerModel> owners) {
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        this.tblResults = new JTable();
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem deleteItem = new JMenuItem("Delete selected row...");
        deleteItem.addActionListener((ActionEvent e) -> {
            removeSelectedRows(tblResults);
        });

        // Creates a pop-up Menu to delete owners
        popupMenu.add(deleteItem);
        tblResults.setComponentPopupMenu(popupMenu);
        this.tblResults.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        this.jspPane = new JScrollPane(this.tblResults);

        contentPanel.add(jspPane, BorderLayout.PAGE_END);
        setContentPane(contentPanel);
        contentPanel.setPreferredSize(new Dimension(550, 600));

        String[] headers = {"Owner ID", "Username", "Last name", "First name", "Phone number"};
        tblResults.removeAll();
        tblResults.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 14));
        tblResults.setFont(new java.awt.Font("Tahoma", 0, 12));

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers);
        this.tblResults.setModel(tableModel);
        for (OwnerModel owner : owners) {
            addOwner(owner);
        }
    }

    void addOwner(OwnerModel owner) {
        DefaultTableModel tableModel = (DefaultTableModel) tblResults.getModel();
        String[] registro = new String[5];
        registro[0] = owner.getId() + "";
        registro[1] = owner.getUsername();
        registro[2] = owner.getLastName();
        registro[3] = owner.getFirstName();
        registro[4] = owner.getPhoneNumber();
        tableModel.addRow(registro);
    }

    /**
     *
     * @param tblResults
     */
    private void removeSelectedRows(JTable tblResults) {
        DefaultTableModel model = (DefaultTableModel) this.tblResults.getModel();
        int column = 0;
        int row = tblResults.getSelectedRow();
        try {
            String value = model.getValueAt(row, column).toString();
            boolean result = controller.deleteOwner(Integer.parseInt(value));
            if (result) {
                model.removeRow(row);
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "Error: Please select the entire "
                    + "row for delete an owner.");
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.btnAddOwnerDB) {
            String username = (String) this.txtOwnerUsername.getText();
            String lastName = (String) this.txtOwnerLastName.getText();
            String firstName = (String) this.txtOwnerFirstName.getText();
            String phone = (String) this.txtPhoneNumber.getText();

            OwnerModel owner = new OwnerModel(username, lastName, firstName, phone);
            OwnerDAO ownerDAO = new OwnerDAO();
            owner = ownerDAO.insertOwner(owner);

            // Clean the form for the next owner addition
            this.txtOwnerUsername.setText("");
            this.txtOwnerLastName.setText("");
            this.txtOwnerFirstName.setText("");
            this.txtPhoneNumber.setText("");
            addOwner(owner);
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
