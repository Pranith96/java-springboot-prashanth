package com.product.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@ConfigurationProperties(prefix="spring.datasource")
@Configuration
@RefreshScope
public class DataSourceProperties {
	
	private String driverClassName;
	private String url;
	private String username;
	private String password;
	private String temp;

}
