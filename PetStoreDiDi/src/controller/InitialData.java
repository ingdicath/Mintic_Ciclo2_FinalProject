/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.AppointmentModel;
import model.OwnerModel;
import model.PetModel;

/**
 *
 * @author diani
 */
public class InitialData {

    private ArrayList<OwnerModel> owners = null;
    private ArrayList<PetModel> pets = null;
    private ArrayList<AppointmentModel> appointments = null;

    public InitialData() {
        OwnerDAO ownerDAO = new OwnerDAO();
        this.owners = ownerDAO.getAllOwners();
        this.museums.add(0, new OwnerModel(-1, "All owners")); //revisar si tambien se puede poner null
        
        PetDAO petDAO = new PetDAO();
        this.pets = petDAO.getAllPets();
        
    }

    
}
