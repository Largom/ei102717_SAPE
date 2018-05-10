package es.uji.ei1027.SAPE;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import es.uji.ei1027.SAPE.dao.*;
import nz.net.ultraq.thymeleaf.LayoutDialect;


@Configuration
public class SAPEConfiguration {
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	@Primary
    public JdbcDaoOfertaProyecto jdbcDaoOferta(){
         return new JdbcDaoOfertaProyecto();
    }

	@Bean
	@Primary
    public DaoAsignacion jdbcDaoAsignacion(){
         return new JdbcDaoAsignacion();
    }
	
	@Bean
	@Primary
    public DaoEmpresa jdbcDaoEmpresa(){
         return new JdbcDaoEmpresa();
    }
	
	@Bean
	@Primary
    public DaoEstancia jdbcDaoEstancia(){
         return new JdbcDaoEstancia();
    }
	
	@Bean
	@Primary
    public DaoEstudiante jdbcDaoEstudiante(){
         return new JdbcDaoEstudiante();
    }
	
	@Bean
	@Primary
    public DaoPeticionRevision jdbcDaoPeticionRevision(){
         return new JdbcDaoPeticionRevision();
    }
	
	@Bean
	@Primary
    public DaoPreferenciasAlumno jdbcDaoPreferenciasAlumno(){
         return new JdbcDaoPreferenciasAlumno();
    }
	
	@Bean
	@Primary
    public DaoTutor jdbcDaoTutor(){
         return new JdbcDaoTutor();
    }
	
	@Bean
	@Primary
    public DaoLogin jdbcDaoLogin(){
         return new JdbcDaoLogin();
    }
	
	@Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }
}
