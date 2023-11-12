package ru.sber.orderservice.mapper;

import org.springframework.stereotype.Component;
import ru.sber.orderservice.dto.OrderDto;
import ru.sber.orderservice.dto.OrderItemDto;
import ru.sber.orderservice.persistent.entity.Order;
import ru.sber.orderservice.persistent.entity.OrderItem;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapperImpl implements Mapper<OrderDto, Order> {
    @Override
    public Order map(OrderDto orderDto) {
        Order order = new Order();

        List<OrderItem> orderItems = new ArrayList<>();

        for (OrderItemDto orderItemDto : orderDto.getItems()) {
            OrderItem orderItem = OrderItem.builder()
                    .order(order)
                    .description(orderItemDto.getDescription())
                    .nameProduct(orderItemDto.getNameProduct())
                    .quantity(orderItemDto.getQuantity())
                    .build();
            orderItems.add(orderItem);
        }
        order.setUserId(orderDto.getUserId());
        order.setItems(orderItems);
        return order;
    }
}
