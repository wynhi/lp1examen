/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import pe.edu.upeu.model.Diagnostico;
import pe.edu.upeu.service.DiagnosticoServis;

/**
 *
 * @author Alumnos
 */
@Controller
@RequestMapping("/diagnostico")
public class DiagnosticoCController {
    @Autowired
    DiagnosticoServis service;	
    @Autowired
    MessageSource messageSource;     

    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public ModelAndView listDiagnostico(ModelMap model) {
        List<Diagnostico> lista=service.listarEntidad();
        Map<String, Object> modelo=new HashMap<String, Object> ();
        modelo.put("ListaDiagnostico", lista);
        modelo.put("mensaje", "Reporte de Diagnostico"); 
        return new ModelAndView("diagnostico/mainDiagnostico", modelo);
    }        
    

    @RequestMapping(value = "buscarDiagnostico", method = RequestMethod.POST)
    public  ModelAndView buscarDiagnostico(HttpServletRequest r) {
        String dato=r.getParameter("dato")==null ? "":r.getParameter("dato");
        List<Diagnostico> lista=service.listarPorNombre(dato);            
        Map<String, Object> modelo=new HashMap<String, Object> ();
        modelo.put("ListaDiagnostico", lista);
       return new ModelAndView("diagnostico/mainDiagnostico",modelo);
    } 
    
    @RequestMapping(value = "eliminarDiagnostico", method = RequestMethod.GET)
    public  ModelAndView eliminarDiagnostico(HttpServletRequest r) {
        int idEntidad=Integer.parseInt(r.getParameter("id"));
        service.eliminarEntidadId(idEntidad);
        System.out.println("si llego al metodo");
        return new ModelAndView(new RedirectView("diagnostico/list"));
    }
    @RequestMapping(value = "formDiagnostico", method = RequestMethod.GET)
        public ModelAndView irFormulario(@ModelAttribute("modeloDiente") Diagnostico entidad,BindingResult result ){
            Map<String, Object> modelo=new HashMap<String, Object> ();
            modelo.put("listaTemporada", "Holasssssssssss");
            modelo.put("listaTemporadaX", service.listarEntidad());
            modelo.put("listaTemporada2", "");
            modelo.put("listaTemporada3", "");            
            return new ModelAndView("diagnostico/formDiagnostico",modelo);
        }
    @RequestMapping(value = "guardarDiagnostico", method = RequestMethod.POST)
        public ModelAndView guardarDiagnosticoXX(@ModelAttribute("modeloDiagnostico") Diagnostico entidad,
                                              BindingResult result ){            
                service.guardarEntidad(entidad);
            return new ModelAndView(new RedirectView("list"));
        }
    @RequestMapping(value = "modificarDiagnostico", method = RequestMethod.GET)
        public ModelAndView modificarDiagnostico(HttpServletRequest r ){
           int id=Integer.parseInt(r.getParameter("id"));
               Diagnostico entidad=null;
               entidad=service.buscarEntidadId(id);
            return new ModelAndView("diagnostico/formUDiagnostico","ModeloDiagnostico",entidad);
        }
    @RequestMapping(value = "modificarDiagnosticoX", method = RequestMethod.GET)
        public String modificarDienteX(HttpServletRequest r, Model model ){
           int id=Integer.parseInt(r.getParameter("id"));
               Diagnostico diagnostico=null;
               diagnostico=service.buscarEntidadId(id);
               model.addAttribute("ModeloDiagnostico", diagnostico);             
            return "diagnostico/formUDiagnostico";
        }
    @RequestMapping(value = "actualizarDiagnostico", method = RequestMethod.POST)
        public ModelAndView gactualizarDiagnosticoXX(@ModelAttribute("ModeloDiente") Diagnostico entidad,
                                              BindingResult result ){
                service.modificarEntidadId(entidad);
            return new ModelAndView(new RedirectView("list"));
        }
   
}
