package es.uji.ei1027.SAPE;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import es.uji.ei1027.SAPE.dao.*;


@Configuration
public class SAPEConfiguration {
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	@Primary
    public DaoEstudiante estudianteJdbcDAO(){
         return new JdbcDaoEstudiante();
    }
	
	@Bean
	@Primary
    public DaoEmpresa empresaJdbcDAO(){
         return new JdbcDaoEmpresa();
    }
	
	@Bean
	@Primary
    public DaoOfertaProyecto ofertaJdbcDAO(){
         return new JdbcDaoOfertaProyecto();
    }
	
	@Bean
	@Primary
    public DaoAsignacion asignacionJdbcDAO(){
         return new JdbcDaoAsignacion();
    }
	
	
	@Bean
	@Primary
    public DaoTutor tutorJdbcDAO(){
         return new JdbcDaoTutor();
    }
	
	@Bean
	@Primary
    public DaoLogin loginJdbcDAO(){
         return new JdbcDaoLogin();
    }
	
}
