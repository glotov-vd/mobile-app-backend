package edu.drive_rent.client_app.auth.services;

import edu.drive_rent.client_app.auth.models.User;
import edu.drive_rent.client_app.auth.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
