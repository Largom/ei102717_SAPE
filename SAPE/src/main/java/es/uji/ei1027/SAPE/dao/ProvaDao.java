package es.uji.ei1027.clubesportiu.dao;

import java.util.List;

import es.uji.ei1027.clubesportiu.model.Classificacio;
import es.uji.ei1027.clubesportiu.model.Prova;

public interface ProvaDao {
	List<Prova> getProves();
	Prova getProva(String nom);
	void addProva(Prova prova);
	void updateProva(Prova prova);
	void deleteProva(Prova prova);
	List<Prova> getProvaEnPais(String pais);
}
