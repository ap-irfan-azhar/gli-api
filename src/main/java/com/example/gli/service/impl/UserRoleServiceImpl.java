package com.example.gli.service.impl;

import com.example.gli.dto.UserRoleFormDto;
import com.example.gli.entity.UserRole;
import com.example.gli.repository.UserRoleRepository;
import com.example.gli.service.interfaces.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserRole save(UserRoleFormDto userRoleDto) {
        UserRole userRole = new UserRole();
        userRole.setName(userRoleDto.getName());
        try {
            return userRoleRepository.save(userRole);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @Override
    public Iterable<UserRole> searchByName(String name) {
        return userRoleRepository.search(name);
    }

    @Override
    public List<UserRole> findAll() {
        return userRoleRepository.findAll();
    }

    @Override
    public UserRole findById(Long id) {
        Optional<UserRole> role = userRoleRepository.findById(id);
        if (role == null) {
            throw new RuntimeException("User role not found");
        }
        return role.get();
    }
}
