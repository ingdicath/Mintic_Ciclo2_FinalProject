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

    /*
    public void insertOwner(OwnerModel owner) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }

            String sql = "INSERT INTO propietario(propUsuario, "
                    + "propApellido, propNombre, propTelefono) "
                    + "VALUES(?, ?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, owner.getUsername());
            statement.setString(2, owner.getLastName());
            statement.setString(3, owner.getFirstName());
            statement.setString(4, owner.getPhoneNumber());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "The record was successfully created!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }
    */


    public void insertOwner(OwnerModel owner) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }

            String sql = "INSERT INTO propietario(propId, propUsuario, "
                    + "propApellido, propNombre, propTelefono) "
                    + "VALUES(?, ?, ?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, owner.getId());
            statement.setString(2, owner.getUsername());
            statement.setString(3, owner.getLastName());
            statement.setString(4, owner.getFirstName());
            statement.setString(5, owner.getPhoneNumber());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "The record was successfully created!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }
  

    public void deleteOwner(int propId) {
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
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código: "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }

//    @Override
//    public void actualizarPropietario(Propietario propietario) {
//
//        try {
//            if (conn == null) {
//                conn = Conexion.getConnection();
//            }
//            String sql = "UPDATE propietario SET propUsuario =?, propApellido =?, "
//                    + "propNombre =?, propTelefono=? WHERE propId=?";
//            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setString(1, propietario.getPropUsuario());
//            statement.setString(2, propietario.getPropApellido());
//            statement.setString(3, propietario.getPropNombre());
//            statement.setString(4, propietario.getPropTelefono());
//            statement.setInt(5, propietario.getPropId());
//            int rowsUpdated = statement.executeUpdate();
//            if (rowsUpdated > 0) {
//                JOptionPane.showMessageDialog(null, "The record was "
//                        + "successfully updated!");
//                System.out.println("--- Successfull update! ---");
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Código: "
//                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
//        }
//    }
}