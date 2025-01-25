package edu.drive_rent.client_app.cars.controllers;

import edu.drive_rent.client_app.auth.models.User;
import edu.drive_rent.client_app.cars.controllers.dto.CommentRequest;
import edu.drive_rent.client_app.cars.models.Comment;
import edu.drive_rent.client_app.cars.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cars")
@RequiredArgsConstructor
public class CommentsController {

    private final CarService carService;

    @GetMapping("/{id}/comments")
    public List<Comment> getAllCommentsForCar(@PathVariable("id") String carId) {

        return carService.getAllCommentsForCar(carId);
    }

    @PostMapping("/{id}/comments")
    public void addComment(@PathVariable("id") String carId,
                           @RequestBody CommentRequest comment,
                           @AuthenticationPrincipal UserDetails userDetails
    ) {
        carService.addNewComment(((User) userDetails), carId, comment.getText());
    }
}
