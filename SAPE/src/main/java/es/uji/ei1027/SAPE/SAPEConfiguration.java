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
	
	
}
