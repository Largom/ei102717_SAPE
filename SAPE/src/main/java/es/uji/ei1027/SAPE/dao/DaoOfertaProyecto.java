package es.uji.ei1027.SAPE.dao;

import java.util.HashMap;

import es.uji.ei1027.SAPE.model.OfertaProyecto;



public interface DaoOfertaProyecto {
	HashMap<Short, OfertaProyecto> getOfertaProyectos();
	OfertaProyecto getOfertaProyecto(Short id);
	void addOfertaProyecto(OfertaProyecto ofPro);
	void updateOfertaProyecto(OfertaProyecto ofPro);
	void deleteOfertaProyecto(Short id);

	HashMap<String, OfertaProyecto> getOfertasProyectos(String usu, String pass);
	OfertaProyecto getOfertaProyecto(String usu, String pass, String nif);
}
