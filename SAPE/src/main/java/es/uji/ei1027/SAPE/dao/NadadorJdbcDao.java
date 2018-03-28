package es.uji.ei1027.clubesportiu.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import es.uji.ei1027.clubesportiu.model.Nadador;

import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.List;

public class NadadorJdbcDao implements NadadorDao{
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private static final class NadadorMapper implements RowMapper<Nadador> {
		public Nadador mapRow(ResultSet rs, int rowNum) throws SQLException { 
			Nadador nadador = new Nadador();
			nadador.setNom(rs.getString("nom"));
			nadador.setNumFederat(rs.getString("num_federat"));
			nadador.setPais(rs.getString("pais"));
			nadador.setSexe(rs.getString("sexe"));
			nadador.setEdat(rs.getInt("edat"));
			return nadador;
		}
	}

	@Override
	public List<Nadador> getNadadors() {
		return this.jdbcTemplate.query(
				"select nom, num_federat, pais, sexe, edat from nadador",
				new NadadorMapper());
	}

	@Override
	public Nadador getNadador(String nom) {
		return this.jdbcTemplate.queryForObject(
				"select nom, num_federat, pais, sexe, edat from nadador where nom=?",
				new Object[] {nom},
				new NadadorMapper());
	}

	@Override
	public void addNadador(Nadador nadador) {
		this.jdbcTemplate.update(
				"insert into nadador(nom, num_federat, pais, sexe, edat) values(?, ?, ?, ?, ?)",
				nadador.getNom(), nadador.getNumFederat(), nadador.getPais(), nadador.getSexe(), nadador.getEdat());
	}

	@Override
	public void updateNadador(Nadador nadador) {
		this.jdbcTemplate.update(
				"update Nadador set num_federat=?, pais=?, sexe=?, edat=? where nom = ?",
				nadador.getNumFederat(), nadador.getPais(), nadador.getSexe(), nadador.getEdat(), nadador.getNom());
	}

	@Override
	public void deleteNadador(String nadador) {
		this.jdbcTemplate.update(
				"delete from Nadador where nom = ?",
				nadador);
	}

	@Override
	public List<Nadador> getNadadorEnProvaPais(String nomProva, String pais) {
		return this.jdbcTemplate.query(
				"SELECT n.nom, n.num_federat, n.pais, n.sexe, n.edat"
				+ " FROM nadador n JOIN classificacio c ON n.nom=c.nom_nadador"
				+ " WHERE n.pais=? AND c.nom_prova=?",
				new Object[] {pais, nomProva},
				new NadadorMapper());
	}
}
