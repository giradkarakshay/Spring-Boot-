package com.chinmay.it.mfg;

import java.io.IOException;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class Application extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/*--------For WAR deployment or SpringBootServletInitializer--------*/
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
	/*--------Jasypt Password Encryption Start--------*/
	private static final int MAX_ACTIVE = 80;
	private static final int MAX_WAIT = 1000;
	private static final int MAX_AGE = 3600000;
	private static final String VALIDATION_QUERY = "SELECT 1";

	@Value("${spring.datasource.driver-class-name}")
	protected String databaseDriverClassName;

	@Value("${spring.datasource.url}")
	protected String datasourceUrl;

	@Value("${spring.datasource.username}")
	protected String databaseUsername;

	@Value("${spring.datasource.password}")
	protected String databasePassword;

	@Bean
	public DataSource datasource() throws IOException {
		DataSource dataSource = new DataSource();
		dataSource.setDriverClassName(databaseDriverClassName);
		dataSource.setUrl(datasourceUrl);
		dataSource.setUsername(databaseUsername);
		dataSource.setPassword(databasePassword);
		dataSource.setMaxActive(MAX_ACTIVE);
		dataSource.setMaxWait(MAX_WAIT);
		dataSource.setMaxAge(MAX_AGE);
		dataSource.setValidationQuery(VALIDATION_QUERY);
		dataSource.setTestOnBorrow(true);
		return dataSource;
	}
	/*--------Jasypt Password Encryption End--------*/

}
