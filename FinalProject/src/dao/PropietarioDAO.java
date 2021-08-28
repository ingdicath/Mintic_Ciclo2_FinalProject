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
import model.Propietario;
import util.Conexion;

/**
 *
 * @author diegomaldonado
 */
public class PropietarioDAO implements IPropietarioDAO {

    private Connection conn = null;

    public List<Propietario> obtenerPropietarios() {
        List<Propietario> propietarios = new ArrayList();
        try {
            if (conn == null) {
                conn = Conexion.getConnection();
            }

            String sql = "SELECT * FROM propietario";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                Propietario propietario = new Propietario(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5));
                propietarios.add(propietario);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return propietarios;
    }

    public Propietario obtenerPropietario(int propId) {
        Propietario propietario = null;
        try {
            if (conn == null) {
                conn = Conexion.getConnection();
            }

            String sql = "SELECT * FROM propietario where propId=?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, propId);
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                propietario = new Propietario(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return propietario;
    }

    public void agregarPropietario(Propietario propietario) {

        try {
            if (conn == null) {
                conn = Conexion.getConnection();
            }
            String sql = "INSERT INTO propietario(propID, propUsuario, propApellido,propNombre,propTelefono)"
                    + "VALUES(?,?,?,?,?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, propietario.getPropId());
            statement.setString(2, propietario.getPropUsuario());
            statement.setString(3, propietario.getPropApellido());
            statement.setString(4, propietario.getPropNombre());
            statement.setString(5, propietario.getPropTelefono());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue "
                        + " creado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }

    public void eliminarPropietario(int propId) {
        try {
            if (conn == null) {
                conn = Conexion.getConnection();
            }
            String sql = " DELETE FROM propietario WHERE propId=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, propId);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println(" Borrado exitoso !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }

    }

    public void actualizarPropietario(Propietario propietario) {
        try {
            if (conn == null) {
                conn = Conexion.getConnection();
            }
            String sql = "UPDATE libro SET libNombre =?, libPub =  ?, libPrecio =  ? WHERE  libId =  ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(2, propietario.getPropUsuario());
            statement.setString(3, propietario.getPropApellido());
            statement.setString(4, propietario.getPropNombre());
            statement.setString(5, propietario.getPropTelefono());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue "
                        + " actualizado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }
}
