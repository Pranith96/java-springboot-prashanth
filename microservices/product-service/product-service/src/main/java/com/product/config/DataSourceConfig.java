package com.product.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
public class DataSourceConfig {

	@Autowired
	DataSourceProperties dataSourceProperties;

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
		dataSource.setUrl(dataSourceProperties.getUrl());
		dataSource.setUsername(dataSourceProperties.getUsername());
		dataSource.setPassword(dataSourceProperties.getPassword());
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(JpaVendorAdapter jpaVendorAdapter) {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(getDataSource());
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
		factoryBean.setPackagesToScan("com.product.entity"); // Packages containing JPA entities
		factoryBean.setJpaProperties(jpaProperties());
		factoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		return factoryBean;
	}

	private Properties jpaProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.ddl-auto", "update");
		return properties;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

//	@Bean
//	public DataSource dataSource() {
//		HikariConfig config = new HikariConfig();
//		config.setJdbcUrl(dataSourceProperties.getUrl());
//		config.setUsername(dataSourceProperties.getUsername());
//		config.setPassword(dataSourceProperties.getPassword());
//		config.setDriverClassName(dataSourceProperties.getDriverClassName());
//
//		// Optional configuration for HikariCP
//		config.setMaximumPoolSize(10); // Adjust pool size as needed
//		config.setMinimumIdle(5); // Adjust idle connections as needed
//
//		return new HikariDataSource(config);
//	}
}