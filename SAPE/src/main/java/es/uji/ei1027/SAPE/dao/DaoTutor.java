package es.uji.ei1027.SAPE.dao;

import java.util.Map;

import es.uji.ei1027.SAPE.model.Tutor;


public interface DaoTutor {
/*
	List<Tutor> getTutors();
	Tutor getTutor(String correo);
	void addTutor(Tutor tut);
	void updateTutor(Tutor tut);
	void deleteTutor(String correo);
*/
	Map<String, Tutor> getTutores(final String usu, final String pass);
	Tutor getTutor(final String usu, final String pass, final String correo);
}
