/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.config;

import java.util.Objects;
import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.cfg.AvailableSettings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author DELL
 */
@Configuration
@EnableTransactionManagement
public class HibernateConfig {
    @Autowired
    private Environment env;
    
    @Bean
    public LocalSessionFactoryBean getSessionFactory(){
        LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
        factory.setDataSource(dataSource());
        factory.setHibernateProperties(getProps());
        factory.setPackagesToScan("com.project.model");
        
        return factory;
    }
    
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(
                Objects.requireNonNull(env.getProperty("spring.datasource.driver-class-name")));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        
        return dataSource;
    }
    
    public Properties getProps(){
        Properties props = new Properties();
        props.setProperty(AvailableSettings.DIALECT, env.getProperty("spring.jpa.database-platform"));
        props.setProperty(AvailableSettings.SHOW_SQL, env.getProperty("spring.jpa.properties.hibernate.show.sql"));
        
        return props;
    }
    
    @Bean
    public HibernateTransactionManager transactionManager(){
        HibernateTransactionManager trans = new HibernateTransactionManager();
        trans.setSessionFactory(this.getSessionFactory().getObject());
        
        return trans;
    }
}
