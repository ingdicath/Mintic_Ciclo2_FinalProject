/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.PetSummaryModel;
import util.ConnectionDB;

/**
 *
 * @author diani
 */
public class PetSummaryDAO {

    private Connection conn = null;

    /**
     * Displays the list of pets grouped by the number of appointments.
     *
     * @return petSummary: List of pets grouped by appointments.
     */
    public List<PetSummaryModel> getSummary() {
        List<PetSummaryModel> petSummary = new ArrayList<>();
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "SELECT m.mascotaId, m.mascotaNombre, p.propApellido, "
                    + "COUNT(c.mascotaId) AS Appointments\n"
                    + "FROM mascota AS m\n"
                    + "NATURAL JOIN propietario AS p\n"
                    + "NATURAL LEFT JOIN cita AS c\n"
                    + "GROUP BY m.mascotaId, m.mascotaNombre, p.propApellido;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                PetSummaryModel pet = new PetSummaryModel(result.getInt("mascotaId"),
                        result.getString("mascotaNombre"),
                        result.getString("propApellido"),
                        result.getInt("Appointments"));
                petSummary.add(pet);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return petSummary;
    }

    /**
     * Displays the pet or pets searched by name or certain
     * character(wildcards).
     *
     * @param petName
     * @return petSummary
     */
    public List<PetSummaryModel> getFilteredPets(String petName) {
        List<PetSummaryModel> petSummary = new ArrayList<>();
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();

                String sql = "SELECT m.mascotaId, m.mascotaNombre, p.propApellido,"
                        + "COUNT(c.mascotaId) AS Appointments\n"
                        + "FROM mascota AS m\n"
                        + "NATURAL JOIN propietario AS p "
                        + "NATURAL LEFT JOIN cita AS c\n"
                        + "WHERE m.mascotaNombre LIKE ? \n"
                        + "GROUP BY m.mascotaId, m.mascotaNombre, p.propApellido;";
                PreparedStatement statement = conn.prepareStatement(sql);
//                System.out.println(sql);
                statement.setString(1, "%" + petName + "%");
//                System.out.println(statement.toString());
                System.out.println("Search done");
                ResultSet result = statement.executeQuery();
                while (result.next()) {
                    PetSummaryModel pet = new PetSummaryModel(result.getInt("mascotaId"),
                            result.getString("mascotaNombre"),
                            result.getString("propApellido"),
                            result.getInt("Appointments"));
                    petSummary.add(pet);
                }
                if (petSummary.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Pet doesn't exist in our database.");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return petSummary;
    }
}