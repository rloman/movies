package com.warnerbros.movies.persistence;

import com.warnerbros.movies.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository <Movie, Long> {
}
