<<<<<<< HEAD
package es.uji.ei1027.SAPE.controller;
=======
/*package es.uji.ei1027.SAPE.controller;
>>>>>>> 7741ad94ea6626ee8a01d9a36dbc602365ce6d30

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

<<<<<<< HEAD
=======
import es.uji.ei1027.SAPE.dao.DaoOfertaProyecto;
>>>>>>> 7741ad94ea6626ee8a01d9a36dbc602365ce6d30
import es.uji.ei1027.SAPE.model.Estancia;
import es.uji.ei1027.SAPE.model.OfertaProyecto;


@Controller
@RequestMapping("/oferta")
public class OfertaController {
	
<<<<<<< HEAD
	private OfertaDao ofertaDao;
	
	@Autowired
	public void setOfertaDao(OfertaDao ofertaDao) {
=======
	private DaoOfertaProyecto ofertaDao;
	
	@Autowired
	public void setOfertaDao(DaoOfertaProyecto ofertaDao) {
>>>>>>> 7741ad94ea6626ee8a01d9a36dbc602365ce6d30
		this.ofertaDao = ofertaDao;
	}
	
	@RequestMapping("/list") 
	public String listOfertas(Model model) {
<<<<<<< HEAD
		model.addAttribute("ofertas", ofertaDao.getOfertas());
=======
		model.addAttribute("ofertas", ofertaDao.getOfertaProyectos());
>>>>>>> 7741ad94ea6626ee8a01d9a36dbc602365ce6d30
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
<<<<<<< HEAD
			ofertaDao.addOferta(oferta);
=======
			ofertaDao.addOfertaProyecto(oferta);
>>>>>>> 7741ad94ea6626ee8a01d9a36dbc602365ce6d30
			return "redirect:list.html";
		}
		
		@RequestMapping(value="/update/{id}", method = RequestMethod.GET)
<<<<<<< HEAD
		public String editaOferta(Model model, String user, String password, String tarea, String objetivo, @PathVariable String id) {
			// Falta añadir
			model.addAttribute("oferta", ofertaDao.getOferta(id));
=======
		public String editaOferta(Model model, String user, String password, String tarea, String objetivo, @PathVariable Short id) {
			model.addAttribute("oferta", ofertaDao.getOfertaProyecto(id));
>>>>>>> 7741ad94ea6626ee8a01d9a36dbc602365ce6d30
			return "oferta/update";
		}
		
		@RequestMapping(value="/update/{id}", method = RequestMethod.POST) 
		public String processUpdateSubmit(@PathVariable String id, 
				@ModelAttribute("oferta") OfertaProyecto oferta, 
				BindingResult bindingResult) {
			if (bindingResult.hasErrors()) 
				return "oferta/update";
<<<<<<< HEAD
			ofertaDao.updateOferta(oferta);
=======
			ofertaDao.updateOfertaProyecto(oferta);
>>>>>>> 7741ad94ea6626ee8a01d9a36dbc602365ce6d30
			return "redirect:../list"; 
		}
		
		@RequestMapping(value="/delete/{id}")
<<<<<<< HEAD
		public String processDelete(@PathVariable String id) {
			ofertaDao.deleteOferta(id);
=======
		public String processDelete(@PathVariable Short id) {
			ofertaDao.deleteOfertaProyecto(id);
>>>>>>> 7741ad94ea6626ee8a01d9a36dbc602365ce6d30
			return "redirect:../list";
		}
		
		@RequestMapping("/crear")
		public String crearOferta(String user, String password, Estancia estancia, String tarea, String objetivo, Model model) {
			model.addAttribute("nueva oferta", new OfertaProyecto());
			
			return "oferta/crear";
		}
		
		// public String estadoOferta

<<<<<<< HEAD
}
=======
}*/
>>>>>>> 7741ad94ea6626ee8a01d9a36dbc602365ce6d30
