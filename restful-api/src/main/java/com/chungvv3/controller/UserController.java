package com.chungvv3.controller;

import com.chungvv3.entities.User;
import com.chungvv3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable int userId) {
        return userService.getUser(userId);
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User addedUser = userService.addUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{userId}").buildAndExpand(addedUser.getId()).toUri();
        return ResponseEntity.created(location).body(null);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userService.delete(userId);
    }
}
