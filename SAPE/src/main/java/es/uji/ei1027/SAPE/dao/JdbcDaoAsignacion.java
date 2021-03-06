package es.uji.ei1027.SAPE.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import es.uji.ei1027.SAPE.model.Asignacion;
import es.uji.ei1027.SAPE.model.EstadoAsignacion;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class JdbcDaoAsignacion implements DaoAsignacion{
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(final DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private static final class AsignacionMapper implements RowMapper<Asignacion> {
		public Asignacion mapRow(final ResultSet rs, final int rowNum) throws SQLException {
			Asignacion asignacion = new Asignacion(rs.getShort("id"), rs.getShort("oferta"), rs.getString("estudiante"), rs.getString("tutor"),
					rs.getDate("fechapropuesta"), rs.getDate("fechacambioestado"), rs.getDate("fechatraspasoiglu"),
					rs.getString("comentariopetcambio"), EstadoAsignacion.obtenerEstado(rs.getString("estado")));
			return asignacion;
		}
	}
	
/*
	@Override
	public List<Asignacion> getAsignaciones() {
		return this.jdbcTemplate.query(
				"SELECT * FROM public.\"ASIGNACION\"",
				new AsignacionMapper());
	}

	@Override
	public Asignacion getAsignacion(short id) {
		return this.jdbcTemplate.queryForObject(
				"SELECT * FROM public.\"ASIGNACION\" WHERE id=?",
				new Object[] {id},
				new AsignacionMapper());
	}

	@Override
	public void addAsignacion(Asignacion asig) {
		this.jdbcTemplate.update(
				"INSERT INTO public.\"ASIGNACION\"(oferta, estudiante, tutor, fechapropuesta, fechacambioestado, fechatraspasoiglu, "
				+ "comentariopetcambio, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?::estadoasignacion)",
				asig.getOferta(), asig.getEstudiante(), asig.getTutor(), asig.getFechaPropuesta(), asig.getFechaCambioEstado(),
				asig.getFechaTraspasoIGLU(), asig.getComentarioPerCambio(), asig.getEstado().getDescripcion());
	}

	@Override
	public void updateAsignacion(Asignacion asig) {
		this.jdbcTemplate.update(
				"UPDATE public.\"ASIGNACION\" SET (oferta, estudiante, tutor, fechapropuesta, fechacambioestado, fechatraspasoiglu, "
				+ "comentariopetcambio, estado)=(?, ?, ?, ?, ?, ?, ?, ?::estadoasignacion) WHERE id = ?",
				asig.getOferta(), asig.getEstudiante(), asig.getTutor(), asig.getFechaPropuesta(), asig.getFechaCambioEstado(),
				asig.getFechaTraspasoIGLU(), asig.getComentarioPerCambio(), asig.getEstado().getDescripcion(), asig.getId());
	}

	@Override
	public void deleteAsignacion(short id) {
		this.jdbcTemplate.update(
				"DELETE FROM public.\"ASIGNACION\" WHERE id = ?",
				id);
	}
*/

	@Override
	public Map<Short, Asignacion> getAsignaciones(final String usu, final String pass) {
		try {
			return this.jdbcTemplate.query(
					"SELECT * FROM verasignacion(?, ?)",
					new Object[] {usu, pass},
					new AsignacionMapper()).stream().collect(Collectors.toMap(Asignacion::getId, item -> item));
		} catch (Exception e) {
			e.printStackTrace();
			return new HashMap<Short, Asignacion>();
		}
		
	}

	@Override
	public Asignacion getAsignacion(final String usu, final String pass, final short id) {
		try {
			return this.jdbcTemplate.queryForObject(
					"SELECT * FROM verasignacion(?, ?, ?)",
					new Object[] {usu, pass, id},
					new AsignacionMapper());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Short crearEditarAsignacion(final String usu, final String pass, final Asignacion asig) {
		try {
			return this.jdbcTemplate.queryForObject("SELECT crearasignacion(?, ?, ?, ?, ?, ?, ?, ?, ?::estadoasignacion)",
					new Object[] {usu, pass, asig.getOferta(), asig.getEstudiante(), asig.getTutor(), asig.getFechaPropuesta(),
					asig.getFechaTraspasoIGLU(), asig.getId(), asig.getEstado()}, Short.class);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public boolean anularAsignacion(final String usu, final String pass, final short id) {
		try {
			return 1 == this.jdbcTemplate.update("SELECT anulaasignacion(?, ?, ?)",
					usu, pass, id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean aceptaAsignacion(final String usu, final String pass, final short id) {
		try {
			return 1 == this.jdbcTemplate.update("SELECT aceptaasignacion(?, ?, ?)",
					usu, pass, id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean rechazaAsignacion(final String usu, final String pass, final short id) {
		try {
			return 1 == this.jdbcTemplate.update("SELECT rechazaasignacion(?, ?, ?)",
				usu, pass, id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean petCambioAsignacion(final String usu, final String pass, final short id, final String comentario) {
		try {
			return 1 == this.jdbcTemplate.update("SELECT petcambioasignacion(?, ?, ?, ?)",
				usu, pass, id, comentario);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
