package org.belyaeva.controller;

import org.belyaeva.dto.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.graphql.test.tester.GraphQlTester;

@GraphQlTest(BookController.class)
class BookControllerTest {

    @Autowired
    private GraphQlTester graphQlTester;

    @Test
    void canGetBooks() {
        graphQlTester.documentName("books") //указывает на /src/test/resources/books.graphql
                .execute()
                .path("books") //указывает на query books в books.graphql
                .entityList(Book.class)
                .hasSize(4);

    }
}