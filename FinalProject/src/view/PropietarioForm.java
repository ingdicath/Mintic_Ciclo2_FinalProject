/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author diani
 */
public class PropietarioForm extends JFrame {

    public PropietarioForm() {
        initComponents();
    }

    /*
     * Setup window title.
     * PanelPropietarios, create a panel to store the table.
     * setContentPane is the main window panel.  
     * setLocation allows to center window on the screen
     */
    private void initComponents() {

        setTitle("PetStore DIDI");
        PanelPropietario panelPropietarios = new PanelPropietario();
        setContentPane(panelPropietarios);
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation((screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new PropietarioForm();
    }
}
