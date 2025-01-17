package edu.drive_rent.client_app.auth.controllers;

import edu.drive_rent.client_app.auth.models.User;
import edu.drive_rent.client_app.auth.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> getAllUsers() {

        return userService.getAllUsers();
    }
}
