package es.uji.ei1027.SAPE.dao;

import java.util.Date;
import java.util.List;

import es.uji.ei1027.SAPE.model.PeticionRevision;

public interface DaoPeticionRevision {
	List<PeticionRevision> getPeticionRevisiones();
	List<PeticionRevision> getPeticionRevisiones(short idOferta);
	List<PeticionRevision> getPeticionRevisiones(Date fechaOferta);
	PeticionRevision getPeticionRevision(short idOferta, Date fechaOferta);
	void addPeticionRevision(PeticionRevision petRev);
	void updatePeticionRevision(PeticionRevision petRev);
	void deletePeticionRevision(short idOferta, Date fechaOferta);

	List<PeticionRevision> getPeticionRevisiones(String usu, String pass);
	List<PeticionRevision> getPeticionRevisiones(String usu, String pass, short idOferta);
	List<PeticionRevision> getPeticionRevisiones(String usu, String pass, Date fechaOferta);
	PeticionRevision getPeticionRevision(String usu, String pass, short idOferta, Date fechaOferta);
}
