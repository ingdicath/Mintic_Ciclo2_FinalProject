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
public class PetModel {

    private int id;
    private String name;
    private int ownerFK;

    /**
     *
     * @param name
     * @param ownerFK
     */
    public PetModel(String name, int ownerFK) {
        this.name = name;
        this.ownerFK = ownerFK;
    }

    /**
     *
     * @param id
     * @param name
     * @param ownerFK
     */
    public PetModel(int id, String name, int ownerFK) {
        this.id = id;
        this.name = name;
        this.ownerFK = ownerFK;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the ownerFK
     */
    public int getOwnerFK() {
        return ownerFK;
    }
//
//    public String toString() {
//        return this.name;
//    }
}
