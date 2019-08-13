package com.example.graphql.demo.resolver.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;


import com.example.graphql.demo.entity.Book;
import com.example.graphql.demo.repo.AuthorRepo;
import com.example.graphql.demo.repo.BookRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class BookQuery implements GraphQLQueryResolver {
    private final BookRepo bookRepo;
    private final AuthorRepo authorRepo;

    public Book getBookById(Long id){
        return bookRepo.findBookById(id);
    }

    public List<Book> getBooksByAuthorId(Long authorId){
        return bookRepo.findBooksByAuthorId(authorId);
    }

}


