package es.uji.ei1027.clubesportiu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import es.uji.ei1027.clubesportiu.dao.*;
import es.uji.ei1027.clubesportiu.model.Classificacio;
import es.uji.ei1027.clubesportiu.model.Nadador;

@Controller
@RequestMapping("/prova")
public class ProvaController {
    
	@Autowired
	NadadorDao nadadorDao;
	
	@Autowired
	ClassificacioDao classifDao;
	
	@Autowired
	ProvaDao provaDao;
    
    @RequestMapping("/prova")
    public String provaWeb(Model model) {
        String message = "Provant la Web del Club Esportiu";
        model.addAttribute("message", message);
        return "prova/prova";
    }
	
	@RequestMapping("/prova1_id")
	public String prova3ID(Model model) {
		List<Nadador> nadadores = nadadorDao.getNadadors();
		String message="";
		for (Nadador nadador : nadadores)
			message+="Atleta: "+nadador+";	";
		model.addAttribute("message",message);
    	return "prova/prova";
	}
	
	@RequestMapping("/prova2_id")
	public String prova4ID(Model model) {
		List<Classificacio> classificaciones = classifDao.getClassificacions();
		String message="";
		for (Classificacio classif : classificaciones)
			message+="Atleta: "+classif+";	";
		model.addAttribute("message",message);
    	return "prova/prova";
	}
	
	@RequestMapping("/list") 
	public String listNadadors(Model model) {
		model.addAttribute("proves", provaDao.getProves());
		return "prova/list";
	}
}