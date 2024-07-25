package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Hash the password
        return userRepository.save(user);
    }

    public boolean checkUserExists(String email, String mobile) {
        return userRepository.existsByEmailOrMobile(email, mobile);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

	public String generateUsername(String name) {
		// TODO Auto-generated method stub
		int a=(int) Math.floor(Math.random()*3);
		char b[]={'a','b','c'};
		return name+a+b[a];
	}

	public String generatePassword() {
		// TODO Auto-generated method stub
		return null;
	}
}
