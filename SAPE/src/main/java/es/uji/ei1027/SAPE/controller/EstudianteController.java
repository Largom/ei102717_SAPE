package es.uji.ei1027.SAPE.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.SAPE.dao.DaoEstudiante;
import es.uji.ei1027.SAPE.model.Estudiante;

@Controller
@RequestMapping("estudiante")

public class EstudianteController {
	
	private DaoEstudiante estudianteDao;
	
	@Autowired
	public  void setEstudianteDao(DaoEstudiante estudianteDao) {
		this.estudianteDao = estudianteDao;
	}
	
	@RequestMapping("/list")
	public String listEstudiante(Model model) {
		model.addAttribute("estudiantes", estudianteDao.getEstudiantes());
		return "estudiante/list";
	}
	
	@RequestMapping(value="/add")
	public String addEstudiante(Model model) {

		Estudiante e = new Estudiante();
		model.addAttribute("estudiante", e);
		estudianteDao.addEstudiante(e);
		return "estudiante/add";
	}
	
	@RequestMapping("/list/{estudiante}") 
	public String verEstudiante(Model model, String user, String password) {
		Estudiante e = estudianteDao.getEstudiante(user);
		model.addAttribute("estudiante", e);

		model.addAttribute("estudiante", new Estudiante());
		return "estudiante/add";
	}
	
	@RequestMapping("/list/{dni}") 
	public String verEstudiante(Model model, String user, String password) {
		Estudiante e=estudianteDao.getEstudiante(user);

		if(e.getPass() == password) {
			model.addAttribute("estudiante", e);
		}
		return "estudiante/update";
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
	}
}