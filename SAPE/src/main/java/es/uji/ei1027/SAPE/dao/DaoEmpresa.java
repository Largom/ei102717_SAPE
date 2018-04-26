package es.uji.ei1027.SAPE.dao;


import java.util.List;

import es.uji.ei1027.SAPE.model.Empresa;

public interface DaoEmpresa {
	List<Empresa> getEmpresas();
	//Empresa getEmpresa(String cif);
	//void addEmpresa(Empresa emp);
	//void updateEmpresa(Empresa emp);
	//void deleteEmpresa(String cif);
	
	//List<Empresa> getEmpresas(String usu, String pass);
	//Empresa getEmpresa(String usu, String pass, String cif);
}
