package com.example.graphql.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private Integer pageNum;
    private Long authorId;

        public Book(String name, Integer pageNum, Long authorId) {
        this.name = name;
        this.pageNum = pageNum;
            this.authorId = authorId;
    }
}

