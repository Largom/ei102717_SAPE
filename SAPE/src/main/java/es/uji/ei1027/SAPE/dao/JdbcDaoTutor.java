package es.uji.ei1027.SAPE.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import es.uji.ei1027.SAPE.model.Tutor;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class JdbcDaoTutor implements DaoTutor{
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(final DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private static final class TutorMapper implements RowMapper<Tutor> {
		public Tutor mapRow(final ResultSet rs, final int rowNum) throws SQLException {
			Tutor tutor = new Tutor(rs.getString("nombre"), rs.getString("correo"),
					rs.getString("despacho"), rs.getString("departamento"));
			return tutor;
		}
	}

	@Override
	public Map<String, Tutor> getTutores(final String usu, final String pass) {
		try {
			return this.jdbcTemplate.query(
					"SELECT * FROM vertutor(?, ?)",
					new Object[] {usu, pass},
					new TutorMapper()).stream().collect(Collectors.toMap(Tutor::getCorreo, item -> item));
		} catch (Exception e) {
			e.printStackTrace();
			return new HashMap<String, Tutor>();
		}
	}

	public Tutor getTutor(final String usu, final String pass, final String correo) {
		try {
			return this.jdbcTemplate.queryForObject(
					"SELECT * FROM vertutor(?, ?, ?)",
					new Object[] {usu, pass, correo},
					new TutorMapper());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
