package es.uji.ei1027.SAPE.dao;

import java.util.List;

import es.uji.ei1027.SAPE.model.Estudiante;



public interface DaoEstudiante {
	List<Estudiante> getEstudiantes();
	Estudiante getEstudiante(String nif);
	void addEstudiante(Estudiante est);
	void updateEstudiante(Estudiante est);
	void deleteEstudiante(String nif);
	
	List<Estudiante> getEstudiantes(String usu, String pass);
	Estudiante getEstudiante(String usu, String pass, String nif);
	boolean elegirSemestre(String usu, String pass);
}
