package com.niit.Yourcart.config;

import java.util.Hashtable;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
ComponentScan("com.niit.Yourcart")
@EnableTransactionManagement

public class ApplicationContextConfig {

	@Bean(name = "datasource")
	public DataSource getDataSource() {
			DriverManagerDataSource datasource=new DriverManagerDataSource();
			datasource.setDriverClassName("org.h2.Driver");
			datasource.setUrl("jdbc:h2:tcp://localhost/~/niitdb");
			
			datasource.setUsername("sa");
			datasource.setPassword("sa");
			return datasource;
	}
	
	private Properties getHibernateProperties(){
		Hashtable<Object, Object> properties;
		properties.properties=new Properties();
		properties.put("hibernate.show_sql","true");
		properties.put("hibernate.dialect","org.hibernate,dialect.H2Dialect");
		properties.put("hibernate.hbm2ddl.auto","update");
		return (properties);
		
		
	}
	
}
