package com.sam.controllers;

import com.sam.models.User;
import com.sam.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UserResource {
    private final static Logger log = LoggerFactory.getLogger(UserResource.class);

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<User> save(@RequestBody User user) {
        log.info("Request To save user", user);
        User result = userService.save(user);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/user")
    public ResponseEntity<User> update(@RequestBody User user) {
        log.info("Request To save user", user);
        User result = userService.save(user);
        return ResponseEntity.ok(result);
    }


    @GetMapping("/user")
    public ResponseEntity<List<User>> allUsers() {
        return ResponseEntity.ok(userService.findAll());
    }
}
