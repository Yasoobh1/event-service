package com.eventService.eventService.controller;


import com.eventService.eventService.dto.UserRequest;
import com.eventService.eventService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Create a new user
    @PostMapping("/create")
    public ResponseEntity<UserRequest> createUser(@RequestBody UserRequest userDTO) {
        UserRequest createdUser = userService.createUser(userDTO);
        return ResponseEntity.ok(createdUser);
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserRequest> getUserById(@PathVariable Long id) {
        UserRequest userDTO = userService.getUserById(id);
        if (userDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userDTO);
    }

    // Update user by ID
    @PutMapping("/update/{id}")
    public ResponseEntity<UserRequest> updateUser(@PathVariable Long id, @RequestBody UserRequest userDTO) {
        UserRequest updatedUser = userService.updateUser(id, userDTO);
        if (updatedUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedUser);
    }

    // Get all users
    @GetMapping("/all")
    public ResponseEntity<List<UserRequest>> getAllUsers() {
        List<UserRequest> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Delete user by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        boolean isDeleted = userService.deleteUser(id);
        if (isDeleted) {
            return ResponseEntity.ok("User deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
