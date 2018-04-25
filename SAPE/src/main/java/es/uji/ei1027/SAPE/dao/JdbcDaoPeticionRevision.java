package es.uji.ei1027.SAPE.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import es.uji.ei1027.SAPE.model.PeticionRevision;


public class JdbcDaoPeticionRevision implements DaoPeticionRevision{
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public void setDataSource(final DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private static final class PeticionRevisionMapper implements RowMapper<PeticionRevision> {
		public PeticionRevision mapRow(final ResultSet rs, final int rowNum) throws SQLException {
			return new PeticionRevision(rs.getShort("oferta"), rs.getDate("fecha"), rs.getString("descripcion"));
		}
	}

	@Override
	public List<PeticionRevision> getPeticionRevisiones(final String usu, final String pass) {
		try {
			return this.jdbcTemplate.query(
					"SELECT * FROM verpeticionrevision(?, ?)",
					new Object[] {usu, pass},
					new PeticionRevisionMapper());
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<PeticionRevision>();
		}
	}

	@Override
	public List<PeticionRevision> getPeticionRevisiones(final String usu, final String pass, final short idOferta) {
		try {
			return this.jdbcTemplate.query(
					"SELECT * FROM verpeticionrevision(?, ?, ?)",
					new Object[] {usu, pass, idOferta},
					new PeticionRevisionMapper());
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<PeticionRevision>();
		}
	}

	@Override
	public List<PeticionRevision> getPeticionRevisiones(final String usu, final String pass, final Date fechaOferta) {
		try {
			return this.jdbcTemplate.query(
					"SELECT * FROM verpeticionrevision(?, ?, 0, ?)",
					new Object[] {usu, pass, fechaOferta},
					new PeticionRevisionMapper());
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<PeticionRevision>();
		}
	}

	@Override
	public PeticionRevision getPeticionRevision(final String usu, final String pass, final short idOferta, final Date fechaOferta) {
		try {
			return this.jdbcTemplate.queryForObject(
					"SELECT * FROM verpeticionrevision(?, ?, ?, ?)",
					new Object[] {usu, pass, idOferta, fechaOferta},
					new PeticionRevisionMapper());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean crearEditarPeticionRevision(final String usu, final String pass, final PeticionRevision petRev) {
		try {
			return 1 == this.jdbcTemplate.update("SELECT creareditarpeticionrevision(?, ?, ?, ?, ?)",
					usu, pass, petRev.getOrden(), petRev.getFecha(), petRev.getTextoPeticion());
			// TODO FALTA EN EL PostgreSQL
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean anularPeticionRevision(final String usu, final String pass, final PeticionRevision petRev) {
		try {
			return 1 == this.jdbcTemplate.update("SELECT anularpeticionrevision(?, ?, ?, ?)",
					usu, pass, petRev.getOrden(), petRev.getFecha());
			// TODO FALTA EN EL PostgreSQL
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
