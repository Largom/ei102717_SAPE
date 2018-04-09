package es.uji.ei1027.SAPE.dao;


import java.util.HashMap;

import es.uji.ei1027.SAPE.model.Asignacion;

public interface DaoAsignacion {
	HashMap<Short, Asignacion> getAsignaciones();
	Asignacion getAsignacion(short id);
	void addAsignacion(Asignacion asig);
	void updateAsignacion(Asignacion asig);
	void deleteAsignacion(short id);
	
	HashMap<Short, Asignacion> getAsignaciones(String usu, String pass);
	Asignacion getAsignacion(String usu, String pass, short id);
}
