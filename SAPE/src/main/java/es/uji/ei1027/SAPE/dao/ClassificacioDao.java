package es.uji.ei1027.clubesportiu.dao;

import java.util.List;

import es.uji.ei1027.clubesportiu.model.Classificacio;


public interface ClassificacioDao {
	List<Classificacio> getClassificacions();
	Classificacio getClassificacio(String nAtleta, String nProva);
	void addClassificacio(Classificacio classif);
	void updateClassificacio(Classificacio classif);
	void deleteClassificacio(Classificacio classif);
	List<Classificacio> getClassificacioProva(String nomProva);
}
