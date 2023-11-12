package ru.sber.orderservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sber.orderservice.dto.OrderDto;
import ru.sber.orderservice.mapper.Mapper;
import ru.sber.orderservice.persistent.entity.Order;
import ru.sber.orderservice.persistent.repository.OrdersRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrdersRepository ordersRepository;

    private final Mapper<OrderDto, Order> orderMapper;

    @Override
    public List<Order> getAllOrders() {
        log.info("Get list all orders");
        return ordersRepository.findAll();
    }

    @Override
    @Transactional
    public Order createdOrder(OrderDto orderDto) {
        log.info("Mapped order request {}", orderDto);
        Order order = orderMapper.map(orderDto);
        log.info("Save order {}", order);
        return ordersRepository.save(order);
    }
}
