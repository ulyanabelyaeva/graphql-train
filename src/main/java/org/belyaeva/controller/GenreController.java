package org.belyaeva.controller;

import org.belyaeva.dto.Genre;
import org.belyaeva.dto.GenreFilter;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GenreController {

    @QueryMapping
    public List<Genre> genres(@Argument GenreFilter request) {
        return Genre.getByFilter(request);
    }
}
