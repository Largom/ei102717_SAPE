package es.uji.ei1027.SAPE.controller;


import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.SAPE.model.Asignacion;
import es.uji.ei1027.SAPE.model.EstadoOferta;
import es.uji.ei1027.SAPE.model.Estancia;
import es.uji.ei1027.SAPE.model.OfertaProyecto;
import es.uji.ei1027.SAPE.model.Personal;
import es.uji.ei1027.SAPE.dao.DaoOfertaProyecto;


class OfertaValidator implements Validator { 
	
    @Override
    public boolean supports(Class<?> cls) { 
        return OfertaProyecto.class.isAssignableFrom(cls);
    }
    @Override 
    public void validate(Object obj, Errors errors) {
    	OfertaProyecto  oferta = (OfertaProyecto)obj;
    	if (oferta.getTarea().equals(""))
		       errors.rejectValue("tarea", "obligatori", "Es necesario introducir una tarea");
    	if (oferta.getObjetivo().equals(""))
		       errors.rejectValue("objetivo", "obligatori", "Es necesario introducir una objetivo");
    	if (oferta.getItinerarios().equals(""))
		       errors.rejectValue("itinerarios", "obligatori", "Es necesario introducir un o varios itinerarios");
    }
    
    
}





@Controller
@RequestMapping("/oferta")
public class OfertaController {

	private DaoOfertaProyecto ofertaProyectoDao;
	
	@Autowired
	public void setOfertaDao(DaoOfertaProyecto oferta) {
		this.ofertaProyectoDao = oferta;
	}
	
		
	
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
	
	@RequestMapping(value="/add/{id}")
	public String nuevaOferta(HttpSession session, Model model, @PathVariable short id) {
		
		Personal usuario = (Personal) session.getAttribute("user");
		if(usuario == null) {
			session.setAttribute("nextUrl", "/oferta/add.html");
			model.addAttribute("user", new String());
			model.addAttribute("pass", new String());
			return "login";
		}
		
		model.addAttribute("nuevaOferta", new OfertaProyecto(id));
		return "oferta/add";
	}
	
	 
    @RequestMapping(value="/add/{id}", method=RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("nuevaOferta") OfertaProyecto ofertaNueva, BindingResult bindingResult, HttpSession session, Model model) {
    	
    	Personal usuario = (Personal) session.getAttribute("user");
		if(usuario == null) {
			session.setAttribute("nextUrl", "/oferta/add.html");
			model.addAttribute("user", new String());
			model.addAttribute("pass", new String());
			return "login";
		}
    		
    	OfertaValidator ofertaValidator = new OfertaValidator(); 
    	ofertaValidator.validate(ofertaNueva, bindingResult);  
    	if (bindingResult.hasErrors()) 
                return "oferta/add";
         ofertaProyectoDao.crearEditarOfertaProyecto(usuario.getUsuario(), usuario.getPass(), ofertaNueva);
         return "redirect:list.html"; 
     }
	
	
	
	 
	
	@RequestMapping(value="/editar/{id}", method = RequestMethod.GET)
	public String editarOferta(HttpSession session, Model model, @PathVariable short id) {
		
		Personal usuario = (Personal) session.getAttribute("user");
		if(usuario == null) {
			session.setAttribute("nextUrl", "/asignacion/list.html");
			model.addAttribute("user", new String());
			model.addAttribute("pass", new String());
			return "login";
		}
		
		model.addAttribute("ofertaEditar", ofertaProyectoDao.getOfertaProyecto(usuario.getUsuario(), usuario.getPass(),id));
		return "oferta/list";
	}
	
	@RequestMapping(value="/editar/{id}", method = RequestMethod.POST)
	public String  procesoUpdateSubmit(HttpSession session, Model model, @PathVariable short id, @ModelAttribute("ofertaEditar") OfertaProyecto oferta, BindingResult bindingResult) {
		
		Personal usuario = (Personal) session.getAttribute("user");
		if(usuario == null) {
			session.setAttribute("nextUrl", "oferta/editar.html");
			model.addAttribute("user", new String());
			model.addAttribute("pass", new String());
			return "login";
		}
		if (bindingResult.hasErrors()) 
            return "oferta/editar/{id}";
		
		ofertaProyectoDao.crearEditarOfertaProyecto(usuario.getUsuario(), usuario.getPass(),oferta);
		return "oferta/list";
	}
	
	@RequestMapping(value="/editar/{id, estado}")
	public String  editarEstado(HttpSession session, Model model, @PathVariable short id, @PathVariable EstadoOferta estado) {
		
		Personal usuario = (Personal) session.getAttribute("user");
		if(usuario == null) {
			session.setAttribute("nextUrl", "/oferta/editar.html");
			model.addAttribute("user", new String());
			model.addAttribute("pass", new String());
			return "login";
		}
		
		ofertaProyectoDao.editarEstadoOfertaProyecto(usuario.getUsuario(), usuario.getPass(),id, estado);
		return "oferta/list";
	}
	
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



