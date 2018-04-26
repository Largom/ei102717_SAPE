package es.uji.ei1027.SAPE.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import es.uji.ei1027.SAPE.model.PreferenciasAlumno;


public class JdbcDaoPreferenciasAlumno implements DaoPreferenciasAlumno{
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public void setDataSource(final DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private static final class AlumnoPrefMapper implements RowMapper<PreferenciasAlumno> {
		public PreferenciasAlumno mapRow(final ResultSet rs, final int rowNum) throws SQLException {
			ArrayList<Short> ofertas = new ArrayList<Short>();
			for(String ofer : (String[])rs.getArray("ofertas").getArray()){
				ofertas.add(Short.valueOf(ofer));
			}
			return new PreferenciasAlumno(rs.getString("usuario"), rs.getDate("fechaultimocambio"),
					rs.getBoolean("cerrada"), ofertas);
		}
	}

	@Override
	public Map<String, PreferenciasAlumno> getPreferenciasAlumnos(final String usu, final String pass) {
		try {
			return this.jdbcTemplate.query(
					"SELECT usuario, BOOL_AND(CASE estado WHEN 'cerrada' THEN TRUE ELSE FALSE END) AS cerrada, "
					+ "MAX(fechaultimocambio) AS fechaultimocambio, array_agg(oferta) AS ofertas "
					+ "FROM public.verpreferencia(?, '?) GROUP BY usuario",
					new Object[] {usu, pass},
					new AlumnoPrefMapper()).stream().collect(Collectors.toMap(PreferenciasAlumno::getIdEstudiante, item -> item));
		} catch (Exception e) {
			e.printStackTrace();
			return new HashMap<String, PreferenciasAlumno>();
		}
	}

	@Override
	public PreferenciasAlumno getPreferenciasAlumno(final String usu, final String pass, final String usuAlumno) {
		try {
			return this.jdbcTemplate.queryForObject(
					"SELECT usuario, BOOL_AND(CASE estado WHEN 'cerrada' THEN TRUE ELSE FALSE END) AS cerrada, "
					+ "MAX(fechaultimocambio) AS fechaultimocambio, array_agg(oferta) AS ofertas "
					+ "FROM public.verpreferencia(?, ?, ?) GROUP BY usuario",
					new Object[] {usu, pass, usuAlumno},
					new AlumnoPrefMapper());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean elegirPreferencias(final String usu, final String pass, final PreferenciasAlumno pref) {
		try {
			return 1 == this.jdbcTemplate.update("SELECT creareditarpreferencias(?, ?, ?::integer[])",
					usu, pass, pref);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean cerrarAbrirPreferencias(final String usu, final String pass, final boolean cerrado, final String usuAlumno) {
		try {
			return 1 == this.jdbcTemplate.update("SELECT cerrarabrirpreferencias(?, ?, ?, ?)",
					usu, pass, cerrado, usuAlumno);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


}
