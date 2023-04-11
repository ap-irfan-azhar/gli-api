package com.example.gli.controller;

import com.example.gli.dto.UserFormDto;
import com.example.gli.entity.User;
import com.example.gli.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/")
    public ResponseEntity<List<User>> index() {
        List<User> users = (List<User>) userServiceImpl.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> show(@PathVariable Long id) {
        User user = userServiceImpl.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/")
    public ResponseEntity<User> create(@RequestBody UserFormDto user) {
        return ResponseEntity.created(null)
                .body(userServiceImpl.save(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody UserFormDto user) {
        return ResponseEntity.ok(userServiceImpl.update(user, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable Long id) {
        userServiceImpl.delete(id);
        return ResponseEntity.noContent().build();
    }


}
