package ru.sber.orderservice.persistent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sber.orderservice.persistent.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
