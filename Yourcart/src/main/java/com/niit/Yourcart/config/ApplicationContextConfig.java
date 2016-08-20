package com.niit.Yourcart.config;

import java.util.Hashtable;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.Yourcart.model.Category;
import com.niit.Yourcart.model.Product;
import com.niit.Yourcart.model.Supplier;

@Configuration
@ComponentScan("com.niit.Yourcart")
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
		//Hashtable<Object, Object> properties;
		Properties properties=new Properties();
		properties.put("hibernate.show_sql","true");
		properties.put("hibernate.dialect","org.hibernate,dialect.H2Dialect");
		// properties.put("hibernate.hbm2ddl.auto","update");
		return (properties);
		
		
	}
	
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getsessionFactory(DataSource dataSource){
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		//sessionBuilder.addAnnotatedClass(UserDetails.class);
		
		return sessionBuilder. buildSessionFactory();
	}
	@Autowired
	@Bean(name="transactionManager")
		public HibernateTransactionManager getTransactionManager( SessionFactory sessionFactory)
		{
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
		return transactionManager;
		}
}
