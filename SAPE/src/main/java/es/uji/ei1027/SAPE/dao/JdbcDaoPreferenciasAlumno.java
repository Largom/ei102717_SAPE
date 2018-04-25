package es.uji.ei1027.SAPE.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import es.uji.ei1027.SAPE.model.PeticionRevision;
import es.uji.ei1027.SAPE.model.PreferenciasAlumno;


public class JdbcDaoPreferenciasAlumno implements DaoPreferenciasAlumno{
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public void setDataSource(final DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private static final class AlumnoPrefMapper implements RowMapper<PreferenciasAlumno> {
		public PreferenciasAlumno mapRow(final ResultSet rs, final int rowNum) throws SQLException {
			return new PreferenciasAlumno(rs.getString("usuario"), rs.getDate("fechaultimocambio"),
					rs.g));
		}
	}
	
	private static final class PreferenciasAlumnoMapper implements RowMapper<Short> {
		public PreferenciasAlumno mapRow(final ResultSet rs, final int rowNum) throws SQLException {
			if
			pref.getPreferencias().add(rs)
		}
	}

	@Override
	public Map<String, PreferenciasAlumno> getPreferenciasAlumnos(final String usu, final String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreferenciasAlumno getPreferenciasAlumno(final String usu, final String pass, final String usuAlumno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean elegirPreferencias(final String usu, final String pass, final PreferenciasAlumno pref) {
		// TODO Auto-generated method stub
		return false;
	}


}
