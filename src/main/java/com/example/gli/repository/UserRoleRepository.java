package com.example.gli.repository;

import com.example.gli.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    @Query("SELECT u FROM UserRole u WHERE LOWER(u.name) LIKE %?1%")
    Iterable<UserRole> search(String keyword);
}
