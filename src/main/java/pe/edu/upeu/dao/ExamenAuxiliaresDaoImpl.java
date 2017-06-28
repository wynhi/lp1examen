/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.configuration.SysDataAccess;
import pe.edu.upeu.model.ExamenAuxiliares;

/**
 *
 * @author Alumnos
 */
@Repository("examenauxiliaresDao")
public class ExamenAuxiliaresDaoImpl extends SysDataAccess<Integer, ExamenAuxiliares> implements ExamenAuxiliaresDao{
    
    @SuppressWarnings("unchecked")
    public List<ExamenAuxiliares> listarEntidad(){ return getListAll();}
    public ExamenAuxiliares buscarEntidadId(int id) {return getByKey(id);}
    public void guardarEntidad(ExamenAuxiliares examenauxiliares) {savev(examenauxiliares); }  
    public void eliminarEntidadId(int id) {delete(id);}    
    public void modificarEntidadId(ExamenAuxiliares examenauxiliares) {update(examenauxiliares);}
    
    public List<ExamenAuxiliares> listarPorNombre(String nombre){
    return (List<ExamenAuxiliares>)sessionFactory.getCurrentSession()
            .createQuery("select a from Dientes a where a.nombre like ? ")        
            .setString(0, "%"+nombre+"%")
            .list();
    }    
    
    
}
