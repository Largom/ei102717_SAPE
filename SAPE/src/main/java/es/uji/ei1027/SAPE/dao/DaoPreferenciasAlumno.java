package es.uji.ei1027.SAPE.dao;

import java.util.Map;

import es.uji.ei1027.SAPE.model.PreferenciasAlumno;

public interface DaoPreferenciasAlumno {
/*
	List<PreferenciasAlumno> getPreferenciasAlumnos();
	PreferenciasAlumno getPreferenciasAlumno(String usuAlumno);
	void addPreferenciasAlumno(PreferenciasAlumno prefAlum);
	void updatePreferenciasAlumno(PreferenciasAlumno prefAlum);
	void deletePreferenciasAlumno(String usuAlumno);
*/

	Map<String, PreferenciasAlumno> getPreferenciasAlumnos(final String usu, final String pass);
	PreferenciasAlumno getPreferenciasAlumno(final String usu, final String pass, final String usuAlumno);
	boolean elegirPreferencias(final String usu, final String pass, final PreferenciasAlumno pref);
	boolean cerrarAbrirPreferencias(final String usu, final String pass, final boolean cerrado, final String usuAlumno);
}
