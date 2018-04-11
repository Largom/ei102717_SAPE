package es.uji.ei1027.SAPE.dao;



import java.util.List;

import es.uji.ei1027.SAPE.model.Asignacion;

public interface DaoAsignacion {
	List<Asignacion> getAsignaciones();
	Asignacion getAsignacion(short id);
	void addAsignacion(Asignacion asig);
	void updateAsignacion(Asignacion asig);
	void deleteAsignacion(short id);
	
	List<Asignacion> getAsignaciones(String usu, String pass);
	Asignacion getAsignacion(String usu, String pass, short id);
	boolean crearEditarAsignacion(String usu, String pass, Asignacion asig);
	boolean anularAsignacion(String usu, String pass, short id);
	boolean aceptaAsignacion(String usu, String pass, short id);
	boolean rechazaAsignacion(String usu, String pass, short id);
	boolean petCambioAsignacion(String usu, String pass, short id, String comentario);
}
