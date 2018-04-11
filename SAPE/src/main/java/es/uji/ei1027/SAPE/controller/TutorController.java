package es.uji.ei1027.SAPE.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/tutor")
public class TutorController {
/**
	private TutorDAO tutorDAO;
	
	
	@RequestMapping(value="/verAsignacion", method = RequestMethod.GET )
	public String loginEstudiante(Model model, @PathVariable String id ) {
		model.addAttribute("asignacionAdjudicada", tutorDAO.getAsignacion(id));
		return "tutor/getAsignacion";
	}
	
	@RequestMapping(value="/listar", method = RequestMethod.GET)
	public String listarAsignaciones(Model model ) {
		model.addAttribute("asignaciones", tutorDAO.getAsignaiones());
		return "tutor/asignaciones";
	}
	
	@RequestMapping(value="/perfil", method = RequestMethod.GET )
	public String perfilTutor(Model model) {
		model.addAttribute("perfil", tutorDAO.getTutor());
		return "tutor/perfil";
	}
**/
}
