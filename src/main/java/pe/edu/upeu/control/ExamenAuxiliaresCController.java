package pe.edu.upeu.control;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;
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
import pe.edu.upeu.model.ExamenAuxiliares;
import pe.edu.upeu.service.ExamenAuxiliaresServis;

/**
 *
 * @author David
 */
@Controller
@RequestMapping("/examenauxiliares")
public class ExamenAuxiliaresCController {
	@Autowired
	ExamenAuxiliaresServis service;	
	@Autowired
	MessageSource messageSource;    
    
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public ModelAndView listExamenAuxiliares(ModelMap model) {
            List<ExamenAuxiliares> lista=service.listarEntidad();
            Map<String, Object> modelo=new HashMap<String, Object> ();
            modelo.put("ListaExamenAuxiliares", lista);
            modelo.put("saludo", "Hola amigos");            
            System.out.println("Holassssssssss");
            return new ModelAndView("periodo/mainAnalisis", modelo);
	}

        @RequestMapping(value = "eliminarExamenAuxiliares", method = RequestMethod.GET)
        public  ModelAndView eliminarExamenAuxiliares(HttpServletRequest r) {
            int idEntidad=Integer.parseInt(r.getParameter("id"));
            service.eliminarEntidadId(idEntidad);
            System.out.println("si llego al metodo");
            return new ModelAndView(new RedirectView("list"));
        }


        @RequestMapping(value = "formExamenAuxiliares", method = RequestMethod.GET)
        public ModelAndView irFormulario(@ModelAttribute("modeloExamenAuxiliares") ExamenAuxiliares entidad,BindingResult result ){
            Map<String, Object> modelo=new HashMap<String, Object> ();
            modelo.put("listaTemporada", "Holasssssssssss");
            modelo.put("listaTemporadaX", service.listarEntidad());
            modelo.put("listaTemporada2", "");
            modelo.put("listaTemporada3", "");            
            return new ModelAndView("periodo/formExamenAuxiliares",modelo);
        }


        @RequestMapping(value = "guardarExamenAuxiliares", method = RequestMethod.POST)
        public ModelAndView guardarExamenAuxiliaresXX(@ModelAttribute("modeloExamenAuxiliares") ExamenAuxiliares entidad,
                                              BindingResult result ){            
                service.guardarEntidad(entidad);
            return new ModelAndView(new RedirectView("list"));
        }

        @RequestMapping(value = "modificarExamenAuxiliares", method = RequestMethod.GET)
        public ModelAndView modificarExamenAuxiliares(HttpServletRequest r ){
           int id=Integer.parseInt(r.getParameter("id"));
               ExamenAuxiliares entidad=null;
               entidad=service.buscarEntidadId(id);
            return new ModelAndView("periodo/formUExamenAuxiliares","ModeloExamenAuxiliares",entidad);
        }

        @RequestMapping(value = "modificarExamenAuxiliaresX", method = RequestMethod.GET)
        public String modificarExamenAuxiliaresX(HttpServletRequest r, Model model ){
           int id=Integer.parseInt(r.getParameter("id"));
               ExamenAuxiliares periodo=null;
               periodo=service.buscarEntidadId(id);
               model.addAttribute("ModeloExamenAuxiliares", periodo);             
            return "periodo/formUExamenAuxiliares";
        }

        @RequestMapping(value = "actualizarExamenAuxiliares", method = RequestMethod.POST)
        public ModelAndView gactualizarExamenAuxiliaresXX(@ModelAttribute("ModeloExamenAuxiliares") ExamenAuxiliares entidad,
                                              BindingResult result ){
                service.modificarEntidadId(entidad);
            return new ModelAndView(new RedirectView("list"));
        }


        @RequestMapping(value = "buscarExamenAuxiliaresx", method = RequestMethod.POST)
        public  ModelAndView buscarExamenAuxiliares(HttpServletRequest r) {
            String dato=r.getParameter("dato")==null ? "":r.getParameter("dato");
            List<ExamenAuxiliares> lista=service.listarPorNombre(dato);            
            Map<String, Object> modelo=new HashMap<String, Object> ();
            modelo.put("ListaExamenAuxiliares", lista);
           return new ModelAndView("periodo/mainExamenAuxiliares",modelo);
        }
    
}
