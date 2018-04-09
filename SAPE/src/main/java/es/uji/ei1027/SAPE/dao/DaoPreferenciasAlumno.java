package es.uji.ei1027.SAPE.dao;

import java.util.HashMap;

import es.uji.ei1027.SAPE.model.PreferenciasAlumno;

public interface DaoPreferenciasAlumno {
	HashMap<String, PreferenciasAlumno> getPreferenciasAlumnos();
	PreferenciasAlumno getPreferenciasAlumno(String usuAlumno);
	void addPreferenciasAlumno(PreferenciasAlumno prefAlum);
	void updatePreferenciasAlumno(PreferenciasAlumno prefAlum);
	void deletePreferenciasAlumno(String usuAlumno);

	HashMap<String, PreferenciasAlumno> getPreferenciasAlumnos(String usu, String pass);
	PreferenciasAlumno getPreferenciasAlumno(String usu, String pass, String usuAlumno);
}
