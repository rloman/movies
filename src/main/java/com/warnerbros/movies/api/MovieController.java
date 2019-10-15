package com.warnerbros.movies.api;

import com.warnerbros.movies.model.Movie;
import com.warnerbros.movies.persistence.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping("api/movies")
public class MovieController {


    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public ResponseEntity<Iterable<Movie>> list() {

        Iterable<Movie> movies = this.movieRepository.findAll();

        return ResponseEntity.ok(movies);

    }

    @PostMapping
    public ResponseEntity<Movie> create(@RequestBody Movie movie) {
        this.movieRepository.save(movie); // wijst ook nu een id toe.

        try {
            return ResponseEntity.created(new URI("http://localhost:8080/api/movies" + movie.getId())).body(movie);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Movie> findById(@PathVariable long id) {
        Optional<Movie> optionalMovie = this.movieRepository.findById(id);
        if(optionalMovie.isPresent()) {
            Movie result = optionalMovie.get();

            return ResponseEntity.ok(result);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }


}
