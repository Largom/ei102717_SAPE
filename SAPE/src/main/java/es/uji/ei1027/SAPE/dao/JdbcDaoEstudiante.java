package es.uji.ei1027.SAPE.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import es.uji.ei1027.SAPE.model.Estudiante;
import es.uji.ei1027.SAPE.model.MenuItinerario;
import es.uji.ei1027.SAPE.model.MenuSemestre;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;

public class JdbcDaoEstudiante implements DaoEstudiante{
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private static final class EstudianteMapper implements RowMapper<Estudiante> {
		public Estudiante mapRow(ResultSet rs, int rowNum) throws SQLException {
			Estudiante estudiante = new Estudiante(rs.getString(""), null, null, rowNum, rowNum, null, rowNum, null);
			return estudiante;
		}
	}

	@Override
	public List<Estudiante> getEstudiantes() {
		return this.jdbcTemplate.query(
				"SELECT * FROM public.\"ESTUDIANTE\"",
				new EstudianteMapper());
	}

	@Override
	public Estudiante getEstudiante(String usuario) {
		return this.jdbcTemplate.queryForObject(
				"SELECT * FROM public.\"ESTUDIANTE\" WHERE usuario=?",
				new Object[] {usuario},
				new EstudianteMapper());
	}

	@Override
	public void addEstudiante(Estudiante est) {
		this.jdbcTemplate.update(
				"INSERT INTO public.\"ESTUDIANTE\"(usuario, nombre, dni, orden, "
				+ "numerocreditosaprobados, numasignaturaspendiente4t, itinerario, "
				+ "semestreinicioestancia) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
				est.getUsuario(), est.getNombre(), est.getDni(), est.getOrden(),
				est.getNumeroCreditosAprobados(), est.getNumeroAsignaturasPendientes4t(),
				est.getItinerario().getDescripcion(), est.getSemestreInicioEstancia().getDescripcion());
	}

	@Override
	public void updateEstudiante(Estudiante est) {
		this.jdbcTemplate.update(
				"UPDATE public.\"ESTUDIANTE\" SET (nombre, dni, orden, "
				+ "numerocreditosaprobados, numasignaturaspendiente4t, itinerario, "
				+ "semestreinicioestancia)=(?, ?, ?, ?, ?, ?, ?, ?) WHERE usuario = ?",
				est.getNombre(), est.getDni(), est.getOrden(), est.getNumeroCreditosAprobados(),
				est.getNumeroAsignaturasPendientes4t(), est.getItinerario().getDescripcion(),
				est.getSemestreInicioEstancia().getDescripcion(), est.getUsuario());
	}

	@Override
	public void deleteEstudiante(String usuario) {
		this.jdbcTemplate.update(
				"DELETE FROM public.\"ESTUDIANTE\" WHERE usuario = ?", usuario);
	}

	@Override
	public List<Estudiante> getEstudiantes(String usu, String pass) {
		return this.jdbcTemplate.query(
				"SELECT * FROM verestudiante(?, ?)",
				new EstudianteMapper());
	}

	@Override
	public Estudiante getEstudiante(String usu, String pass, String usuario) {
		return this.jdbcTemplate.queryForObject(
				"SELECT * FROM verasignacion(?, ?, ?)",
				new Object[] {usu, pass, usuario},
				new EstudianteMapper());
	}

	@Override
	public boolean elegirSemestre(String usu, String pass, MenuSemestre semestre) {
		return 1 == this.jdbcTemplate.update("SELECT elegirsemestre(?, ?, ?)",
				usu, pass, semestre);
	}

	@Override
	public boolean elegirItinerario(String usu, String pass, MenuItinerario itinerario) {
		return 1 == this.jdbcTemplate.update("SELECT elegiritinerario(?, ?, ?)",
				usu, pass, itinerario);
	}
	

}
