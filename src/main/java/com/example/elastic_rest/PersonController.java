package com.example.elastic_rest;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService service;

    PersonController(PersonService service) {
        this.service= service;
    }

    @PostMapping("/create")
    public Person create(@RequestBody Person person) {
        return service.create(person);
    }

    @GetMapping("/get/{id}")
    public Person findById(@PathVariable String id) throws PersonNotFoundException {
        return service.findById(id);
    }

    @GetMapping( "/get/findAll")
    public Iterable<Person> findAll() {
        return service.findAll();
    }

    @PutMapping("/put/{id}")
    public Person update(@PathVariable String id, @RequestBody Person person) throws PersonNotFoundException {
        return service.update(id, person);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) throws PersonNotFoundException {
        service.delete(id);
    }
}
