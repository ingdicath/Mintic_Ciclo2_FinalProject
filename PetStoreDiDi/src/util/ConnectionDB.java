/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Connection setup with the sql DB.
 *
 * @author diani
 */
public class ConnectionDB {

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(
                    Properties.dbURL, Properties.username, Properties.password);
            if (conn != null) {
                System.out.println("*** Connected to database ***");
                return conn;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
            ex.printStackTrace();
        }
        return conn;
    }

}
