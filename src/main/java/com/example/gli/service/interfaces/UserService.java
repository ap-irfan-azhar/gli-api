package com.example.gli.service.interfaces;

import com.example.gli.dto.UserFormDto;
import com.example.gli.entity.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Page<User> findAll(String search, Pageable pageable);
    User save(UserFormDto user);
    User findById(Long id);
    void delete(Long id);
    User update(UserFormDto user, Long id);
}
