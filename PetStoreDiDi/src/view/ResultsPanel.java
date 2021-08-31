/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

/**
 *
 * @author diani
 */
public class ResultsPanel extends JPanel {

    private JTable tblResults;
    private JScrollPane jspPane;
    private JLabel jLabelTitulo;

    public ResultsPanel() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        this.tblResults = new JTable();
//        this.tblResults.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.tblResults.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        jLabelTitulo = new JLabel("Pet Summary", SwingConstants.CENTER);
        add(jLabelTitulo, BorderLayout.NORTH);
        Font aux = jLabelTitulo.getFont();
        jLabelTitulo.setFont(new Font(aux.getFontName(), aux.getStyle(), 20));
        this.jspPane = new JScrollPane(this.tblResults);
//        add(jspPane, BorderLayout.AFTER_LAST_LINE);
//              jspPane.setSize(new Dimension(100, 100));
//              tblResults.setSize(new Dimension(100, 100));
        add(jspPane, BorderLayout.PAGE_END);

        setPreferredSize(new Dimension(960, 512));
    }

    /**
     * @return the tblResults
     */
    public JTable getTblResults() {
        return tblResults;
    }

    /**
     * @param tblResults the tblResults to set
     */
    public void setTblResults(JTable tblResults) {
        this.tblResults = tblResults;
    }
}
