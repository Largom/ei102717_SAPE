package es.uji.ei1027.clubesportiu.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import es.uji.ei1027.clubesportiu.model.Prova;

import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.List;

public class ProvaJdbcDao implements ProvaDao{
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private static final class ProvaMapper implements RowMapper<Prova> {
		public Prova mapRow(ResultSet rs, int rowNum) throws SQLException { 
			Prova prova = new Prova();
			prova.setNom(rs.getString("nom"));
			prova.setDescripcio(rs.getString("descripcio"));
			prova.setTipus(rs.getString("tipus"));
			return prova;
		}
	}

	@Override
	public List<Prova> getProves() {
		return this.jdbcTemplate.query(
				"select nom, descripcio, tipus from prova",
				new ProvaMapper());
	}

	@Override
	public Prova getProva(String nom) {
		return this.jdbcTemplate.queryForObject(
				"select nom, descripcio, tipus from prova where nom=?",
				new Object[] {nom},
				new ProvaMapper());
	}

	@Override
	public void addProva(Prova prova) {
		this.jdbcTemplate.update(
				"insert into prova(nom, descripcio, tipus) values(?, ?, ?)",
				prova.getNom(), prova.getDescripcio(), prova.getTipus());
	}

	@Override
	public void updateProva(Prova prova) {
		this.jdbcTemplate.update(
				"update prova set descripcio=?, tipus=? where nom = ?",
				prova.getDescripcio(), prova.getTipus(), prova.getNom());
	}

	@Override
	public void deleteProva(Prova prova) {
		this.jdbcTemplate.update(
				"delete from prova where nom = ?",
				prova.getNom());
	}

	@Override
	public List<Prova> getProvaEnPais(String pais) {
		return this.jdbcTemplate.query(
				"SELECT p.nom, p.descripcio, p.tipus from prova p"
				+ " JOIN classificacio c ON p.nom=c.nom_prova"
				+ " JOIN nadador n ON c.nom_nadador=n.nom"
				+ " WHERE n.pais=?",
				new Object[] {pais},
				new ProvaMapper());
	}
}
