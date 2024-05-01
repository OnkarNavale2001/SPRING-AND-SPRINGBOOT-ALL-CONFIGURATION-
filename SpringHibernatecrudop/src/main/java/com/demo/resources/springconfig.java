package com.demo.resources;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.demo.beans.Student;

@Configuration
@ComponentScan(basePackages = "com.demo")
@EnableTransactionManagement
public class springconfig {
	@Bean
	public DriverManagerDataSource datasource() {
		return new DriverManagerDataSource("jdbc:mysql://localhost:3306/stud", "root", "root");

	}

	@Bean
	public LocalSessionFactoryBean local() {
		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
		bean.setDataSource(datasource());
		Properties ps = new Properties();
		ps.setProperty("hibernate.hbm2ddl.auto", "update");
		ps.setProperty("show_sql", "true");
		ps.setProperty("format_sql", "true");
		bean.setHibernateProperties(ps);
		bean.setAnnotatedClasses(Student.class);

		return bean;

	}

	@Bean
	public HibernateTemplate template() {
		return new HibernateTemplate(local().getObject());

	}

	@Bean
	public HibernateTransactionManager transactionManager() {
		return new HibernateTransactionManager(local().getObject());
	}

}
