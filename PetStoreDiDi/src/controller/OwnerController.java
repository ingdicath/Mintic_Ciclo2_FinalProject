/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.OwnerDAO;

/**
 *
 * @author diani
 */
public class OwnerController {

    private OwnerDAO ownerDAO;

    public OwnerController() {
       ownerDAO = new OwnerDAO();
    }

    public void deleteOwner(int id) {
        ownerDAO.deleteOwner(id);
    }
}
