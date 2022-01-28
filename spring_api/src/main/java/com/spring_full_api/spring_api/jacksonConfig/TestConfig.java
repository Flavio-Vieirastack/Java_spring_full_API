package com.spring_full_api.spring_api.jacksonConfig;

import java.text.ParseException;

import com.spring_full_api.spring_api.Service.DbService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DbService dbService;

    @Bean
    public boolean instanciateDataBase()throws ParseException{
        dbService.instanciateTestDataBase();

        return true;
    }
}