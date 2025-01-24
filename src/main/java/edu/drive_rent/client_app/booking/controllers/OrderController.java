package edu.drive_rent.client_app.booking.controllers;

import edu.drive_rent.client_app.booking.models.OrderStatus;
import edu.drive_rent.client_app.booking.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/orders", produces = "application/json;charset=UTF-8")
@RequiredArgsConstructor
public class OrderController {

    private final BookingService bookingService;

    @GetMapping("{id}/status")
    public OrderStatus getStatus(@PathVariable String id) {

        return bookingService.getOrderStatus(id).getOrderStatus();
    }
}
