package es.uji.ei1027.SAPE.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import es.uji.ei1027.SAPE.model.Empresa;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class JdbcDaoEmpresa implements DaoEmpresa{
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(final DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private static final class EmpresaMapper implements RowMapper<Empresa> {
		public Empresa mapRow(final ResultSet rs, final int rowNum) throws SQLException {
			Empresa empresa = new Empresa(rs.getString("nombre"), rs.getString("nif"),
					rs.getString("domicilio"), rs.getString("telefonoprincipal"));
			return empresa;
		}
	}

	@Override
	public Map<String, Empresa> getEmpresas(final String usu, final String pass) {
		try {
			return this.jdbcTemplate.query(
					"SELECT * FROM verempresa(?, ?)",
					new Object[] {usu, pass},
					new EmpresaMapper()).stream().collect(Collectors.toMap(Empresa::getCif, item -> item));
		} catch (Exception e) {
			e.printStackTrace();
			return new HashMap<String, Empresa>();
		}
	}

	@Override
	public Empresa getEmpresa(final String usu, final String pass,final  String cif) {
		try {
			return this.jdbcTemplate.queryForObject(
					"SELECT * FROM verempresa(?, ?, ?)",
					new Object[] {usu, pass, cif},
					new EmpresaMapper());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
