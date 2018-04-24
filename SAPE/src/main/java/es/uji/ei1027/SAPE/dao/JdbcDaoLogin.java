package es.uji.ei1027.SAPE.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import es.uji.ei1027.SAPE.model.CCG;
import es.uji.ei1027.SAPE.model.CEiTFG;
import es.uji.ei1027.SAPE.model.Empresa;
import es.uji.ei1027.SAPE.model.Estudiante;
import es.uji.ei1027.SAPE.model.Personal;


public class JdbcDaoLogin implements DaoLogin{
	private JdbcTemplate jdbcTemplate;
	private DaoEmpresa empresaDao;
	private DaoEstudiante estudianteDao;
	
	@Autowired
	public void setEmpresaDao(DaoEmpresa empresaDao) {
		this.empresaDao = empresaDao;
	}
	
	@Autowired
	public void setEstudianteDao(DaoEstudiante estudianteDao) {
		this.estudianteDao = estudianteDao;
	}
	
	@Autowired
	public void setDataSource(final DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	@Override
	public Personal login(final String usuario, final String pass) {
		try {
			short tipo=-1;
			tipo = this.jdbcTemplate.queryForObject("SELECT login(?, ?)",
					new Object[] {usuario, pass}, Short.class);
			switch(tipo){
				case 0:
					for(Empresa em : empresaDao.getEmpresas(usuario, pass).values())
						return new Empresa(usuario, pass, em);
				case 1:
					for (Estudiante es : estudianteDao.getEstudiantes(usuario, pass).values())
						return new Estudiante(es, pass);
				case 2:
					return new CCG(usuario, pass);
				case 3:
					return new CEiTFG(usuario, pass);
				default:
					return null;
		}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
