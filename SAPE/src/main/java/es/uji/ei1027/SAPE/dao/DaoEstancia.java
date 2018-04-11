package es.uji.ei1027.SAPE.dao;

import java.util.List;

import es.uji.ei1027.SAPE.model.Estancia;



public interface DaoEstancia {
	List<Estancia> getEstancias();
	Estancia getEstancia(short id);
	void addEstancia(Estancia esta);
	void updateEstancia(Estancia esta);
	void deleteEstancia(short id);
	
	List<Estancia> getEstancias(String usu, String pass);
	Estancia getEstancia(String usu, String pass, String cif);
}
