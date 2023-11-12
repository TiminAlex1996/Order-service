package ru.sber.orderservice.persistent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sber.orderservice.persistent.entity.Order;

@Repository
public interface OrdersRepository extends JpaRepository<Order, Long> {

}
