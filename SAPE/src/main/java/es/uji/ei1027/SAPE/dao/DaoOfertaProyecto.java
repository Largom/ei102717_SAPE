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

	Map<Short, OfertaProyecto> getOfertasProyectos(final String usu, final String pass);
	OfertaProyecto getOfertaProyecto(final String usu, final String pass, final short id);
	boolean crearEditarOfertaProyecto(final String usu, final String pass, final OfertaProyecto ofePro);
	boolean anularOfertaProyecto(final String usu, final String pass, final short id);
	boolean editarEstadoOfertaProyecto(final String usu, final String pass, final short id, final EstadoOferta estado);
}
