package com.remivdeursen.yelper.service;

import com.remivdeursen.yelper.model.User;
import com.remivdeursen.yelper.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new EntityNotFoundException("User not found with id: " + id);
        }
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User modifyUser(User user) {
        Optional<User> userFromDb = userRepository.findById(user.getId());
        if (userFromDb.isPresent()) {
            return userRepository.save(user);
        } else {
            throw new EntityNotFoundException("User not found with id: " + user.getId());
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
