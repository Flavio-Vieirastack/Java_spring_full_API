package com.spring_full_api.spring_api.jacksonConfig;

import java.text.ParseException;

import com.spring_full_api.spring_api.Service.DbService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {

    @Autowired
    private DbService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;

    @Bean
    public boolean instanciateDataBase()throws ParseException{
        if (!"create".equals(strategy)) {
            return false;
        }
        dbService.instanciateTestDataBase();

        return true;
    }
}