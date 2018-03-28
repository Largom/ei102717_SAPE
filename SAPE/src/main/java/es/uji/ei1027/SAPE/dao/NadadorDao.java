package es.uji.ei1027.clubesportiu.dao;

import java.util.List;

import es.uji.ei1027.clubesportiu.model.Nadador;


public interface NadadorDao {
	List<Nadador> getNadadors();
	Nadador getNadador(String nom);
	void addNadador(Nadador nom);
	void updateNadador(Nadador nom);
	void deleteNadador(String nom);
	List<Nadador> getNadadorEnProvaPais(String nomProva, String pais);
}
