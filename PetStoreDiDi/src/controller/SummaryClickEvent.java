/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PetDAO;
import dao.PetSummaryDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import model.PetModel;
import model.PetSummaryModel;
import view.OwnerFrame;
import view.SummaryPanel;

/**
 *
 * @author diani
 */
public class SummaryClickEvent implements ActionListener {

    private SummaryPanel summaryPanel;
    private OwnerFrame ownerFrame;

    public SummaryClickEvent(SummaryPanel summaryPanel) {
        this.summaryPanel = summaryPanel;
    }

    public SummaryClickEvent(OwnerFrame ownerFrame) {
        this.ownerFrame = ownerFrame;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.summaryPanel.getBtnSearchPet()) {
            String petName = (String) this.summaryPanel.getTxtPetName().getText();
            PetSummaryDAO petSummaryDAO = new PetSummaryDAO();
            List<PetSummaryModel> pets = petSummaryDAO.getFilteredPets(petName);
            this.summaryPanel.showSummary(pets);

        } else if (actionEvent.getSource() == this.summaryPanel.getBtnAddOwner()) {
            OwnerFrame ownerView = new OwnerFrame();
            ownerView.setVisible(true);
        }
    }
}
