package com.example.elastic_rest;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.annotation.Id;

@Setter
@Getter
@Document(indexName = "sample_index")
public class Person{

    @Id
    private String id;
    String name;
    int age;
}
