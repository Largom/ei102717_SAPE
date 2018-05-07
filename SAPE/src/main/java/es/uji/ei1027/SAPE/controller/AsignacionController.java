package es.uji.ei1027.SAPE.controller;

import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import es.uji.ei1027.SAPE.dao.DaoAsignacion;
import es.uji.ei1027.SAPE.model.Asignacion;
import es.uji.ei1027.SAPE.model.Personal;


class AsignacionValidator implements Validator { 
	
    @Override
    public boolean supports(Class<?> cls) { 
        return Asignacion.class.isAssignableFrom(cls);
    }
    @Override 
    public void validate(Object obj, Errors errors) {
    	Asignacion  asignacion = (Asignacion)obj;
    	if (asignacion.getComentarioPerCambio().equals(""))
		       errors.rejectValue("user", "obligatori", "Es necesario introducir un comentario");
    }
}


@Controller
@RequestMapping("/asignacion")
public class AsignacionController {
	
	private DaoAsignacion asignacionDAO;
	
	
	
	@RequestMapping("/list.html")
	public String listaAsignaciones(HttpSession session, Model model) {
		Personal usuario = (Personal) session.getAttribute("user");
		if(usuario == null) {
			session.setAttribute("nextUrl", "/asignacion/list.html");
			model.addAttribute("user", new String());
			model.addAttribute("pass", new String());
			return "login";
		}
		
		model.addAttribute("asignaciones", asignacionDAO.getAsignaciones(usuario.getUsuario(), usuario.getPass()));
		return "asignacion/list";
	}
	
	@RequestMapping(value="/get/{id}", method = RequestMethod.GET)
	public String mostrarAsignacion(HttpSession session, Model model, @PathVariable short id ) {
		Personal usuario = (Personal) session.getAttribute("user");
		if(usuario == null) {
			session.setAttribute("nextUrl", "/verAsignacion.html");
			model.addAttribute("user", new String());
			model.addAttribute("pass", new String());
			return "login";
		}
		
		model.addAttribute("asignacion", asignacionDAO.getAsignacion(usuario.getUsuario(), usuario.getPass(), id));
		return "asignacion/verAsignacion";
	}
	
	@RequestMapping(value="/borrar/{id}")
	public String borrarAsignacion(HttpSession session, Model model, @PathVariable short id ) {
		Personal usuario = (Personal) session.getAttribute("user");
		if(usuario == null) {
			session.setAttribute("nextUrl", "/asignacion/list.html");
			model.addAttribute("user", new String());
			model.addAttribute("pass", new String());
			return "login";
		}
		
		model.addAttribute("asignacionBorrada", asignacionDAO.anularAsignacion(usuario.getUsuario(), usuario.getPass(), id));
		return "/asignacion/list.html";
	}
	
	@RequestMapping(value="/aceptar/{id}")
	public String aceptarAsignacion(HttpSession session, Model model, @PathVariable short id ) {
		Personal usuario = (Personal) session.getAttribute("user");
		if(usuario == null) {
			session.setAttribute("nextUrl", "/verAsignacion.html");
			model.addAttribute("user", new String());
			model.addAttribute("pass", new String());
			return "login";
		}
		
		model.addAttribute("asignacionAceptada", asignacionDAO.aceptaAsignacion(usuario.getUsuario(), usuario.getPass(), id));
		return "/verAsignacion.html";
	}
	
	@RequestMapping(value="/rechazar/{id}")
	public String rechazarAsignacion(HttpSession session, Model model, @PathVariable short id ) {
		Personal usuario = (Personal) session.getAttribute("user");
		if(usuario == null) {
			session.setAttribute("nextUrl", "/verAsignacion.html");
			model.addAttribute("user", new String());
			model.addAttribute("pass", new String());
			return "login";
		}
		
		model.addAttribute("asignacionRechazada", asignacionDAO.rechazaAsignacion(usuario.getUsuario(), usuario.getPass(), id));
		return "/verAsignacion.html";
	}
	
	@RequestMapping(value="/editar/{asignacion}", method = RequestMethod.GET)
	public String editarAsignacion(HttpSession session, Model model, @PathVariable Asignacion asignacion ) {
		Personal usuario = (Personal) session.getAttribute("user");
		if(usuario == null) {
			session.setAttribute("nextUrl", "/verAsignacion.html");
			model.addAttribute("user", new String());
			model.addAttribute("pass", new String());
			return "login";
		}
		
		model.addAttribute("asignacionAeditar", asignacionDAO.crearEditarAsignacion(usuario.getUsuario(), usuario.getPass(), asignacion));
		return "/verAsignacion.html";
	}
	
	@RequestMapping(value="/editar/{id, comentario}", method = RequestMethod.GET)
	public String peticionCambioAsignacion(HttpSession session, Model model, short id, String comentario, BindingResult bindingResult) {
		Personal usuario = (Personal) session.getAttribute("user");
		if(usuario == null) {
			session.setAttribute("nextUrl", "/verAsignacion.html");
			model.addAttribute("user", new String());
			model.addAttribute("pass", new String());
			return "login";
		}
		
		AsignacionValidator asignacionValidator = new AsignacionValidator(); 
		Asignacion asignacion2 = asignacionDAO.getAsignacion(usuario.getUsuario(), usuario.getPass(),id);
		asignacion2.setComentarioPerCambio(comentario);
	    asignacionValidator.validate(asignacion2, bindingResult);
	    if (bindingResult.hasErrors()) {
	         return "/editar";
	    }
		
		model.addAttribute("peticionAsignacion", asignacionDAO.petCambioAsignacion(usuario.getUsuario(), usuario.getPass(), id, comentario));
		return "/verAsignacion.html";
	}
	
	
}
