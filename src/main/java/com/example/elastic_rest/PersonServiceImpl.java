package com.example.elastic_rest;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;

    PersonServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }

    public Person create(@RequestBody Person person) {
        return repository.save(person);
    }

    public Person findById(@PathVariable String id) throws PersonNotFoundException {
        return repository.findById(id).orElseThrow(() -> new PersonNotFoundException("Person not Found"));
    }

    public Iterable<Person> findAll() {
        return repository.findAll();
    }

    public Person update(@PathVariable String id, @RequestBody Person person) throws PersonNotFoundException {
        if (!repository.existsById(id)) {
            throw new PersonNotFoundException("Person not Found");
        }
        person.setId(id);
        return repository.save(person);
    }

    public void delete(@PathVariable String id) throws PersonNotFoundException {
        if (!repository.existsById(id)) {
            throw new PersonNotFoundException("Person not Found");
        }
        repository.deleteById(id);
    }
}
