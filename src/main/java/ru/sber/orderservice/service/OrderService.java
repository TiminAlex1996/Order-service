package ru.sber.orderservice.service;

import ru.sber.orderservice.dto.OrderDto;
import ru.sber.orderservice.persistent.entity.Order;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();

    Order createdOrder(OrderDto orderDto);
}
