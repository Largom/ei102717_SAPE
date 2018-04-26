package es.uji.ei1027.SAPE.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import es.uji.ei1027.SAPE.model.Empresa;
import es.uji.ei1027.SAPE.model.Estudiante;
import es.uji.ei1027.SAPE.model.MenuItinerario;
import es.uji.ei1027.SAPE.model.MenuSemestre;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;

public class JdbcDaoEmpresa implements DaoEmpresa{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private static final class EmpresaMapper implements RowMapper<Empresa> {
		public Empresa mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Empresa();
					//rs.getString("usuario"), rs.getString("dni"), rs.getString("nombre"),
					//rs.getInt("numerocreditosaprobados"), rs.getInt("numasignaturaspendiente4t"),
					//MenuSemestre.buscar(rs.getString("semestreinicioestancia")),
					//rs.getInt("orden"), MenuItinerario.buscar(rs.getString("itinerario")));
		}
	}
	
	public List<Empresa> getEmpresas(){
		return null;
	}
}