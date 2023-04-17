package com.remivdeursen.yelper.service;

import com.remivdeursen.yelper.model.User;
import com.remivdeursen.yelper.model.UserRequest;
import com.remivdeursen.yelper.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User addUser(@Valid UserRequest user) {
        return userRepository.save(new User(user.getFirstName(), user.getLastName(), user.getUsername(), user.getEmail(), user.getPassword()));
    }

    public User updateUser(Long id, User user) {
        user.setId(id);
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
