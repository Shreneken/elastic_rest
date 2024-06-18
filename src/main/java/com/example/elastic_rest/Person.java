package com.example.elastic_rest;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.annotation.Id;

@Document(indexName = "sample_index")
public class Person{

    @Id @Getter @Setter private String id;
    @Getter @Setter String name;
    @Getter @Setter int age;
}
