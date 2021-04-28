package com.project.BusManager;

import com.project.model.Account;
import com.project.model.AccountInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
//These annotation will config the packages run like beans operator
//These annotation will config in config file ???
@ComponentScan({"com.project"})
//@EntityScan("com.project.model")
//@EnableJpaRepositories("com.project.repository")
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, 
    DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class BusManagerApplication extends WebSecurityConfigurerAdapter {

    //Initiate class based on IoC principle to use @autowired
//    @Bean
//    public Account accountInfo() {
//        return new Account();
//    }
    
    public static void main(String[] args) {
        SpringApplication.run(BusManagerApplication.class, args);
    }
}
