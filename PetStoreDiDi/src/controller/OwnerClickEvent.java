/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PetSummaryDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import model.PetSummaryModel;
import view.OwnerFrame;

/**
 *
 * @author diani
 */
public class OwnerClickEvent implements ActionListener {

    private OwnerFrame ownerFrame;

    public OwnerClickEvent(OwnerFrame ownerFrame) {
        this.ownerFrame = ownerFrame;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.ownerFrame.getBtnAddOwnerDB()) {
            OwnerFrame addOwner = new OwnerFrame();
            addOwner.setVisible(true);
        }
//            String petName = (String) this.ownerFrame.getTxtPetName().getText();
//            PetSummaryDAO petSummaryDAO = new PetSummaryDAO();
//            List<PetSummaryModel> pets = petSummaryDAO.getFilteredPets(petName);
//            this.ownerFrame.showSummary(pets);

//        } else if (actionEvent.getSource() == this.summaryPanel.getBtnAddOwner()) {
//            OwnerFrame ownerView = new OwnerFrame();
//            ownerView.setVisible(true);
//        }
    }

}
