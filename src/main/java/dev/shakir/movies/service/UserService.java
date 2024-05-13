package dev.shakir.movies.service;

import dev.shakir.movies.modal.User;
import dev.shakir.movies.modal.UserRole;
import dev.shakir.movies.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public List<User> getUsers(){return userRepository.findAll();}

    public Optional<User> getUser(ObjectId userId){
        return userRepository.findById(userId);
    }

    public Optional<User> getUser(String email){
        return userRepository.findByEmail(email);
    }

    public User addUser(String email,String userName, String password){
        return userRepository.insert(new User(email,userName,password));
    }

}
