package in.sp.resources;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import in.sp.dao.StudentDaoImpl;

@Configuration
@EnableTransactionManagement
public class SpringConfigFile
{
	@Bean
	public DriverManagerDataSource dmDataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/spring_jpa_db");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		return dataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean lcEntityManagerFactoryBean()
	{
		LocalContainerEntityManagerFactoryBean lcEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		
		lcEntityManagerFactoryBean.setDataSource(dmDataSource());
		
		lcEntityManagerFactoryBean.setPackagesToScan("in.sp.entity");
		
		lcEntityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		
//		Properties properties = new Properties();
//		properties.setProperty("hibernate.hbm2ddl.auto", "update");
//		properties.setProperty("hibernate.show_sql", "true");
//		lcEntityManagerFactoryBean.setJpaProperties(properties);
		
		lcEntityManagerFactoryBean.setJpaProperties(hibernateProperties());
		
		return lcEntityManagerFactoryBean;
	}
	
	public Properties hibernateProperties()
	{
		Properties hibernateProperties = new Properties();
		
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		
		return hibernateProperties;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf)
	{
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		
		return transactionManager;
	}
	
	@Bean
	public StudentDaoImpl stdDaoImpl()
	{
		return new StudentDaoImpl();
	}
}
