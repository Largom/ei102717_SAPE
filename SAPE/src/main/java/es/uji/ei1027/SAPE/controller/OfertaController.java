package es.uji.ei1027.SAPE.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.SAPE.model.Estancia;
import es.uji.ei1027.SAPE.model.OfertaProyecto;


@Controller
@RequestMapping("/oferta")
public class OfertaController {
	
	private OfertaDao ofertaDao;
	
	@Autowired
	public void setOfertaDao(OfertaDao ofertaDao) {
		this.ofertaDao = ofertaDao;
	}
	
	@RequestMapping("/list") 
	public String listOfertas(Model model) {
		model.addAttribute("ofertas", ofertaDao.getOfertas());
		return "oferta/list";
	}
		
	@RequestMapping(value="/add") 
	public String addOferta(Model model) {
		model.addAttribute("oferta", new OfertaProyecto());
		return "oferta/add";
	}
		
		@RequestMapping(value="/add", method=RequestMethod.POST) 
		public String processAddSubmit(@ModelAttribute("oferta") OfertaProyecto oferta,
				BindingResult bindingResult) {
			if (bindingResult.hasErrors())
				return "oferta/add";
			ofertaDao.addOferta(oferta);
			return "redirect:list.html";
		}
		
		@RequestMapping(value="/update/{id}", method = RequestMethod.GET)
		public String editaOferta(Model model, String user, String password, String tarea, String objetivo, @PathVariable String id) {
			// Falta añadir
			model.addAttribute("oferta", ofertaDao.getOferta(id));
			return "oferta/update";
		}
		
		@RequestMapping(value="/update/{id}", method = RequestMethod.POST) 
		public String processUpdateSubmit(@PathVariable String id, 
				@ModelAttribute("oferta") OfertaProyecto oferta, 
				BindingResult bindingResult) {
			if (bindingResult.hasErrors()) 
				return "oferta/update";
			ofertaDao.updateOferta(oferta);
			return "redirect:../list"; 
		}
		
		@RequestMapping(value="/delete/{id}")
		public String processDelete(@PathVariable String id) {
			ofertaDao.deleteOferta(id);
			return "redirect:../list";
		}
		
		@RequestMapping("/crear")
		public String crearOferta(String user, String password, Estancia estancia, String tarea, String objetivo, Model model) {
			model.addAttribute("nueva oferta", new OfertaProyecto());
			
			return "oferta/crear";
		}
		
		// public String estadoOferta

}
