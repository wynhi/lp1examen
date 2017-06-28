/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.dao;

import java.util.List;
import pe.edu.upeu.model.ExamenAuxiliares;

/**
 *
 * @author Alumnos
 */
public interface ExamenAuxiliaresDao {
    public List<ExamenAuxiliares> listarEntidad();
    public ExamenAuxiliares buscarEntidadId(int id);
    public void guardarEntidad(ExamenAuxiliares examenauxiliares);
    public void eliminarEntidadId(int id);
    public void modificarEntidadId(ExamenAuxiliares examenauxiliares);
    public List<ExamenAuxiliares> listarPorNombre(String nombre);
}
