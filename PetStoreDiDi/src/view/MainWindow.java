/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

/**
 *
 * @author diani
 */
public class MainWindow extends JFrame {

    public MainWindow() {
        initComponents();
    }

    /*
     * Setup window title.
     * PanelPropietarios, create a panel to store the table.
     * setContentPane is the main window panel.  
     * setLocation allows to center window on the screen
     */
    private void initComponents() {
        setTitle("PetStore DiDi - MVC");

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ResultsPanel resultsPanel = new ResultsPanel();
        setContentPane(resultsPanel);
        add(new SummaryPanel(resultsPanel));

        // Resize the window to fit all components
        pack();

        // Allows to place the window in the center of the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation((screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2);
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
