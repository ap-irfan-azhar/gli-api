package com.example.gli.service.interfaces;

import com.example.gli.entity.User;

public interface UserService {
    Iterable<User> findAll();
    User save(User user);
    User findById(Long id);
    void delete(Long id);
    User update(User user);
}