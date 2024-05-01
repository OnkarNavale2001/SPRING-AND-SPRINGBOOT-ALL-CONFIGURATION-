package com.demo.configuration;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "com.demo")
@EnableJpaRepositories("com.demo.repositry")
public class Springconfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/job_portal");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

  

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
   
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory()
	{
	LocalContainerEntityManagerFactoryBean lcEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();		
		lcEntityManagerFactoryBean.setDataSource(dataSource());
		
		lcEntityManagerFactoryBean.setPackagesToScan("com.demo.beans");
	
	lcEntityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
	lcEntityManagerFactoryBean.setJpaProperties(hibernateProperties());
	
		return lcEntityManagerFactoryBean;
	}	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory)
	{
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(entityManagerFactory);
		return jpaTransactionManager;
	}
    private Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        hibernateProperties.setProperty("hibernate.format_sql", "true");
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
        return hibernateProperties;
    }
}
