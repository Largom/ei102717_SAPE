package es.uji.ei1027.SAPE.controller;


import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.SAPE.model.EstadoOferta;
import es.uji.ei1027.SAPE.model.Estancia;
import es.uji.ei1027.SAPE.model.OfertaProyecto;
import es.uji.ei1027.SAPE.model.Personal;
import es.uji.ei1027.SAPE.dao.DaoOfertaProyecto;


@Controller
@RequestMapping("/oferta")
public class OfertaController {

	private DaoOfertaProyecto ofertaProyectoDao;
	
	@Autowired
	public void setOfertaDao(DaoOfertaProyecto oferta) {
		this.ofertaProyectoDao = oferta;
	}
	
	

	Map<Short, OfertaProyecto> getOfertasProyectos(final String usu, final String pass);
	OfertaProyecto getOfertaProyecto(final String usu, final String pass, final short id);
	boolean crearEditarOfertaProyecto(final String usu, final String pass, final OfertaProyecto ofePro);
	
	boolean anularOfertaProyecto(final String usu, final String pass, final short id);
	boolean editarEstadoOfertaProyecto(final String usu, final String pass, final short id, final EstadoOferta estado);
		
	
	@RequestMapping("/list.html")
	public String listaOfertas(HttpSession session, Model model) {
		
		Personal usuario = (Personal) session.getAttribute("user");
		if(usuario == null) {
			session.setAttribute("nextUrl", "/asignacion/list.html");
			model.addAttribute("user", new String());
			model.addAttribute("pass", new String());
			return "login";
		}
		
		model.addAttribute("ofertas", ofertaProyectoDao.getOfertasProyectos(usuario.getUsuario(), usuario.getPass()));
		return "oferta/list";
	}
	
	@RequestMapping(value="/get/{id}")
	public String getOferta(HttpSession session, Model model, @PathVariable short id) {
		
		Personal usuario = (Personal) session.getAttribute("user");
		if(usuario == null) {
			session.setAttribute("nextUrl", "/asignacion/list.html");
			model.addAttribute("user", new String());
			model.addAttribute("pass", new String());
			return "login";
		}
		
		model.addAttribute("oferta", ofertaProyectoDao.getOfertaProyecto(usuario.getUsuario(), usuario.getPass(),id));
		return "oferta/list";
	}
	
	@RequestMapping(value="/anular/{id}")
	public String anularOferta(HttpSession session, Model model, @PathVariable short id) {
		
		Personal usuario = (Personal) session.getAttribute("user");
		if(usuario == null) {
			session.setAttribute("nextUrl", "/asignacion/list.html");
			model.addAttribute("user", new String());
			model.addAttribute("pass", new String());
			return "login";
		}
		
		model.addAttribute("ofertaAnulada", ofertaProyectoDao.anularOfertaProyecto(usuario.getUsuario(), usuario.getPass(),id));
		return "oferta/list";
	}
	
	
	
	
	
	
	
/**	
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

}*/

}

