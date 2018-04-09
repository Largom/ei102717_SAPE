package es.uji.ei1027.SAPE.dao;

import java.util.HashMap;

import es.uji.ei1027.SAPE.model.Estudiante;



public interface DaoEstudiante {
	HashMap<String, Estudiante> getEstudiantes();
	Estudiante getEstudiante(String nif);
	void addEstudiante(Estudiante est);
	void updateEstudiante(Estudiante est);
	void deleteEstudiante(String nif);
	
	HashMap<String, Estudiante> getEstudiantes(String usu, String pass);
	Estudiante getEstudiante(String usu, String pass, String nif);
}
