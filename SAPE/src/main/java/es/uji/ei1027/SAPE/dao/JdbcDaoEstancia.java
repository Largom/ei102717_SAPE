package es.uji.ei1027.SAPE.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import es.uji.ei1027.SAPE.model.Estancia;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class JdbcDaoEstancia implements DaoEstancia{
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(final DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private static final class EstanciaMapper implements RowMapper<Estancia> {
		public Estancia mapRow(final ResultSet rs, final int rowNum) throws SQLException {
			Estancia estancia = new Estancia(rs.getShort("id"), rs.getString("nifempresa"),
					rs.getString("correo"), rs.getString("descripcion"), rs.getString("contactpersona"));
			return estancia;
		}
	}

	@Override
	public Map<Short, Estancia> getEstancias(final String usu, final String pass) {
		try {
			return this.jdbcTemplate.query(
					"SELECT * FROM verestancia(?, ?)",
					new Object[] {usu, pass},
					new EstanciaMapper()).stream().collect(Collectors.toMap(Estancia::getId, item -> item));
		} catch (Exception e) {
			e.printStackTrace();
			return new HashMap<Short, Estancia>();
		}
	}

	@Override
	public Estancia getEstancia(final String usu, final String pass, final short id) {
		try {
			return this.jdbcTemplate.queryForObject(
					"SELECT * FROM verestancia(?, ?, ?)",
					new Object[] {usu, pass, id},
					new EstanciaMapper());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
