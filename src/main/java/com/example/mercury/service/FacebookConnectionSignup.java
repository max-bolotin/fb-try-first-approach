package com.example.mercury.service;

import com.example.mercury.model.User;
import com.example.mercury.repository.UserRepository;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Service;

@Service
public class FacebookConnectionSignup implements ConnectionSignUp {

    private final UserRepository userRepository;

    public FacebookConnectionSignup(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String execute(Connection<?> connection) {
        User user = new User();
        user.setUsername(connection.getDisplayName());
        user.setPassword(Integer.toString((int) (Math.random() * Integer.MAX_VALUE), 36));
        userRepository.save(user);
        return user.getUsername();
    }
}