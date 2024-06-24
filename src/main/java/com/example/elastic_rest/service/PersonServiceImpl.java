package com.example.elastic_rest.service;

import com.example.elastic_rest.exception.PersonNotFoundException;
import com.example.elastic_rest.repository.PersonRepository;
import com.example.elastic_rest.model.Person;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.client.elc.NativeQueryBuilder;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;
    private final ElasticsearchTemplate elasticsearchTemplate;

    PersonServiceImpl(PersonRepository repository, ElasticsearchTemplate elasticsearchTemplate) {
        this.repository = repository;
        this.elasticsearchTemplate = elasticsearchTemplate;
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

    public List<Person> findByName(String name) {
        return repository.findPersonByName(name);
    }

    public List<Person> findByAge(Integer age) {
        return repository.findPersonByAge(age);
    }

    public List<Person> searchByName(String name) {
        NativeQuery searchQuery = new NativeQueryBuilder().withQuery(q -> q.match(m -> m.field("name").query(name))).build();
        SearchHits<Person> searchHits = elasticsearchTemplate.search(searchQuery, Person.class, IndexCoordinates.of("sample_index"));
        // Collecting person in a list, TODO: look into SearchHits
        List<Person> result = new ArrayList<>();
        searchHits.stream().forEach(e -> result.add(e.getContent()));
        return result;
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
