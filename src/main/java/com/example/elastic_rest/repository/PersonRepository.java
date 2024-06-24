package com.example.elastic_rest.repository;

import com.example.elastic_rest.model.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import javax.annotation.Nullable;
import java.util.List;


public interface PersonRepository extends ElasticsearchRepository<Person, String> {

    // Method name-based queries
    @Nullable
    List<Person> findPersonByName(String name);
    @Nullable
    List<Person> findPersonByAge(int age);
    @Nullable
    List<Person> findPersonByNameAndAge(String name, int age);

    // Native search queries but interface queries cannot have a body
//    @Nullable
//    List<Person> searchPersonByNameQuery(String name) {
//        Query searchQuery = new NativeQueryBuilder().withQuery(matchQuery("name", name)).build();
//    }
}
