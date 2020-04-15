package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "com.example.demo")
@PropertySource("classpath:db.properties")
public class AppConfig {

	@Autowired
	Environment environment;
	
	@Bean
	public DriverManagerDataSource dataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(environment.getProperty("db.url"));
		dataSource.setUsername(environment.getProperty("db.user"));
		dataSource.setPassword(environment.getProperty("db.password"));
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DriverManagerDataSource dataSource)
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
		return jdbcTemplate;
	}
}
