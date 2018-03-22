package es.uji.ei1027.clubesportiu.services;

import es.uji.ei1027.clubesportiu.dao.Nadador;
import java.util.Map;
import java.util.List;

public interface ClassificacioService {

	public Map<String, List<Nadador>> getClassificationByCountry(String prova);
	public Map<String, List<Nadador>> getClassificationByTest(String pais);
	
}
