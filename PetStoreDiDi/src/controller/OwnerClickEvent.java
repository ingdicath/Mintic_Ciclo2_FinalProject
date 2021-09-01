/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.OwnerFrame;

/**
 * Click Event setup for "Add to DB" button, when a new owner is added to the
 * DB.
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
    }
}
