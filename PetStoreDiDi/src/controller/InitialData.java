/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PetDAO;
import dao.PetSummaryDAO;
import java.util.ArrayList;
import java.util.List;
import model.AppointmentModel;
import model.OwnerModel;
import model.PetModel;
import model.PetSummaryModel;

/**
 *
 * @author diani
 */
public class InitialData {

    private List<PetSummaryModel> petSummary = null;
    private ArrayList<OwnerModel> owners = null;
    private ArrayList<PetModel> pets = null;
    private ArrayList<AppointmentModel> appointments = null;

    public InitialData() {
        PetSummaryDAO summaryDAO = new PetSummaryDAO();
        this.petSummary = summaryDAO.getSummary();

//        OwnerDAO ownerDAO = new OwnerDAO();
//        this.owners = ownerDAO.getAllOwners();
//        this.owners.add(0, new OwnerModel(-1, "All owners")); //revisar si tambien se puede poner null
//        
//        PetDAO petDAO = new PetDAO();
//        this.pets = petDAO.getAllPets();
    }

    public List<PetSummaryModel> getPetSummary() {
        return petSummary;
    }

}
