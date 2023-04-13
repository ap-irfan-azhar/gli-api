package com.example.gli.service.impl;

import com.example.gli.dto.UserFormDto;
import com.example.gli.entity.User;
import com.example.gli.entity.UserRole;
import com.example.gli.repository.UserRepository;
import com.example.gli.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleServiceImpl userRoleServiceImpl;

    @Override
    public Page<User> findAll(String search,Pageable pageable) {
        return userRepository.search(search, pageable);
    }

    @Override
    public User save(UserFormDto user) {
        UserRole role = userRoleServiceImpl.findById(user.getUserRoleId());

        User newUser = User.builder()
                .name(user.getName())
                .email(user.getEmail())
                .address(user.getAddress())
                .dob(user.getDob())
                .gender(user.getGender())
                .userRole(role)
                .build();
        try {
            return userRepository.save(newUser);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
    }

    @Override
    public User update(UserFormDto user, Long id) {
        User newUser = userRepository.findById(id).get();
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setAddress(user.getAddress());
        newUser.setDob(user.getDob());
        newUser.setGender(user.getGender());
        newUser.setUserRole(userRoleServiceImpl.findById(user.getUserRoleId()));

        return userRepository.save(newUser);
    }
}
