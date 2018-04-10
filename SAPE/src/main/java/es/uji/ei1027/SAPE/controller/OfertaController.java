package es.uji.ei1027.SAPE.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.SAPE.dao.DaoOfertaProyecto;
import es.uji.ei1027.SAPE.model.Estancia;
import es.uji.ei1027.SAPE.model.OfertaProyecto;


@Controller
@RequestMapping("/oferta")
public class OfertaController {
	
	private DaoOfertaProyecto ofertaDao;
	
	@Autowired
	public void setOfertaDao(DaoOfertaProyecto ofertaDao) {
		this.ofertaDao = ofertaDao;
	}
	
	@RequestMapping("/list") 
	public String listOfertas(Model model) {
		model.addAttribute("ofertas", ofertaDao.getOfertaProyectos());
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
			ofertaDao.addOfertaProyecto(oferta);
			return "redirect:list.html";
		}
		
		@RequestMapping(value="/update/{id}", method = RequestMethod.GET)
		public String editaOferta(Model model, String user, String password, String tarea, String objetivo, @PathVariable Short id) {
			model.addAttribute("oferta", ofertaDao.getOfertaProyecto(id));
			return "oferta/update";
		}
		
		@RequestMapping(value="/update/{id}", method = RequestMethod.POST) 
		public String processUpdateSubmit(@PathVariable String id, 
				@ModelAttribute("oferta") OfertaProyecto oferta, 
				BindingResult bindingResult) {
			if (bindingResult.hasErrors()) 
				return "oferta/update";
			ofertaDao.updateOfertaProyecto(oferta);
			return "redirect:../list"; 
		}
		
		@RequestMapping(value="/delete/{id}")
		public String processDelete(@PathVariable Short id) {
			ofertaDao.deleteOfertaProyecto(id);
			return "redirect:../list";
		}
		
		@RequestMapping("/crear")
		public String crearOferta(String user, String password, Estancia estancia, String tarea, String objetivo, Model model) {
			model.addAttribute("nueva oferta", new OfertaProyecto());
			
			return "oferta/crear";
		}
		
		// public String estadoOferta

}
