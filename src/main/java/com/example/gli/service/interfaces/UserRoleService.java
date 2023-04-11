package com.example.gli.service.interfaces;

import com.example.gli.dto.UserRoleFormDto;
import com.example.gli.entity.UserRole;

import java.util.List;

public interface UserRoleService {
    UserRole save(UserRoleFormDto name);
    Iterable<UserRole> searchByName(String name);
    List<UserRole> findAll();

    UserRole findById(Long id);
}
