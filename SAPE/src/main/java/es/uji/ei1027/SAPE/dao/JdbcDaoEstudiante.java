package es.uji.ei1027.SAPE.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import es.uji.ei1027.SAPE.model.Estudiante;
import es.uji.ei1027.SAPE.model.Itinerario;
import es.uji.ei1027.SAPE.model.Semestre;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JdbcDaoEstudiante implements DaoEstudiante{
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(final DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private static final class EstudianteMapper implements RowMapper<Estudiante> {
		public Estudiante mapRow(final ResultSet rs,final  int rowNum) throws SQLException {
			return new Estudiante(rs.getString("usuario"), rs.getString("dni"), rs.getString("nombre"),
					rs.getInt("numerocreditosaprobados"), rs.getInt("numasignaturaspendiente4t"),
					Semestre.buscar(rs.getString("semestreinicioestancia")),
					rs.getInt("orden"), Itinerario.buscar(rs.getString("itinerario")));
		}
	}
/*
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
				+ "semestreinicioestancia) VALUES (?, ?, ?, ?, ?, ?, ?::itinerario, ?::semestre)",
				est.getUsuario(), est.getNombre(), est.getDni(), est.getOrden(),
				est.getNumeroCreditosAprobados(), est.getNumeroAsignaturasPendientes4t(),
				est.getItinerario().getDescripcion(), est.getSemestreInicioEstancia().getDescripcion());
	}

	@Override
	public void updateEstudiante(Estudiante est) {
		this.jdbcTemplate.update(
				"UPDATE public.\"ESTUDIANTE\" SET (nombre, dni, orden, "
				+ "numerocreditosaprobados, numasignaturaspendiente4t, itinerario, "
				+ "semestreinicioestancia)=(?, ?, ?, ?, ?, ?::itinerario, ?::semestre) WHERE usuario = ?",
				est.getNombre(), est.getDni(), est.getOrden(), est.getNumeroCreditosAprobados(),
				est.getNumeroAsignaturasPendientes4t(), est.getItinerario().getDescripcion(),
				est.getSemestreInicioEstancia().getDescripcion(), est.getUsuario());
	}

	@Override
	public void deleteEstudiante(String usuario) {
		this.jdbcTemplate.update(
				"DELETE FROM public.\"ESTUDIANTE\" WHERE usuario = ?", usuario);
	}
*/
	
	@Override
	public Map<String, Estudiante> getEstudiantes(final String usu, final String pass) {
		try {
			return this.jdbcTemplate.query(
					"SELECT * FROM verestudiante(?, ?)",
					new Object[] {usu, pass},
					new EstudianteMapper()).stream().collect(Collectors.toMap(Estudiante::getUsuario, item -> item));
		} catch (Exception e) {
			e.printStackTrace();
			return new HashMap<String, Estudiante>();
		}
	}

	@Override
	public Estudiante getEstudiante(final String usu, final String pass, final String usuario) {
		try {
			return this.jdbcTemplate.queryForObject(
					"SELECT * FROM verasignacion(?, ?, ?)",
					new Object[] {usu, pass, usuario},
					new EstudianteMapper());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean elegirSemestreItinerario(final String usu, final String pass, final Semestre semestre, final Itinerario itinerario) {
		try {
			return 1 == this.jdbcTemplate.update("SELECT elegirsemestreitinerario(?, ?, ?::semestre, ?::itinerario)",
					usu, pass, semestre, itinerario);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	

}
