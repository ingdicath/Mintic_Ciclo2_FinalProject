/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.IPropietarioDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Propietario;

/**
 * Here it creates the controller, the controller contains 2 objects: the model,
 * the view as well as the getters and setters to fill the model properties.
 *
 * @author diani
 */
public class PropietarioController {

    private IPropietarioDAO propietarioDAO;

    public PropietarioController(IPropietarioDAO propietarioDAO) {

        this.propietarioDAO = propietarioDAO;
    }

    public TableModel consultarPropietarios() {
        String[] titulos = {"Id", "Username", "Last name", "First name", "Phone number"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        List<Propietario> propietarios = propietarioDAO.obtenerPropietarios();
        for (Propietario propietario : propietarios) {
            String[] registro = new String[5];
            registro[0] = propietario.getPropId() + "";
            registro[1] = propietario.getPropUsuario();
            registro[2] = propietario.getPropApellido() + "";
            registro[3] = propietario.getPropNombre() + "";
            registro[4] = propietario.getPropTelefono() + "";
            modelo.addRow(registro);
        }
        return modelo;
    }

    public void actualizarPropietario(Propietario p) {
        propietarioDAO.actualizarPropietario(p);
    }

    public void eliminarPropietario(int id) {
        propietarioDAO.eliminarPropietario(id);
    }

    public void agregarPropietario(Propietario p) {
        propietarioDAO.agregarPropietario(p);
    }
}
