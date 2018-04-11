<<<<<<< HEAD
package es.uji.ei1027.SAPE.controller;
=======
/*package es.uji.ei1027.SAPE.controller;
>>>>>>> 7741ad94ea6626ee8a01d9a36dbc602365ce6d30

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
import es.uji.ei1027.SAPE.dao.DaoEmpresa;
>>>>>>> 7741ad94ea6626ee8a01d9a36dbc602365ce6d30
import es.uji.ei1027.SAPE.model.Empresa;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {
	
<<<<<<< HEAD
	private EmpresaDAO empresaDao;
	
	@Autowired
	public void setEmpresaDao(EmpresaDAO empresaDao) {
=======
	private DaoEmpresa empresaDao;
	
	@Autowired
	public void setEmpresaDao(DaoEmpresa empresaDao) {
>>>>>>> 7741ad94ea6626ee8a01d9a36dbc602365ce6d30
		this.empresaDao = empresaDao;
	}
	
	@RequestMapping("/list")
	public String listEmpresas(Model model) {
		model.addAttribute("empresas", empresaDao.getEmpresas());
		return "empresa/list";
	}
	
	@RequestMapping(value="/add")
	public String addEmpresa(Model model) {
		model.addAttribute("empresa", new Empresa());
		return "empresa/add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST) 
	public String processAddSubmit(@ModelAttribute("empresa") Empresa empresa,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "empresa/add";
		empresaDao.addEmpresa(empresa);
		return "redirect:list.html";
	}
	
	@RequestMapping(value="/update/{cif}", method = RequestMethod.GET)
	public String editEmpresa(Model model, @PathVariable String cif) {
		model.addAttribute("empresa", empresaDao.getEmpresa(cif));
		return "empresa/update";
	}
	
	@RequestMapping(value="/update/{cif}", method = RequestMethod.POST) 
	public String processUpdateSubmit(@PathVariable String cif, 
			@ModelAttribute("empresa") Empresa empresa, 
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) 
			return "empresa/update";
		empresaDao.updateEmpresa(empresa);
		return "redirect:../list"; 
	}
	
	@RequestMapping(value="/delete/{cif}")
	public String processDelete(@PathVariable String cif) {
		empresaDao.deleteEmpresa(cif);
		return "redirect:../list";
	}

<<<<<<< HEAD
}
=======
}
*/
>>>>>>> 7741ad94ea6626ee8a01d9a36dbc602365ce6d30
