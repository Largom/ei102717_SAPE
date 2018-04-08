package es.uji.ei1027.SAPE.controller;

import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AsignacionController {
	
	@RequestMapping("/asignacion")
	public String asignacionWeb(Model model) {
		String message = "Probando la web de SAPE";
		model.addAttribute("message", message);
		return "asignacino";
	}
	
}
