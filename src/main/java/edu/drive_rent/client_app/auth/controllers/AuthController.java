package edu.drive_rent.client_app.auth.controllers;

import edu.drive_rent.client_app.auth.controllers.dto.SignInRequest;
import edu.drive_rent.client_app.auth.controllers.dto.SignInResponse;
import edu.drive_rent.client_app.auth.controllers.dto.SignUpRequest;
import edu.drive_rent.client_app.auth.controllers.dto.SignUpResponse;
import edu.drive_rent.client_app.auth.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authService;

    @PostMapping("/signup")
    public SignUpResponse signUp(@RequestBody SignUpRequest request) {

        return SignUpResponse.builder()
                .token(authService.signUp(request))
                .build();
    }

    @PostMapping("/signin")
    public SignInResponse signIn(@RequestBody SignInRequest request) {

        return SignInResponse.builder()
                .token(authService.signIn(request))
                .build();
    }
}
