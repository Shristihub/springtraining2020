package com.bookapp;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mysql.cj.jdbc.MysqlDataSource;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class DBConfiguration {

//	services-dao-sessionfactory->sessionFactory->datasource->Properties
//	         hibernateTemplate->sessionFactory->hibernate properties-> Properties
//	         hibernateTransactionManager->sessionFactory
//	
	@Autowired
	Environment env;
	@Bean
	public SessionFactory sessionFactory() {
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setPackagesToScan("com.bookapp");
		factory.setDataSource(dataSource());
		factory.setHibernateProperties(hibernateProperties());
		try {
			factory.afterPropertiesSet();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return factory.getObject();
	}
	@Bean
	public HibernateTemplate hibernateTemplate() {
		return new HibernateTemplate(sessionFactory());
	}
	@Bean
	public HibernateTransactionManager hibernateTransaction() {
		return new HibernateTransactionManager(sessionFactory());
	}
	@Bean
	public DataSource dataSource() {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUrl(env.getProperty("datasource.url"));
		dataSource.setUser(env.getProperty("datasource.username"));
		dataSource.setPassword(env.getProperty("datasource.password"));
		return dataSource;
		
	}
	@Bean
	public Properties hibernateProperties() {
		// add hibernate property to this Properties class
		Properties property = new Properties();
		// add key as hibernate key(from cfg file)
		// get value from application.properties
		property.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		property.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.ddl-auto"));
		property.put("hibernate.show_sql", env.getProperty("show-sql"));
		return property;
	}
	
		
		
		
	
}
