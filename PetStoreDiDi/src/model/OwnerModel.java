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
public class OwnerModel {

    private int id;
    private String username;
    private String lastName;
    private String firstName;
    private String phoneNumber;

    /**
     * 
     * @param id
     * @param username
     * @param lastName
     * @param firstName
     * @param phoneNumber 
     */
    public OwnerModel(int id, String username, String lastName, String firstName, String phoneNumber) {
        this.id = id;
        this.username = username;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
    }

    /**
     * 
     * @param username
     * @param lastName
     * @param firstName
     * @param phoneNumber 
     */
    public OwnerModel(String username, String lastName, String firstName, String phoneNumber) {
        this.username = username;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
