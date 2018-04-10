package es.uji.ei1027.SAPE.dao;

import es.uji.ei1027.SAPE.model.Personal;

public interface DaoLogin {
	Personal login(final String usuario, final String pass);
}
