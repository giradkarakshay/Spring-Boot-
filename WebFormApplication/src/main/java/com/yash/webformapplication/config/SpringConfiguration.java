package com.yash.webformapplication.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@ComponentScan({ "com.yash.webformapplication" })
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
@Configuration
public class SpringConfiguration implements WebMvcConfigurer {

	@Autowired
	private Environment env;

	@Value("${spring.datasource.driver-class-name}")
	String driverClassName;
	@Value("${spring.datasource.url}")
	String url;
	@Value("${spring.datasource.username}")
	String username;
	@Value("${spring.datasource.password}")
	String password;
	@Value("${spring.jpa.show-sql}")
	String showSql;
	@Value("${spring.jpa.hibernate.ddl-auto}")
	String ddlAuto;
	@Value("${spring.jpa.properties.hibernate.dialect}")
	String dailect;
	@Value("${spring.mvc.view.prefix}")
	String prefix;
	@Value("${spring.mvc.view.suffix}")
	String suffix;

	@Bean
	@Autowired
	public DataSource myDatasource() {
		DriverManagerDataSource driverManager = new DriverManagerDataSource();
		driverManager.setDriverClassName(driverClassName);
		driverManager.setUrl(url);
		driverManager.setUsername(username);
		driverManager.setPassword(password);
		return driverManager;
	}

	@Bean
	@Autowired
	@Qualifier("myDatasource")
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(myDatasource());
		sessionFactoryBean.setPackagesToScan(new String[] { "com.yash.webformapplication.model" });
		sessionFactoryBean.setHibernateProperties(hibernateProperties());
		return sessionFactoryBean;
	}

	public Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", dailect);
		properties.put("hibernate.dialect", env.getRequiredProperty("spring.jpa.properties.hibernate.dialect"));
		properties.put("hibernate.show_sql", showSql);
		properties.put("hibernate.ddlAuto", ddlAuto);
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}

	@Bean
	@Qualifier("myDatasource")
	public DataSourceInitializer dataSourceInitializer(final DataSource dataSource) {
		final DataSourceInitializer initializer = new DataSourceInitializer();
		initializer.setDataSource(dataSource);
		return initializer;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("static pages configured...");
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		System.out.println("view configured...");
		registry.addViewController("/").setViewName("welcome");
	}

	@Bean
	@Autowired
	public HibernateTemplate getHibernateTemplate(SessionFactory sessionFactory) {
		HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
		return hibernateTemplate;
	}
}
