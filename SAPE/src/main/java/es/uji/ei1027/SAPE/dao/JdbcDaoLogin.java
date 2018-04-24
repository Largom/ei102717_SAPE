package es.uji.ei1027.SAPE.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import es.uji.ei1027.SAPE.model.Empresa;
import es.uji.ei1027.SAPE.model.Personal;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class JdbcDaoLogin implements DaoLogin{
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(final DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Personal login(final String usuario, final String pass) {
		short tipo=-1;
		try {
			tipo = this.jdbcTemplate.queryForObject("SELECT login(?, ?)",
					new Object[] {usuario, pass}, Short.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		switch(tipo){
			case 0:
				//obtener Empresa
				Empresa e;
				return new Empresa(usuario, pass)
				break;
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			default:
				return null;
		}
	}
}
