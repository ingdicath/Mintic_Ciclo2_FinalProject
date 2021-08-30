/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author diani
 */
public class PetSummaryModel {

    private int petId;
    private String petName;
    private String ownerLastName;
    private int appointments;

    public PetSummaryModel(int petId, String petName, String ownerLastName, int appointments) {
        this.petId = petId;
        this.petName = petName;
        this.ownerLastName = ownerLastName;
        this.appointments = appointments;
    }
    
    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    public int getAppointments() {
        return appointments;
    }

    public void setAppointments(int appointments) {
        this.appointments = appointments;
    }

    @Override
    public String toString() {
        return "PetSummaryModel{" + "petId=" + petId + ", petName=" + petName + ", ownerLastName=" + ownerLastName + ", appointments=" + appointments + '}';
    } 
 }
