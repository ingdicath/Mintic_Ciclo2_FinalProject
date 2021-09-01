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
import model.OwnerModel;
import util.ConnectionDB;

/**
 *
 * @author diani
 */
public class OwnerDAO {

    private Connection conn = null;

    /**
     *
     * @return owners
     */
    public List<OwnerModel> getAllOwners() {
        List<OwnerModel> owners = new ArrayList<>();
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "SELECT * FROM propietario";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                OwnerModel owner = new OwnerModel(result.getInt("propId"),
                        result.getString("propUsuario"), result.getString("propApellido"),
                        result.getString("propNombre"), result.getString("propTelefono"));
                owners.add(owner);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return owners;
    }

    /**
     * Using RETURN_GENERATED_KEYS parameter, allows to display automatically
     * generated keys in the Owner Panel
     *
     * @param owner
     * @return OwnerModel
     */
    public OwnerModel insertOwner(OwnerModel owner) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "INSERT INTO propietario(propUsuario, "
                    + "propApellido, propNombre, propTelefono) "
                    + "VALUES(?, ?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, owner.getUsername());
            statement.setString(2, owner.getLastName());
            statement.setString(3, owner.getFirstName());
            statement.setString(4, owner.getPhoneNumber());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    owner.setId(generatedKeys.getInt(1));
                }
                JOptionPane.showMessageDialog(null, "The record was successfully created!");
                System.out.println("Record was successfully created");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return owner;
    }

    /**
     *
     * @param propId: Owner Id
     * @return boolean indicating if was possible delete or not the selected
     * row.
     */
    public boolean deleteOwner(int propId) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = " DELETE FROM propietario WHERE propId=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, propId);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "The record was successfully deleted!");
                System.out.println("Record was successfully deleted");
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código: "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
            return false;
        }
    }
}
