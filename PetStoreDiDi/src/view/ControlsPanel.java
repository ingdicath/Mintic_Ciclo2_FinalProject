/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author diani
 */
public class ControlsPanel {

    public class ControlsPanel extends JPanel {

        private JLabel lblMuseums;
        private JComboBox<MuseumModel> cbxMuseumsList;
        private JLabel lblPresentations;
        private JComboBox<PresentationModel> cbxPresentationsList;
        private JLabel lblName;
        private JTextField txtName;
        private JButton btnSearch;
        private JButton btnAddArtPiece;
        private JTable tblResults;

        /**
         * Constructor of the ControlsPanel class.
         *
         * @param resultsPanel
         */
        public ControlsPanel(ResultsPanel resultsPanel) {
            this.tblResults = resultsPanel.getTblResults();
            initComponents();
        }

    }
}
