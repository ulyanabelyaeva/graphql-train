package org.belyaeva.controller;

import org.belyaeva.dto.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureGraphQlTester
class BookControllerTest {

    @Autowired
    private GraphQlTester graphQlTester;

    @Test
    void createNewBook() {
        Long newBookId = graphQlTester.documentName("books")
                .operationName("CreateNewBook")
                .execute()
                .path("createNewBook")
                .entity(Long.class)
                .get();
        Assertions.assertNotNull(newBookId);
    }

    @Test
    void canGetBooks() {
        List<Book> books = graphQlTester.documentName("books")
                .operationName("GetAllBooks")
                .execute()
                .path("getAllBooks")
                .entityList(Book.class)
                .get();
        Assertions.assertEquals(5, books.size());
    }
}