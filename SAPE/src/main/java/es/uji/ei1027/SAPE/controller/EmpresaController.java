package es.uji.ei1027.SAPE.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import es.uji.ei1027.SAPE.dao.DaoEmpresa;
import es.uji.ei1027.SAPE.model.Empresa;
import es.uji.ei1027.SAPE.model.Personal;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {


	private DaoEmpresa empresaDao;
	
	@Autowired
	public void setEmpresa (DaoEmpresa empresaDao) {
		this.empresaDao = empresaDao;
	}
	
	@RequestMapping("/list")
	public String listEmpresas(Model model, HttpSession session) {
		
		Personal usuario = (Personal) session.getAttribute("user");
		
		if(usuario == null) { 
			
	          model.addAttribute("user", ""); 
	          model.addAttribute("pass", "");
	          session.setAttribute("nextUrl", "/empresa/list.html"); 
	          return "login";
		}
		
		model.addAttribute("empresas", empresaDao.getEmpresas(usuario.getUsuario(), usuario.getPass()));
		return "empresa/list";
	}

	@RequestMapping(value="/get/{cif}", method = RequestMethod.GET)
	public String buscaEmpresa(Model model, HttpSession session, @PathVariable String cif) {
		
		Personal usuario = (Personal) session.getAttribute("user");
		
		if(usuario == null) { 
			
	          model.addAttribute("user", ""); 
	          model.addAttribute("pass", "");
	          session.setAttribute("nextUrl", "/empresa/list.html"); 
	          return "login";
		}
		
		model.addAttribute("empresa", empresaDao.getEmpresa(usuario.getUsuario(), usuario.getPass(), cif));
		return "empresa/list";
	}
	
	
}







