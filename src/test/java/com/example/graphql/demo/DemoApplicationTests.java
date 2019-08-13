package com.example.graphql.demo;

import com.example.graphql.demo.entity.Author;
import com.example.graphql.demo.entity.Book;
import com.example.graphql.demo.repo.AuthorRepo;
import com.example.graphql.demo.repo.BookRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests {
    @Autowired
    AuthorRepo authorRepo;
    @Autowired
    BookRepo bookRepo;

    /**
     * 添加测试数据
     */
    @Test
    public void contextLoads() {
        Author author = new Author("zkyTech",23);
        authorRepo.save(author);
        Book book = new Book("GraphQL权限验证",666,authorRepo.findAll().get(0).getId());
        bookRepo.save(book);
    }

}
