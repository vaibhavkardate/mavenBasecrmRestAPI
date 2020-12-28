package com.lovecode.spring.restful.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@EnableWebMvc
@EnableTransactionManagement
@Configuration
@ComponentScan("com.lovecode.spring.restful")
@PropertySource({"classpath:persistance_oracle.properties"})
public class AppDemoConfig {

	@Autowired
	private Environment env;
	
	@Bean
	public DataSource myDataSource()
	{
		ComboPooledDataSource dataSource=new ComboPooledDataSource();
		
		try
		{
			dataSource.setDriverClass(env.getProperty("jdbc.driver"));
			dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
			dataSource.setUser(env.getProperty("jdbc.user"));
			dataSource.setPassword(env.getProperty("jdbc.password"));
			
			
			dataSource.setInitialPoolSize(getint("connection.pool.initialPoolSize"));
			dataSource.setMinPoolSize(getint("connection.pool.minPoolSize"));	
			
			dataSource.setMaxPoolSize(getint("connection.pool.maxPoolSize"));
			dataSource.setMaxIdleTime(getint("connection.pool.maxIdleTime"));
			
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException();
		}
		return dataSource;
	}
	
	public int getint(String name)
	{
		String str=env.getProperty(name);
		return Integer.parseInt(str);
	}
	
	
	private Properties getHibernateProperties() {

		// set hibernate properties
		Properties props = new Properties();

		props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		
		return props;				
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		
		// create session factorys
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		// set the properties
		sessionFactory.setDataSource(myDataSource());
		sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
		sessionFactory.setHibernateProperties(getHibernateProperties());
		
		return sessionFactory;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		
		// setup transaction manager based on session factory
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);

		return txManager;
	}	




}
