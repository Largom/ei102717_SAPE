/*
package es.uji.ei1027.SAPE.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import es.uji.ei1027.SAPE.dao.DaoLogin;
import es.uji.ei1027.SAPE.model.*;

@Controller
@RequestMapping("/personal")
public class PersonalController {

	
	private DaoLogin personalDAO;
	
	@RequestMapping(value="/loginestudiante", method = RequestMethod.POST )
	public String loginEstudiante(Model model, @PathVariable String usuario, @PathVariable String pass ) {
		model.addAttribute("loginEstudiante", personalDAO.verEstudiante(usuario, pass));
		return "personal/estudiante";
	}
	
	@RequestMapping(value="/logincoordinador", method = RequestMethod.POST )
	public String loginCoordinador(Model model, @PathVariable String usuario, @PathVariable String pass ) {
		model.addAttribute("loginCoordinador", personalDAO.verCoordinador(usuario, pass));
		return "personal/coordinador";
	}
	
	@RequestMapping(value="/loginempresa", method = RequestMethod.POST )
	public String loginEmpresa(Model model, @PathVariable String usuario, @PathVariable String pass ) {
		model.addAttribute("loginEmpresa", personalDAO.verEmpresa(usuario, pass));
		return "personal/empresa";
	}
	
}
*/