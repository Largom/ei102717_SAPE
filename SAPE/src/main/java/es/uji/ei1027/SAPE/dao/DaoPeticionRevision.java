package es.uji.ei1027.SAPE.dao;

import java.util.Date;
import java.util.List;

import es.uji.ei1027.SAPE.model.PeticionRevision;

public interface DaoPeticionRevision {
/*
	List<PeticionRevision> getPeticionRevisiones();
	List<PeticionRevision> getPeticionRevisiones(short idOferta);
	List<PeticionRevision> getPeticionRevisiones(Date fechaOferta);
	PeticionRevision getPeticionRevision(short idOferta, Date fechaOferta);
	void addPeticionRevision(PeticionRevision petRev);
	void updatePeticionRevision(PeticionRevision petRev);
	void deletePeticionRevision(short idOferta, Date fechaOferta);
*/
	List<PeticionRevision> getPeticionRevisiones(final String usu, final String pass);
	List<PeticionRevision> getPeticionRevisiones(final String usu, final String pass, final short idOferta);
	List<PeticionRevision> getPeticionRevisiones(final String usu, final String pass, final Date fechaOferta);
	PeticionRevision getPeticionRevision(final String usu, final String pass, final short idOferta, final Date fechaOferta);
	boolean crearEditarPeticionRevision(final String usu, final String pass, final PeticionRevision petRev);
	boolean anularPeticionRevision(final String usu, final String pass, final PeticionRevision petRev);
}
