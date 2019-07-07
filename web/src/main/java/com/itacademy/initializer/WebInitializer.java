package com.itacademy.initializer;

import com.itacademy.config.SecurityConfig;
import com.itacademy.config.ServiceConfig;
import com.itacademy.config.WebConfig;
import com.itacademy.database.config.DatabaseConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    private static final String SERVLET_MAPPING = "/";

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {DatabaseConfig.class, ServiceConfig.class, SecurityConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {SERVLET_MAPPING};
    }
}
