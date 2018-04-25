package es.uji.ei1027.SAPE.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import es.uji.ei1027.SAPE.model.EstadoOferta;
import es.uji.ei1027.SAPE.model.Estudiante;
import es.uji.ei1027.SAPE.model.Itinerario;
import es.uji.ei1027.SAPE.model.OfertaProyecto;


public class JdbcDaoOfertaProyecto implements DaoOfertaProyecto{
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public void setDataSource(final DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private static final class OfertaProyectoMapper implements RowMapper<OfertaProyecto> {
		public OfertaProyecto mapRow(final ResultSet rs, final int rowNum) throws SQLException {
			HashSet itinerarios = new HashSet();
			for(String itin : (String[])rs.getArray("itinerarios").getArray()){
				itinerarios.add(Itinerario.buscar(itin));
			}
			return new OfertaProyecto(rs.getShort("estancia"), rs.getString("objetivo"), rs.getString("tarea"),
					rs.getDate("fechaalta"), rs.getDate("fechaultimocambio"), EstadoOferta.obtenerEstado(rs.getString("estado")),
					itinerarios);
		}
	}

	@Override
	public Map<Short, OfertaProyecto> getOfertasProyectos(final String usu, final String pass) {
		try {
			return this.jdbcTemplate.query(
					"SELECT * FROM veroferta(?, ?)",
					new Object[] {usu, pass},
					new OfertaProyectoMapper()).stream().collect(Collectors.toMap(OfertaProyecto::getId, item -> item));
		} catch (Exception e) {
			e.printStackTrace();
			return new HashMap<Short, OfertaProyecto>();
		}
	}

	@Override
	public OfertaProyecto getOfertaProyecto(final String usu, final String pass, final short id) {
		try {
			return this.jdbcTemplate.queryForObject(
					"SELECT * FROM veroferta(?, ?, ?)",
					new Object[] {usu, pass, id},
					new OfertaProyectoMapper());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean crearEditarOfertaProyecto(final String usu, final String pass, final OfertaProyecto ofePro) {
		try {
			return 1 == this.jdbcTemplate.update("SELECT creareditaroferta(?, ?, ?, ?, ?, ?, ?::estadooferta, ?::itinerario[])",
					usu, pass, ofePro.getId(), ofePro.getTarea(), ofePro.getObjetivo(), ofePro.getFechaAlta(),
					ofePro.getEstadoOferta().getDescripcion(), ofePro.getItinerarios().toArray());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean anularOfertaProyecto(final String usu, final String pass, final short id) {
		try {
			return 1 == this.jdbcTemplate.update("SELECT anulaoferta(?, ?, ?)", usu, pass, id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean editarEstadoOfertaProyecto(final String usu, final String pass, final short id, final EstadoOferta estado) {
		try {
			return 1 == this.jdbcTemplate.update("SELECT editarestadooferta(?, ?, ?, ?::estadooferta)", usu, pass, id, estado.getDescripcion());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
