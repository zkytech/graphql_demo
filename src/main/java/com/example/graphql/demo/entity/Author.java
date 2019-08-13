package com.example.graphql.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private int age;

    public Author(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
