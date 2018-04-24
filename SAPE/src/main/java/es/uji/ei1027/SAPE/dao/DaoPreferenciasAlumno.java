package es.uji.ei1027.SAPE.dao;

import java.util.List;

import es.uji.ei1027.SAPE.model.PreferenciasAlumno;

public interface DaoPreferenciasAlumno {
/*
	List<PreferenciasAlumno> getPreferenciasAlumnos();
	PreferenciasAlumno getPreferenciasAlumno(String usuAlumno);
	void addPreferenciasAlumno(PreferenciasAlumno prefAlum);
	void updatePreferenciasAlumno(PreferenciasAlumno prefAlum);
	void deletePreferenciasAlumno(String usuAlumno);
*/

	List<PreferenciasAlumno> getPreferenciasAlumnos(String usu, String pass);
	PreferenciasAlumno getPreferenciasAlumno(String usu, String pass, String usuAlumno);
	boolean elegirPreferencias(String usu, String pass, PreferenciasAlumno pref);
}
