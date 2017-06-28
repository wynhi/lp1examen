/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.service;

import java.util.List;
import pe.edu.upeu.model.Analisis;

/**
 *
 * @author Alumnos
 */
public interface AnalisisServis {
    public List<Analisis> listarEntidad();
    public Analisis buscarEntidadId(int id);
    public void guardarEntidad(Analisis analisis);
    public void eliminarEntidadId(int id);
    public void modificarEntidadId(Analisis analisis);    
    public List<Analisis> listarPorNombre(String nombre);
    
}
