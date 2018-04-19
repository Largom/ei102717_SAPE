package es.uji.ei1027.SAPE.dao;

import java.util.Map;

import es.uji.ei1027.SAPE.model.EstadoOferta;
import es.uji.ei1027.SAPE.model.OfertaProyecto;

public interface DaoOfertaProyecto {
/*
	List<OfertaProyecto> getOfertaProyectos();
	OfertaProyecto getOfertaProyecto(Short id);
	void addOfertaProyecto(OfertaProyecto ofPro);
	void updateOfertaProyecto(OfertaProyecto ofPro);
	void deleteOfertaProyecto(Short id);
*/

	Map<Short, OfertaProyecto> getOfertasProyectos(String usu, String pass);
	OfertaProyecto getOfertaProyecto(String usu, String pass, String nif);
	boolean crearEditarOfertaProyecto(String usu, String pass, OfertaProyecto ofePro);
	boolean anularOfertaProyecto(String usu, String pass, short id);
	boolean editarEstadoOfertaProyecto(String usu, String pass, short id, EstadoOferta estado);
}
