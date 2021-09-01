/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.OwnerDAO;
import dao.PetSummaryDAO;
import java.util.List;
import model.OwnerModel;
import model.PetSummaryModel;

/**
 *
 * @author diani
 */
public class InitialData {

    private List<PetSummaryModel> petSummary = null;
    private List<OwnerModel> owners = null;

    public InitialData() {
        PetSummaryDAO summaryDAO = new PetSummaryDAO();
        this.petSummary = summaryDAO.getSummary();

        OwnerDAO ownerDAO = new OwnerDAO();
        this.owners = ownerDAO.getAllOwners();
    }

    public List<PetSummaryModel> getPetSummary() {
        return petSummary;
    }

    public List<OwnerModel> getAllOwners() {
        return owners;
    }
}
