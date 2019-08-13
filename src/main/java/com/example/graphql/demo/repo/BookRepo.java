package com.example.graphql.demo.repo;

import com.example.graphql.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepo extends JpaRepository<Book,Long> {
    Book findBookById(Long id);
    List<Book> findBooksByAuthorId(Long authorId);
}
