package edu.drive_rent.client_app.booking.controllers;

import edu.drive_rent.client_app.booking.controllers.dto.OrderInfo;
import edu.drive_rent.client_app.booking.mapping.OrderMapper;
import edu.drive_rent.client_app.booking.models.OrderStatus;
import edu.drive_rent.client_app.booking.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/orders", produces = "application/json;charset=UTF-8")
@RequiredArgsConstructor
public class OrderController {

    private final BookingService bookingService;
    private final OrderMapper orderMapper;

    @GetMapping
    public List<OrderInfo> getAllOrders(@RequestParam(required = false) String client) {

        if (client == null) {
            return bookingService.getAllOrders().stream()
                    .map(orderMapper::toOrderInfo)
                    .toList();
        }

        return bookingService.getAllOrdersOfUser(client).stream()
                .map(orderMapper::toOrderInfo)
                .toList();
    }

    @GetMapping("/{id}")
    public OrderInfo getOrderInfo(@PathVariable String id) {

        return orderMapper.toOrderInfo(bookingService.getOrder(id));
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable String id) {

        bookingService.canselOrder(id);
    }

    @GetMapping("{id}/status")
    public OrderStatus getStatus(@PathVariable String id) {

        return bookingService.getOrderStatus(id).getOrderStatus();
    }
}
