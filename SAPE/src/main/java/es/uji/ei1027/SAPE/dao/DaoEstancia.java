package es.uji.ei1027.SAPE.dao;

import java.util.HashMap;

import es.uji.ei1027.SAPE.model.Estancia;



public interface DaoEstancia {
	HashMap<Short, Estancia> getEstancias();
	Estancia getEstancia(short id);
	void addEstancia(Estancia esta);
	void updateEstancia(Estancia esta);
	void deleteEstancia(short id);
	
	HashMap<Short, Estancia> getEstancias(String usu, String pass);
	Estancia getEstancia(String usu, String pass, String cif);
}
