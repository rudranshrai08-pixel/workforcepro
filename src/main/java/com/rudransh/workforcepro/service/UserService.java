package com.rudransh.workforcepro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rudransh.workforcepro.entity.User;
import com.rudransh.workforcepro.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Register User
    public User saveUser(User user) {

        // Encrypt password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    // Get User By ID
    public User getUserById(Long id) {

        return userRepository.findById(id).orElse(null);
    }

    // Get User By Email
    public User getUserByEmail(String email) {

        return userRepository.findByEmail(email).orElse(null);
    }

    // Update User
    public User updateUser(Long id, User updatedUser) {

        User user = userRepository.findById(id).orElse(null);

        if (user != null) {

            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());

            // Encrypt updated password
            user.setPassword(passwordEncoder.encode(updatedUser.getPassword()));

            user.setRole(updatedUser.getRole());

            return userRepository.save(user);
        }

        return null;
    }
}