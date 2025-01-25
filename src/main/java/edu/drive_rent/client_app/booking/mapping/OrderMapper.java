package edu.drive_rent.client_app.booking.mapping;

import edu.drive_rent.client_app.auth.models.User;
import edu.drive_rent.client_app.auth.repositories.UserRepository;
import edu.drive_rent.client_app.booking.controllers.dto.CarInfo;
import edu.drive_rent.client_app.booking.controllers.dto.OrderInfo;
import edu.drive_rent.client_app.booking.models.Order;
import edu.drive_rent.client_app.cars.models.Car;
import edu.drive_rent.client_app.cars.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final CarRepository carRepository;
    private final UserRepository userRepository;

    public OrderInfo toOrderInfo(Order order) {
        if (order == null) return null;

        var car = carRepository.findById(order.getCarId())
                .orElse(new Car());

        var carInfo = CarInfo.builder()
                .id(order.getCarId())
                .brand(car.getBrand().getName())
                .model(car.getModel().getName())
                .build();

        var user = userRepository.findById(order.getClientId())
                .orElse(new User());

        return OrderInfo.builder()
                .id(order.getId())
                .carInfo(carInfo)
                .client(user.getEmail())
                .status(order.getOrderStatus().getDescription())
                .orderDate(order.getOrderDate())
                .startDate(order.getStartDate())
                .endDate(order.getEndDate())
                .build();
    }
}
