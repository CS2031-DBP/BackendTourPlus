package com.dbp.backendtourplus.auth.domain;

import com.dbp.backendtourplus.auth.dto.RegisterReq;
import com.dbp.backendtourplus.user.domain.Role;
import com.dbp.backendtourplus.user.domain.User;
import com.dbp.backendtourplus.user.infrastructure.UserRepository;
import com.dbp.backendtourplus.auth.exceptions.UserAlreadyExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User register(RegisterReq registerReq) {
        if (userRepository.existsByEmail(registerReq.getEmail())) {
            throw new UserAlreadyExistException("El email ya está en uso");
        }

        User user = new User();
        user.setFirstname(registerReq.getFirstname());
        user.setLastname(registerReq.getLastname());
        user.setEmail(registerReq.getEmail());
        user.setPassword(passwordEncoder.encode(registerReq.getPassword()));
        user.setRole(Role.USER);

        return userRepository.save(user);
    }
}

