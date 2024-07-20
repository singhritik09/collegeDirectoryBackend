package com.singhritik.backend.service;

import com.singhritik.backend.dto.LoginRequest;
import com.singhritik.backend.dto.LoginResponse;
import com.singhritik.backend.model.User;
import com.singhritik.backend.model.ROLE;
import com.singhritik.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public LoginResponse login(LoginRequest loginRequest) {
        ROLE role;
        try {
            role = ROLE.valueOf(loginRequest.getRole());
        } catch (IllegalArgumentException e) {
            return new LoginResponse("INVALID_ROLE", null);
        }

        User user = userRepository.findByUsernameAndRole(loginRequest.getUsername(), role);
        if (user == null || !user.getPassword().equals(loginRequest.getPassword())) {
            return new LoginResponse("NOTMATCH", null);
        }
        return new LoginResponse("SUCCESS", user.getRole().name());
    }
}
