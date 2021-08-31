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
import view.ControlsPanel;

/**
 *
 * @author diani
 */
public class ClickEvent implements ActionListener {

    private ControlsPanel controlsPanel;

    public ClickEvent(ControlsPanel controlsPanel) {
        this.controlsPanel = controlsPanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.controlsPanel.getBtnSearchPet()) {
//            int petId = ((PetSummaryModel) this.controlsPanel.getCbxMuseumsList().getSelectedItem()).getId();
//            int idPresentation = ((PresentationModel) this.controlsPanel.getCbxPresentationsList().getSelectedItem()).getId();
//            String datePresentation = ((PresentationModel) this.controlsPanel.getCbxPresentationsList().getSelectedItem()).getDates();
            String petName = (String) this.controlsPanel.getTxtPetName().getText();

            //System.out.println(idMuseum + " " + idPresentation + " " + datePresentation + " " + artPieceName);
            PetSummaryDAO petSummaryDAO = new PetSummaryDAO();
            List<PetSummaryModel> pets = petSummaryDAO.getFilteredPets(petName);

            this.controlsPanel.showSummary(pets);

        }
//        else if (actionEvent.getSource() == this.controlsPanel.getBtnAddArtPiece()) {
//            AddArtPiece addArtPieceView = new AddArtPiece();
//            addArtPieceView.setVisible(true);
    }
}

