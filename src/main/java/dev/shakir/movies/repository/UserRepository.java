package dev.shakir.movies.repository;


import dev.shakir.movies.modal.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
  public Optional<User> findByEmail(String email);
}
