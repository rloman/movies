package com.warnerbros.movies.api;

import com.warnerbros.movies.model.Movie;
import com.warnerbros.movies.persistence.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/movies")
public class MovieController {


    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public Iterable<Movie> list() {

        Iterable<Movie> movies = this.movieRepository.findAll();

        return movies;

    }
}
