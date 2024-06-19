package com.example.elastic_rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public PersonService personService(PersonRepository repository) {
        return new PersonServiceImpl(repository);
    }

    @Bean
    public PersonController personController(PersonRepository repository) {
        return new PersonController(personService(repository));
    }
}
