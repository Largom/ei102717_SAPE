package es.uji.ei1027.SAPE.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import es.uji.ei1027.SAPE.model.OfertaProyecto;


public class JdbcDaoOfertaProyecto implements DaoOfertaProyecto{
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public void setDataSource(final DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private static final class OfertaProyectoMapper implements RowMapper<OfertaProyecto> {
		public OfertaProyecto mapRow(final ResultSet rs,final  int rowNum) throws SQLException {
			return new OfertaProyecto(rs.getString("usuario"), rs.getString("dni"), rs.getString("nombre"),
					rs.getInt("numerocreditosaprobados"), rs.getInt("numasignaturaspendiente4t"),
					Semestre.buscar(rs.getString("semestreinicioestancia")),
					rs.getInt("orden"), Itinerario.buscar(rs.getString("itinerario")));
		}
	}
}
