package com.example.graphql.demo.repo;

import com.example.graphql.demo.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author,Long> {
    Author findAuthorById(Long id);
}
