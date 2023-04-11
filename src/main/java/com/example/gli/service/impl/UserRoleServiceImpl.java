package com.example.gli.service.impl;

import com.example.gli.entity.UserRole;
import com.example.gli.repository.UserRoleRepository;
import com.example.gli.service.interfaces.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserRole save(String name) {
        UserRole userRole = new UserRole();
        userRole.setName(name);
        return userRoleRepository.save(userRole);
    }


    @Override
    public Iterable<UserRole> searchByName(String name) {
        return userRoleRepository.search(name);
    }

    @Override
    public List<UserRole> findAll() {
        return userRoleRepository.findAll();
    }
}
