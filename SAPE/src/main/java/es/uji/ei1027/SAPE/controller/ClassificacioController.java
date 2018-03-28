package es.uji.ei1027.SAPE.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.SAPE.services.ClassificacioService;



@Controller
@RequestMapping("/classificacio")
public class ClassificacioController {

	/*
	private NadadorDao nadadorDao; 

	@Autowired
	public void setNadadorDao(NadadorDao nadadorDao) {
		this.nadadorDao=nadadorDao;
	}
	
	@RequestMapping("/list") 
	public String listNadadors(Model model) {
		model.addAttribute("nadadors", nadadorDao.getNadadors());
		return "nadador/list";
	}
	
	@RequestMapping(value="/add") 
	public String addNadador(Model model) {
		model.addAttribute("nadador", new Nadador());
		return "nadador/add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST) 
	public String processAddSubmit(@ModelAttribute("nadador") Nadador nadador,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "nadador/add";
		nadadorDao.addNadador(nadador);
		return "redirect:list.html";
	}
	
	@RequestMapping(value="/update/{nom}", method = RequestMethod.GET)
	public String editNadador(Model model, @PathVariable String nom) {
		model.addAttribute("nadador", nadadorDao.getNadador(nom));
		return "nadador/update";
	}
	
	@RequestMapping(value="/update/{nom}", method = RequestMethod.POST) 
	public String processUpdateSubmit(@PathVariable String nom, 
			@ModelAttribute("nadador") Nadador nadador, 
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) 
			return "nadador/update";
		nadadorDao.updateNadador(nadador);
		return "redirect:../list"; 
	}
	
	@RequestMapping(value="/delete/{nom}")
	public String processDelete(@PathVariable String nom) {
		nadadorDao.deleteNadador(nom);
		return "redirect:../list";
	}
	*/
	
	private ClassificacioService classificacioService;

	@Autowired
	public void setClassificacioService(ClassificacioService                                                classificacioService) {
		this.classificacioService = classificacioService;
	}
	
	@RequestMapping("/perpais")
	public String listClsfPerPais(Model model) {
		model.addAttribute("nomprova", "Duos Sincro");
		model.addAttribute("classificacions", 
				classificacioService.getClassificationByCountry("Duos Sincro"));
		return "classificacio/perpais";
	}
	
	@RequestMapping("/perpais/{nomprova}")
	public String listClsfPerPais(Model model, @PathVariable String nomprova) {
		model.addAttribute("classificacions", 
				classificacioService.getClassificationByCountry(nomprova));
		return "classificacio/perpais";
	}
	
	@RequestMapping("/perprova")
	public String listClsfPerProva(Model model) {
		model.addAttribute("pais", "Espanya");
		model.addAttribute("classificacions", 
				classificacioService.getClassificationByProva("Espanya"));
		return "classificacio/perprova";
	}
	
	@RequestMapping("/perprova/{pais}")
	public String listClsfPerProva(Model model, @PathVariable String pais) {
		model.addAttribute("classificacions", 
				classificacioService.getClassificationByProva(pais));
		return "classificacio/perprova";
	}

}
