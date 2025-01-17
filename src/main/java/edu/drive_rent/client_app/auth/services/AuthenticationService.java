package edu.drive_rent.client_app.auth.services;

import edu.drive_rent.client_app.auth.controllers.dto.SignInRequest;
import edu.drive_rent.client_app.auth.controllers.dto.SignUpRequest;
import edu.drive_rent.client_app.auth.jwt.JWTService;
import edu.drive_rent.client_app.auth.models.ERole;
import edu.drive_rent.client_app.auth.models.User;
import edu.drive_rent.client_app.auth.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final JWTService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authManager;

    public String signUp(SignUpRequest request) {

        User user = User.builder()
                .id(UUID.randomUUID().toString())
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(ERole.ROLE_USER)
                .licenseCode(request.getLicenseCode())
                .createdDate(LocalDateTime.now())
                .build();

        userRepository.save(user);

        return jwtService.generateToken(user);
    }

    public String signIn(SignInRequest request) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return jwtService.generateToken(user);
    }
}
