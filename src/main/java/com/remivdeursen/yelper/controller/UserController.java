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

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
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

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}