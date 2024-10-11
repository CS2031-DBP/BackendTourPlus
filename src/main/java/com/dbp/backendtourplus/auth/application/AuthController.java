package com.dbp.backendtourplus.auth.application;

import com.dbp.backendtourplus.auth.dto.JwtAuthResponse;
import com.dbp.backendtourplus.auth.dto.LoginReq;
import com.dbp.backendtourplus.auth.dto.RegisterReq;
import com.dbp.backendtourplus.auth.exceptions.UserAlreadyExistException;
import com.dbp.backendtourplus.config.JwtService;
import com.dbp.backendtourplus.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import com.dbp.backendtourplus.auth.domain.AuthService;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final AuthService authService;
    private final JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterReq registerReq) {
        try {
            User user = authService.register(registerReq);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginReq loginReq) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginReq.getEmail(), loginReq.getPassword())
            );
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String token = jwtService.generateToken(userDetails);
            JwtAuthResponse jwtAuthResponse = new JwtAuthResponse(token, "Bearer");
            return ResponseEntity.ok(jwtAuthResponse);
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
    }
}
