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
public class AppointmentModel {

    private int id;
    private String date;
    private String description;
    private int petId;

    /**
     *
     * @param date
     * @param description
     * @param petId
     */
    public AppointmentModel(String date, String description, int petId) {
        this.date = date;
        this.description = description;
        this.petId = petId;
    }

    /**
     *
     * @param id
     * @param date
     * @param description
     * @param petId
     */
    public AppointmentModel(int id, String date, String description, int petId) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.petId = petId;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

//    /**
//     * @param id the id to set
//     */
//    public void setId(int id) {
//        this.id = id;
//    }
    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the petId
     */
    public int getPetId() {
        return petId;
    }

    @Override
    public String toString() {
        return "AppointmentModel{" + "id=" + id + ", date=" + date + ", description=" + description + ", petId=" + petId + '}';
    }

}
