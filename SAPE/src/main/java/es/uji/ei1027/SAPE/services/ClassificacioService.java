package es.uji.ei1027.clubesportiu.services;

import java.util.List;
import java.util.Map;

import es.uji.ei1027.clubesportiu.model.Nadador;

public interface ClassificacioService {
	Map<String, List<Nadador>> getClassificationByCountry(String prova);
	Map<String, List<Nadador>> getClassificationByProva(String pais);
}
