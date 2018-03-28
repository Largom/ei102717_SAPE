package es.uji.ei1027.clubesportiu.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import es.uji.ei1027.clubesportiu.model.Classificacio;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;

public class ClassificacioJdbcDao implements  ClassificacioDao{
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private static final class ClassificacioMapper implements RowMapper<Classificacio> {
		public Classificacio mapRow(ResultSet rs, int rowNum) throws SQLException { 
			Classificacio classificacio = new Classificacio();
			classificacio.setNomNadador(rs.getString("nom_nadador"));
			classificacio.setNomProva(rs.getString("nom_prova"));
			classificacio.setPosicio(rs.getInt("posicio"));
			classificacio.setTemps(rs.getTime("temps"));
			return classificacio;
		}
	}

	@Override
	public List<Classificacio> getClassificacions() {
		return this.jdbcTemplate.query(
				"select nom_nadador, nom_prova, posicio, temps from classificacio",
				new ClassificacioMapper());
	}

	@Override
	public Classificacio getClassificacio(String nom, String prova) {
		return this.jdbcTemplate.queryForObject(
				"select nom_nadador, nom_prova, posicio, temps from classificacio where nom_nadador=? AND nom_prova = ?",
				new Object[] {nom, prova},
				new ClassificacioMapper());
	}

	@Override
	public void addClassificacio(Classificacio classif) {
		this.jdbcTemplate.update(
				"insert into classificacio(nom_nadador, nom_prova, posicio, temps) values(?, ?, ?, ?)",
				classif.getNomNadador(), classif.getNomProva(), classif.getPosicio(), classif.getTemps());
	}

	@Override
	public void updateClassificacio(Classificacio classif) {
		this.jdbcTemplate.update(
				"update classificacio set posicio=?, temps=? where nom_nadador=? AND nom_prova=?",
				classif.getPosicio(), classif.getTemps(), classif.getNomNadador(), classif.getNomProva());
	}

	@Override
	public void deleteClassificacio(Classificacio classif) {
		this.jdbcTemplate.update(
				"delete from classificacio where nom_nadador=? AND nom_prova=?",
				classif.getNomNadador(), classif.getNomProva());
	}
	
	@Override
	public List<Classificacio> getClassificacioProva(String nomProva) {
		return this.jdbcTemplate.query(
				"SELECT * FROM classificacio WHERE nom_prova=?;",  
				new Object[] {nomProva}, new ClassificacioMapper());
    }
}
