package es.uji.ei1027.SAPE.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import es.uji.ei1027.SAPE.model.Asignacion;
import es.uji.ei1027.SAPE.model.MenuEstadoAsignacion;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;

public class JdbcDaoAsignacion implements DaoAsignacion{
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private static final class AsignacionMapper implements RowMapper<Asignacion> {
		public Asignacion mapRow(ResultSet rs, int rowNum) throws SQLException {
			Asignacion asignacion = new Asignacion(rs.getShort("id"), rs.getShort("oferta"), rs.getString("estudiante"), rs.getString("tutor"),
					rs.getDate("fechapropuesta"), rs.getDate("fechacambioestado"), rs.getDate("fechatraspasoiglu"),
					rs.getString("comentariopetcambio"), MenuEstadoAsignacion.obtenerEstado(rs.getString("estado")));
			return asignacion;
		}
	}
	
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
				+ "comentariopetcambio, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
				asig.getOferta(), asig.getEstudiante(), asig.getTutor(), asig.getFechaPropuesta(), asig.getFechaCambioEstado(),
				asig.getFechaTraspasoIGLU(), asig.getComentarioPerCambio(), asig.getEstado().getDescripcion());
	}

	@Override
	public void updateAsignacion(Asignacion asig) {
		this.jdbcTemplate.update(
				"UPDATE public.\"ASIGNACION\" SET (oferta, estudiante, tutor, fechapropuesta, fechacambioestado, fechatraspasoiglu, "
				+ "comentariopetcambio, estado)=(?, ?, ?, ?, ?, ?, ?, ?) WHERE id = ?",
				asig.getOferta(), asig.getEstudiante(), asig.getTutor(), asig.getFechaPropuesta(), asig.getFechaCambioEstado(),
				asig.getFechaTraspasoIGLU(), asig.getComentarioPerCambio(), asig.getEstado().getDescripcion(), asig.getId());
	}

	@Override
	public void deleteAsignacion(short id) {
		this.jdbcTemplate.update(
				"DELETE FROM public.\"ASIGNACION\" WHERE id = ?",
				id);
	}

	@Override
	public List<Asignacion> getAsignaciones(String usu, String pass) {
		return this.jdbcTemplate.query(
				"SELECT * FROM verasignacion(?, ?)",
				new AsignacionMapper());
	}

	@Override
	public Asignacion getAsignacion(String usu, String pass, short id) {
		return this.jdbcTemplate.queryForObject(
				"SELECT * FROM verasignacion(?, ?, ?)",
				new Object[] {usu, pass, id},
				new AsignacionMapper());
	}

	@Override
	public boolean crearEditarAsignacion(String usu, String pass, Asignacion asig) {
		return 1 == this.jdbcTemplate.update("SELECT crearasignacion(?, ?, ?, ?, ?, ?, ?, ?, ?)",
				usu, pass, asig.getOferta(), asig.getEstudiante(), asig.getTutor(), asig.getFechaPropuesta(),
				asig.getFechaTraspasoIGLU(), asig.getId(), asig.getEstado());
	}

	@Override
	public boolean anularAsignacion(String usu, String pass, short id) {
		return 1 == this.jdbcTemplate.update("SELECT anulaasignacion(?, ?, ?)",
				usu, pass, id);
	}

	@Override
	public boolean aceptaAsignacion(String usu, String pass, short id) {
		return 1 == this.jdbcTemplate.update("SELECT aceptaasignacion(?, ?, ?)",
				usu, pass, id);
	}

	@Override
	public boolean rechazaAsignacion(String usu, String pass, short id) {
		return 1 == this.jdbcTemplate.update("SELECT aceptaasignacion(?, ?, ?)",
				usu, pass, id);
	}

	@Override
	public boolean petCambioAsignacion(String usu, String pass, short id, String comentario) {
		return 1 == this.jdbcTemplate.update("SELECT aceptaasignacion(?, ?, ?, ?)",
				usu, pass, id, comentario);
	}

}
