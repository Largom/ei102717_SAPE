package es.uji.ei1027.SAPE.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import es.uji.ei1027.SAPE.dao.DaoTutor;
import es.uji.ei1027.SAPE.model.Personal;


@Controller
@RequestMapping("/tutor")
public class TutorController {

	private DaoTutor tutorDAO;
	
	@Autowired
	public void setTutorDao(DaoTutor tutorDao) {
		this.tutorDAO = tutorDao;
	}
	
	
	@RequestMapping("/list.html")
	public String listaTutores(HttpSession session, Model model) {
		Personal usuario = (Personal) session.getAttribute("user");
		if(usuario == null) {
			session.setAttribute("nextUrl", "/tutor/list.html");
			model.addAttribute("user", new String());
			model.addAttribute("pass", new String());
			return "login";
		}
		
		model.addAttribute("users", tutorDAO.getTutores(usuario.getUsuario(), usuario.getPass()));
		return "tutor/list";
	}
	
	@RequestMapping(value="/{correo}", method = RequestMethod.GET )
	public String perfilTutor(HttpSession session, Model model, @PathVariable String correo ) {
		Personal usuario = (Personal) session.getAttribute("user");
		if(usuario == null) {
			session.setAttribute("nextUrl", "/tutor/"+correo+".html");
			model.addAttribute("user", new String());
			model.addAttribute("pass", new String());
			return "login";
		}
		model.addAttribute("perfil", tutorDAO.getTutor(usuario.getUsuario(), usuario.getPass(), correo));
		return "tutor/perfil";
	}

}
