package edu.drive_rent.client_app.booking.mapping;

import edu.drive_rent.client_app.booking.controllers.dto.CarInfo;
import edu.drive_rent.client_app.booking.controllers.dto.OrderInfo;
import edu.drive_rent.client_app.booking.models.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    public static OrderInfo toOrderInfo(Order order) {
        if (order == null) return null;

        var carInfo = CarInfo.builder()
                .id(order.getCarId())
                .build();

        return OrderInfo.builder()
                .id(order.getId())
                .carInfo(carInfo)
                .client(order.getClientId())
                .status(order.getOrderStatus().getDescription())
                .orderDate(order.getOrderDate())
                .startDate(order.getStartDate())
                .endDate(order.getEndDate())
                .build();
    }
}
