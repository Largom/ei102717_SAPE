package es.uji.ei1027.SAPE.dao;

import java.util.List;

import es.uji.ei1027.SAPE.model.Tutor;


public interface DaoTutor {
	List<Tutor> getTutors();
	Tutor getTutor(String correo);
	void addTutor(Tutor tut);
	void updateTutor(Tutor tut);
	void deleteTutor(String correo);
	
	List<Tutor> getTutor(String usu, String pass);
	Tutor getTutor(String usu, String pass, String correo);
}
