package edu.drive_rent.client_app.booking.services;

import edu.drive_rent.client_app.booking.models.Order;
import edu.drive_rent.client_app.booking.models.OrderStatus;
import edu.drive_rent.client_app.booking.repositories.OrderRepository;
import edu.drive_rent.client_app.cars.controllers.dto.booking.BookingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final OrderRepository orderRepository;

    public boolean isCarAvailable(String id, Date startDate, Date endDate) {

        return orderRepository.findConflictingOrders(id, startDate, endDate).isEmpty();
    }

    public String bookCar(String carId, BookingRequest bookingRequest, String bookerId) {

        if (!isCarAvailable(carId, bookingRequest.getStartDate(), bookingRequest.getEndDate())) {
            return null;
        }

        var order = Order.builder()
                .id(UUID.randomUUID().toString())
                .carId(carId)
                .clientId(bookerId)
                .orderDate(new Date())
                .startDate(bookingRequest.getStartDate())
                .endDate(bookingRequest.getEndDate())
                .orderStatus(OrderStatus.PENDING)
                .build();

        orderRepository.save(order);

        return order.getId();
    }

    public Order getOrderStatus(String orderId) {
        return orderRepository.findOrderById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }
}
