package edu.drive_rent.client_app.booking.repositories;

import edu.drive_rent.client_app.booking.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

    @Query("""
        SELECT o FROM Order o
        WHERE o.carId = :carId
        AND o.orderStatus = 'CONFIRMED'
        AND (o.startDate <= :endDate AND o.endDate >= :startDate)
    """)
    List<Order> findConflictingOrders(@Param("carId") String carId,
                                      @Param("startDate") Date startDate,
                                      @Param("endDate") Date endDate);

    @Query("""
        SELECT o FROM Order o
        WHERE o.id = :orderId
    """)
    Optional<Order> findOrderById(@Param("orderId") String orderId);
}