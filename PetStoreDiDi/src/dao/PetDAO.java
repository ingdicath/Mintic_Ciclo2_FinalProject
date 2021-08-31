/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.PetModel;
import util.ConnectionDB;

/**
 *
 * @author diani
 */
public class PetDAO {

    private Connection conn = null;

    public List<PetModel> getAllPets() {
        List<PetModel> pets = new ArrayList<>();
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }

            String sql = "SELECT * FROM mascota";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                PetModel pet = new PetModel(result.getInt("mascotaId"), result.getString("mascotaNombre"), result.getInt("propId"));
                pets.add(pet);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return pets;
    }


}
