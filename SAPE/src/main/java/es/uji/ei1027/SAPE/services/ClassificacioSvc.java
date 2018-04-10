/*package es.uji.ei1027.clubesportiu.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uji.ei1027.clubesportiu.dao.ClassificacioDao;
import es.uji.ei1027.clubesportiu.dao.NadadorDao;
import es.uji.ei1027.clubesportiu.dao.ProvaDao;
import es.uji.ei1027.clubesportiu.model.Classificacio;
import es.uji.ei1027.clubesportiu.model.Nadador;
import es.uji.ei1027.clubesportiu.model.Prova;

@Service
public class ClassificacioSvc implements ClassificacioService {

	@Autowired
	NadadorDao nadadorDao;
	
	@Autowired
	ClassificacioDao classificacioDao;
	
	@Autowired
	ProvaDao provaDao;
	
	@Override
	public Map<String, List<Nadador>> getClassificationByCountry(String prova) {
		List<Classificacio> classProva = 
				classificacioDao.getClassificacioProva(prova);
		HashMap<String,List<Nadador>> nadadorsPerPais = 
				new HashMap<String,List<Nadador>>();
		for (Classificacio clsf : classProva) {
		    Nadador nadador = nadadorDao.getNadador(clsf.getNomNadador());
		    if (!nadadorsPerPais.containsKey(nadador.getPais()))
		        nadadorsPerPais.put(nadador.getPais(),
		        		new ArrayList<Nadador>());        
		    nadadorsPerPais.get(nadador.getPais()).add(nadador);
		}
		return nadadorsPerPais;
	}

	@Override
	public Map<String, List<Nadador>> getClassificationByProva(String pais) {
		List<Prova> provaPais = provaDao.getProvaEnPais(pais);
		HashMap<String,List<Nadador>> nadadorsPerProva = 
				new HashMap<String,List<Nadador>>();
		for (Prova prova : provaPais) {
			List<Nadador> nadador = nadadorDao.getNadadorEnProvaPais(prova.getNom(), pais);
			nadadorsPerProva.put(prova.getNom(), nadador);
		}
		return nadadorsPerProva;
	}
}
*/