package com.example.graphql.demo.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.graphql.demo.entity.Author;
import com.example.graphql.demo.entity.Book;
import com.example.graphql.demo.repo.AuthorRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AuthorResolver implements GraphQLResolver<Book> {
    private final AuthorRepo authorRepo;

    public Author author(Book book){
        return authorRepo.findAuthorById(book.getAuthorId());
    }
}
