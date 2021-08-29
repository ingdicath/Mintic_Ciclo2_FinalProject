/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Propietario;

/**
 *
 * @author diegomaldonado
 */
public interface IPropietarioDAO {

    public List<Propietario> obtenerPropietarios();

    public Propietario obtenerPropietario(int propId);

    public void actualizarPropietario(Propietario propietario);

    public void eliminarPropietario(int propId);

    public void agregarPropietario(Propietario propietario);
}
