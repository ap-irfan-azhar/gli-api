package com.example.gli.controller;

import com.example.gli.dto.UserRoleFormDto;
import com.example.gli.entity.UserRole;
import com.example.gli.service.impl.UserRoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/user-role")
public class UserRoleController {

    @Autowired
    private UserRoleServiceImpl userRoleServiceImpl;

    @GetMapping("/")
    public Iterable<UserRole> index(
            @RequestParam String name
    ) {
        return userRoleServiceImpl.searchByName(name.toLowerCase());
    }

    @CrossOrigin
    @PostMapping("/")
    public ResponseEntity<UserRole> create(@RequestBody UserRoleFormDto userRoleReq) {
        if (userRoleReq.getName() == null
            || userRoleReq.getName().trim().isEmpty()
        ) {
            throw new RuntimeException("Name is required");
        }
        return ResponseEntity.created(null)
                .body(userRoleServiceImpl.save(userRoleReq));
    }


}
