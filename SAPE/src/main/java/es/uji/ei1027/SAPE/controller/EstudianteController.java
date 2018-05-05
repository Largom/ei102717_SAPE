package es.uji.ei1027.SAPE.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.Errors; 
import org.springframework.validation.Validator;
import es.uji.ei1027.SAPE.dao.DaoEstudiante;
import es.uji.ei1027.SAPE.model.Estudiante;
import es.uji.ei1027.SAPE.model.Itinerario;
import es.uji.ei1027.SAPE.model.Personal;
import es.uji.ei1027.SAPE.model.Semestre;
import es.uji.ei1027.SAPE.model.Personal;
import es.uji.ei1027.SAPE.dao.DaoLogin;

import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;




class EstudianteValidator implements Validator { 
    @Override
    public boolean supports(Class<?> cls) { 
        return Estudiante.class.isAssignableFrom(cls);
    }
    @Override 
    public void validate(Object obj, Errors errors) {
    	Estudiante estudiante = (Estudiante)obj;
    	if (estudiante.getItinerario().equals(""))
		       errors.rejectValue("estudiante", "obligatori", "Es necesario introducir un itinerario");
    	if (estudiante.getSemestreInicioEstancia().equals(""))
		       errors.rejectValue("estudiante", "obligatori", "Es necesario introducir un semestre");
 
    }
}

@Controller
@RequestMapping("/estudiante")

public class EstudianteController {
	
	private DaoEstudiante estudianteDao;
	
	@Autowired
	public  void setEstudianteDao(DaoEstudiante estudianteDao) {
		this.estudianteDao = estudianteDao;
	}
	
	@RequestMapping("/list")
	public String listarEstudiantes(Model model, HttpSession session) {
		
		Personal usuario = (Personal) session.getAttribute("user");
		
		if(usuario == null) { 
			
	          model.addAttribute("user", ""); 
	          model.addAttribute("pass", "");
	          session.setAttribute("nextUrl", "/estudiante/list.html"); 
	          return "login";
		}
		
		model.addAttribute("estudiantes", estudianteDao.getEstudiantes(usuario.getUsuario(), usuario.getPass()));
		return "estudiante/list";
	}
	
	
	@RequestMapping(value="/update/{usuario}", method = RequestMethod.GET)
	public String editSemestre(Model model, @PathVariable String usuario, HttpSession session) {
		
		Personal usuario2 = (Personal) session.getAttribute("user");
		
		if(usuario2 == null) { 
	          model.addAttribute("user", ""); 
	          model.addAttribute("pass", "");
	          session.setAttribute("nextUrl", "/estudiante/list/html"); 
	          return "login";
		}
		model.addAttribute("estudiante", estudianteDao.getEstudiante(usuario2.getUsuario(), usuario2.getPass(), usuario));
		return "estudiante/update";
		
	}
	
	@RequestMapping(value="/update/{usuario}", method = RequestMethod.POST)  // Una vez rellenado el formulario de modificacion, se envia al servidor .
    public String processUpdateSubmit(@PathVariable String nom, @ModelAttribute("estudiante") Estudiante estudiante, BindingResult bindingResult, HttpSession session, Model model) {
		
		Personal usuario = (Personal) session.getAttribute("user");
		if(usuario == null) { 
	          model.addAttribute("user", ""); 
	          model.addAttribute("pass", "");
	          session.setAttribute("nextUrl", "/estudiante/list/html"); 
	          return "login";
		}
		
		EstudianteValidator estudianteValidador = new EstudianteValidator();
		estudianteValidador.validate(estudiante, bindingResult);
		if (bindingResult.hasErrors()) 
             return "estudiante/update";
		
         estudianteDao.elegirSemestreItinerario(usuario.getUsuario(), usuario.getPass(), estudiante.getSemestreInicioEstancia(), estudiante.getItinerario());
         return "redirect:../list"; 
    }
	
}