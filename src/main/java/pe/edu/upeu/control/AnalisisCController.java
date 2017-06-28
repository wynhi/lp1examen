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
import pe.edu.upeu.model.Analisis;
import pe.edu.upeu.service.AnalisisServis;

/**
 *
 * @author David
 */
@Controller
@RequestMapping("/analisis")
public class AnalisisCController {
	@Autowired
	AnalisisServis service;	
	@Autowired
	MessageSource messageSource;    
    
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public ModelAndView listAnalisis(ModelMap model) {
            List<Analisis> lista=service.listarEntidad();
            Map<String, Object> modelo=new HashMap<String, Object> ();
            modelo.put("ListaAnalisis", lista);
            modelo.put("saludo", "Hola amigos");            
            System.out.println("Holassssssssss");
            return new ModelAndView("periodo/mainAnalisis", modelo);
	}

        @RequestMapping(value = "eliminarAnalisis", method = RequestMethod.GET)
        public  ModelAndView eliminarAnalisis(HttpServletRequest r) {
            int idEntidad=Integer.parseInt(r.getParameter("id"));
            service.eliminarEntidadId(idEntidad);
            System.out.println("si llego al metodo");
            return new ModelAndView(new RedirectView("list"));
        }


        @RequestMapping(value = "formAnalisis", method = RequestMethod.GET)
        public ModelAndView irFormulario(@ModelAttribute("modeloAnalisis") Analisis entidad,BindingResult result ){
            Map<String, Object> modelo=new HashMap<String, Object> ();
            modelo.put("listaTemporada", "Holasssssssssss");
            modelo.put("listaTemporadaX", service.listarEntidad());
            modelo.put("listaTemporada2", "");
            modelo.put("listaTemporada3", "");            
            return new ModelAndView("periodo/formAnalisis",modelo);
        }


        @RequestMapping(value = "guardarAnalisis", method = RequestMethod.POST)
        public ModelAndView guardarAnalisisXX(@ModelAttribute("modeloAnalisis") Analisis entidad,
                                              BindingResult result ){            
                service.guardarEntidad(entidad);
            return new ModelAndView(new RedirectView("list"));
        }

        @RequestMapping(value = "modificarAnalisis", method = RequestMethod.GET)
        public ModelAndView modificarAnalisis(HttpServletRequest r ){
           int id=Integer.parseInt(r.getParameter("id"));
               Analisis entidad=null;
               entidad=service.buscarEntidadId(id);
            return new ModelAndView("periodo/formUAnalisis","ModeloAnalisis",entidad);
        }

        @RequestMapping(value = "modificarAnalisisX", method = RequestMethod.GET)
        public String modificarAnalisisX(HttpServletRequest r, Model model ){
           int id=Integer.parseInt(r.getParameter("id"));
               Analisis periodo=null;
               periodo=service.buscarEntidadId(id);
               model.addAttribute("ModeloAnalisis", periodo);             
            return "periodo/formUAnalisis";
        }

        @RequestMapping(value = "actualizarAnalisis", method = RequestMethod.POST)
        public ModelAndView gactualizarAnalisisXX(@ModelAttribute("ModeloAnalisis") Analisis entidad,
                                              BindingResult result ){
                service.modificarEntidadId(entidad);
            return new ModelAndView(new RedirectView("list"));
        }


        @RequestMapping(value = "buscarAnalisisx", method = RequestMethod.POST)
        public  ModelAndView buscarAnalisis(HttpServletRequest r) {
            String dato=r.getParameter("dato")==null ? "":r.getParameter("dato");
            List<Analisis> lista=service.listarPorNombre(dato);            
            Map<String, Object> modelo=new HashMap<String, Object> ();
            modelo.put("ListaAnalisis", lista);
           return new ModelAndView("periodo/mainAnalisis",modelo);
        }
    
}
