package es.uji.ei1027.SAPE.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult; 
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.SAPE.dao.DaoLogin;
import es.uji.ei1027.SAPE.model.Personal;

import org.springframework.validation.Errors; 
import org.springframework.validation.Validator;

class PersonalValidator implements Validator { 
    @Override
    public boolean supports(Class<?> cls) { 
        return Personal.class.isAssignableFrom(cls);
    }
    @Override 
    public void validate(Object obj, Errors errors) {
    	Personal user = (Personal)obj;
    	if (user.getUsuario().trim().equals(""))
		       errors.rejectValue("usuario", "obligatori",
		                          "Es necesario introducir un nombre de usuario");
    	if (user.getUsuario().length()>20)
		       errors.rejectValue("usuario", "obligatori",
		                          "El nombre de usuario no puede se superior a 20 caracteres");
    	if (user.getPass().trim().equals(""))
		       errors.rejectValue("pass", "obligatori",
		                          "Es necesario introducir una contraseña");
    	if (user.getPass().length()>100)
		       errors.rejectValue("pass", "obligatori",
		                          "La contraseña no puede se superior a 100 caracteres");
    }
}

@Controller
public class LoginController {
    @Autowired
    private DaoLogin userDao;

    @RequestMapping("/login")
    public String login(Model model, HttpSession session) {
    	if (session.getAttribute("user") == null) {
    		model.addAttribute("user", new Personal());
        	return "login";
    	}
    	return "redirect:/";
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String checkLogin(@ModelAttribute("user") Personal username,          
                BindingResult bindingResult, HttpSession session) {
    	//Personal usuar = new Personal(username, pass);
    	PersonalValidator personalValidator = new PersonalValidator(); 
        personalValidator.validate(username, bindingResult);
        if (bindingResult.hasErrors()) {
        	return "login";
        }
     // Comprova que el login siga correcte 
        // intentant carregar les dades de l'usuari 
        username = userDao.login(username.getUsuario(), username.getPass()); 
        if (username == null) {
            bindingResult.rejectValue("pass", "badpw", "Nombre de usuario o contraseña incorrecto"); 
            return "login";
        }
        // Autenticats correctament. 
        // Guardem les dades de l'usuari autenticat a la sessió
        session.setAttribute("user", username); 
        
        String nextUrl = (String)session.getAttribute("nextUrl");
        // Torna a la pàgina principal
        if (nextUrl != null && !nextUrl.trim().equals("")) {
        	session.removeAttribute("nextUrl");
        	return "redirect:"+nextUrl;
        }
        return "redirect:/";
    }

    @RequestMapping("/logout") 
    public String logout(HttpSession session) {
        session.invalidate(); 
        return "redirect:/";
    }
}