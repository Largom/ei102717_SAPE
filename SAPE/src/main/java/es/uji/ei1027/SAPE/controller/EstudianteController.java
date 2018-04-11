package es.uji.ei1027.SAPE.controller;

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
import es.uji.ei1027.SAPE.dao.DaoEstudiante;
>>>>>>> 7741ad94ea6626ee8a01d9a36dbc602365ce6d30
import es.uji.ei1027.SAPE.model.Estudiante;

@Controller
@RequestMapping("estudiante")

public class EstudianteController {
	
<<<<<<< HEAD
	private EstudianteDao estudianteDao;
	
	@Autowired
	public  void setEstudianteDao(EstudianteDao estudianteDao) {
=======
	private DaoEstudiante estudianteDao;
	
	@Autowired
	public  void setEstudianteDao(DaoEstudiante estudianteDao) {
>>>>>>> 7741ad94ea6626ee8a01d9a36dbc602365ce6d30
		this.estudianteDao = estudianteDao;
	}
	
	@RequestMapping("/list")
	public String listEstudiante(Model model) {
		model.addAttribute("estudiantes", estudianteDao.getEstudiantes());
		return "estudiante/list";
	}
	
	@RequestMapping(value="/add")
	public String addEstudiante(Model model) {
<<<<<<< HEAD
		model.addAttribute("estudiante", new Estudiante());
		return "estudiante/add";
	}
	
	@RequestMapping("/list/{dni}") 
	public String verEstudiante(Model model, String user, String password) {
		if(estudianteDao.getPassword() == password) {
			model.addAttribute("estudiante", estudianteDao.getEstudiante(user));
		}
=======
		Estudiante e = new Estudiante();
		model.addAttribute("estudiante", e);
		estudianteDao.addEstudiante(e);
		return "estudiante/add";
	}
	
	@RequestMapping("/list/{estudiante}") 
	public String verEstudiante(Model model, String user, String password) {
		Estudiante e = estudianteDao.getEstudiante(user);
		model.addAttribute("estudiante", e);
		if(e.getPass() == password) {
			model.addAttribute("estudiante", estudianteDao.getEstudiante(user));
		}
		return "estudiante/update";
>>>>>>> 7741ad94ea6626ee8a01d9a36dbc602365ce6d30
	}
		
	@RequestMapping(value="/add", method=RequestMethod.POST) 
	public String processAddSubmit(@ModelAttribute("estudiante") Estudiante estudiante,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "estudiante/add";
		estudianteDao.addEstudiante(estudiante);
		return "redirect:list.html";
	}
	
	@RequestMapping(value="/update/{id}", method = RequestMethod.GET)
	public String editEstudiante(Model model, @PathVariable String id) {
		model.addAttribute("estudiante", estudianteDao.getEstudiante(id));
		return "estudiante/update";
	}
	
	@RequestMapping(value="/update/{id}", method = RequestMethod.POST) 
	public String processUpdateSubmit(@PathVariable String id, 
			@ModelAttribute("estudiante") Estudiante estudiante, 
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) 
			return "estudiante/update";
		estudianteDao.updateEstudiante(estudiante);
		return "redirect:../list"; 
	}
	
	@RequestMapping(value="/delete/{id}")
	public String processDelete(@PathVariable String id) {
		estudianteDao.deleteEstudiante(id);
		return "redirect:../list";
		}
	
	@RequestMapping("/semestre")
	public String verPreferencia() {
		return "bla, bla";
<<<<<<< HEAD
	}
=======
	}
}
>>>>>>> 7741ad94ea6626ee8a01d9a36dbc602365ce6d30
