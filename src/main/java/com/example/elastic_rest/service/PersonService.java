package com.example.elastic_rest.service;


import com.example.elastic_rest.exception.PersonNotFoundException;
import com.example.elastic_rest.model.Person;
import java.util.List;

public interface PersonService {
    Person create(Person person);

    Person update(String id, Person person) throws PersonNotFoundException;

    void delete(String id) throws PersonNotFoundException;

    Person findById(String id) throws PersonNotFoundException;

    Iterable<Person> findAll();

    List<Person> findByName(String lastName);
    List<Person> findByAge(Integer age);
    List<Person> searchByName(String name);
}
