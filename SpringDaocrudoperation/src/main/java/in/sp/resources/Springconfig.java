package in.sp.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "in.sp")
public class Springconfig {
	@Bean
	public DriverManagerDataSource createobj() {
		return new DriverManagerDataSource("jdbc:mysql://localhost:/Student", "root", "root");

	}

	@Bean
	public JdbcTemplate jdbctemp() {
		return new JdbcTemplate(createobj());

	}
}
