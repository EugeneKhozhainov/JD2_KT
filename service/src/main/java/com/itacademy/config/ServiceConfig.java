package com.itacademy.config;

import com.itacademy.database.config.DatabaseConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DatabaseConfig.class)
@ComponentScan(basePackages = "com.itacademy.service.service")
public class ServiceConfig {
}
