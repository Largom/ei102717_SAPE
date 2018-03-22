package es.uji.ei1027.clubesportiu.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uji.ei1027.clubesportiu.Classificacio.*;
import es.uji.ei1027.clubesportiu.Nadador.*;
import es.uji.ei1027.clubesportiu.dao.*;


@Service
public class ClassificacioSvc implements ClassificacioService {

    @Autowired
    NadadoresDAO nadadoresdao;

    @Autowired
    ClassificacioDAO classificaciodao;

    @Override
    public Map<String, List<Nadador>> getClassificationByCountry(String prova) {
       
    	List<Classificacio> classProva =  classificaciodao.getClassificacioProva(prova);
    	
        HashMap<String,List<Nadador>> nadadorsPerPais = new HashMap<String,List<Nadador>>();
        
        for (Classificacio clsf : classProva) {
            Nadador nadador = nadadoresdao.getNadador(clsf.getNomNadador());
            if (!nadadorsPerPais.containsKey(nadador.getPais()))
                nadadorsPerPais.put(nadador.getPais(), new ArrayList<Nadador>());        
            nadadorsPerPais.get(nadador.getPais()).add(nadador);
        }
        
        return nadadorsPerPais;
    }
    
    
    public Map<String, List<Nadador>> getClassificationByTest(String pais){
    	
    	List<Classificacio> classProva =  classificaciodao.getClassificacionsPorPais(pais); // devuelve pruebas ya filtradas por pais
    	
        HashMap<String,List<Nadador>> pruebasYnadadorsPerPais = new HashMap<String,List<Nadador>>();
    	
        for (Classificacio clsf : classProva) {
            Nadador nadador = nadadoresdao.getNadador(clsf.getNomNadador());
            if (!pruebasYnadadorsPerPais.containsKey(clsf.getNomProva()))
            		pruebasYnadadorsPerPais.put(clsf.getNomProva(), new ArrayList<Nadador>());        
            pruebasYnadadorsPerPais.get(clsf.getNomProva()).add(nadador);
            
        }
        
            return pruebasYnadadorsPerPais;
    	}
}



