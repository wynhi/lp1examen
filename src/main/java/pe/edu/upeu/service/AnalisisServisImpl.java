/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.dao.AnalisisDao;
import pe.edu.upeu.model.Analisis;

/**
 *
 * @author Alumnos
 */
@Service("analisisServis")
@Transactional
public class AnalisisServisImpl implements AnalisisServis{
 
    @Autowired
    public AnalisisDao dao;
 
    @Override
    public List<Analisis> listarEntidad(){return dao.listarEntidad();}
    @Override
    public Analisis buscarEntidadId(int id) {return dao.buscarEntidadId(id);}
    @Override
    public void guardarEntidad(Analisis analisis) {dao.guardarEntidad(analisis); }  
    @Override
    public void eliminarEntidadId(int id) {dao.eliminarEntidadId(id);}    
    @Override
    public void modificarEntidadId(Analisis analisis) {dao.modificarEntidadId(analisis);}   
    @Override
    public List<Analisis> listarPorNombre(String nombre) {return dao.listarPorNombre(nombre);}   
 
 
 
}
