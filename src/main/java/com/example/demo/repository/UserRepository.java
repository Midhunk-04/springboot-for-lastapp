package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmailOrMobile(String email, String mobile);

    User findByUsername(String username);
}
