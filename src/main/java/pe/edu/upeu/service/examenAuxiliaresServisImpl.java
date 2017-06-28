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
import pe.edu.upeu.dao.ExamenAuxiliaresDao;
import pe.edu.upeu.model.ExamenAuxiliares;

/**
 *
 * @author Alumnos
 */
@Service("ExamenAuxiliaresServis")
@Transactional
public class examenAuxiliaresServisImpl implements ExamenAuxiliaresServis{
 
    @Autowired
    public ExamenAuxiliaresDao dao;
 
    @Override
    public List<ExamenAuxiliares> listarEntidad(){return dao.listarEntidad();}
    @Override
    public ExamenAuxiliares buscarEntidadId(int id) {return dao.buscarEntidadId(id);}
    @Override
    public void guardarEntidad(ExamenAuxiliares examenauxiliar) {dao.guardarEntidad(examenauxiliar); }  
    @Override
    public void eliminarEntidadId(int id) {dao.eliminarEntidadId(id);}    
    @Override
    public void modificarEntidadId(ExamenAuxiliares examenauxiliar) {dao.modificarEntidadId(examenauxiliar);}   
    @Override
    public List<ExamenAuxiliares> listarPorNombre(String nombre) {return dao.listarPorNombre(nombre);}   
 
 
 
}
