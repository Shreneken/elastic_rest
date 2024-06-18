package com.example.elastic_rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private PersonRepository repository;

    @PostMapping("/create")
    public Person create(@RequestBody Person person) {
        return repository.save(person);
    }

    @GetMapping("/get/{id}")
    public Optional<Person> findById(@PathVariable String id) {
        return repository.findById(id);
    }

    @GetMapping( "/get/findAll")
    public Iterable<Person> findAll() {
        return repository.findAll();
    }

    @PutMapping("/put/{id}")
    public Person update(@PathVariable String id, @RequestBody Person person) {
        person.setId(id);
        return repository.save(person);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        repository.deleteById(id);
    }
}
