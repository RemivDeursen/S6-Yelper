package com.remivdeursen.yelper.controller;
import com.remivdeursen.yelper.model.User;
import com.remivdeursen.yelper.model.UserRequest;
import com.remivdeursen.yelper.model.UserResponse;
import com.remivdeursen.yelper.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        List<UserResponse> userResponses = new ArrayList<>();
        for (User user : users) {
            UserResponse userResponse = new UserResponse(user.getId(), user.getUsername(), user.getEmail(), user.getFirstName(), user.getLastName());
            userResponses.add(userResponse);
        }
        return ResponseEntity.ok(userResponses);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        Optional<User> optionalUser = userService.getUserById(id);

        if (optionalUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        User user = optionalUser.get();
        UserResponse userResponse = new UserResponse(user.getId(), user.getUsername(), user.getEmail(), user.getFirstName(), user.getLastName());
        return ResponseEntity.ok(userResponse);
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<UserResponse> addUser(@RequestBody @Valid UserRequest userRequest) {
        try {
            User user = userService.addUser(userRequest);
            UserResponse userResponse = new UserResponse(user.getId(), user.getFirstName(), user.getLastName(), user.getUsername(), user.getEmail());
            return ResponseEntity.ok(userResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody @Valid UserRequest userRequest) {
        Optional<User> optionalUser = userService.getUserById(id);

        if (optionalUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        User userToUpdate = optionalUser.get();

        // Update the user entity with the new data
        userToUpdate.setUsername(userRequest.getUsername());
        userToUpdate.setEmail(userRequest.getEmail());
        userToUpdate.setPassword(userRequest.getPassword());
        userService.updateUser(userToUpdate);

        UserResponse userResponse = new UserResponse(userToUpdate.getId(), userToUpdate.getUsername(), userToUpdate.getEmail(), userToUpdate.getFirstName(), userToUpdate.getLastName());
        return ResponseEntity.ok(userResponse);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}