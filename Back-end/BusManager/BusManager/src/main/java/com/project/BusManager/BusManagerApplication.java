package com.project.BusManager;

import com.project.model.AccountInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

@SpringBootApplication
//These annotation will config the packages run like beans operator
//These annotation will config in config file ???
@ComponentScan(basePackages = {"com.project.controller", "com.project.service", "com.project.config"})
@EntityScan("com.project.model")
@EnableJpaRepositories("com.project.repository")
public class BusManagerApplication extends WebSecurityConfigurerAdapter {

    //Initiate class based on IoC principle to use @autowired
    @Bean
    public AccountInfo accountInfo() {
        return new AccountInfo();
    }
    
    public static void main(String[] args) {
        SpringApplication.run(BusManagerApplication.class, args);
    }

}
