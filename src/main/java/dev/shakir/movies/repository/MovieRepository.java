package dev.shakir.movies.repository;

import dev.shakir.movies.modal.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId>{

    public Optional<Movie> findByImdbId(String imdbId);
}
