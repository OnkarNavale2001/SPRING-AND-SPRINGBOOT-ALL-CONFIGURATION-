package in.sp.resources;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("in.sp.repository")
@ComponentScan(basePackages = {"in.sp"})
public class SpringConfigFile 
{
	@Bean
	public DataSource myDataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/spring_data_jpa_db");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		return dataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory()
	{
		LocalContainerEntityManagerFactoryBean lcEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		
		lcEntityManagerFactoryBean.setDataSource(myDataSource());
		
		lcEntityManagerFactoryBean.setPackagesToScan("in.sp.entity");
		
		lcEntityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		lcEntityManagerFactoryBean.setJpaProperties(hibernateProperties());
		
		return lcEntityManagerFactoryBean;
	}
	
	public Properties hibernateProperties()
	{
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.show_sql", "true");
		return properties;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory)
	{
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(entityManagerFactory);
		return jpaTransactionManager;
	}
}
