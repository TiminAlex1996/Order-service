package ru.sber.orderservice.data;

import ru.sber.orderservice.dto.OrderDto;
import ru.sber.orderservice.dto.OrderItemDto;
import ru.sber.orderservice.dto.ResponseMsg;
import ru.sber.orderservice.persistent.entity.Order;
import ru.sber.orderservice.persistent.entity.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class DataForTest {
    public OrderDto orderDto() {
        OrderItemDto orderItemDto = OrderItemDto.builder()
                .nameProduct("product1")
                .quantity(1)
                .description("product1")
                .build();

        List<OrderItemDto> orderItemDtos = new ArrayList<>();
        orderItemDtos.add(orderItemDto);

        return new OrderDto(1L, orderItemDtos);
    }

    public Order getOrder() {
        Order order = new Order();

        OrderItem orderItem = OrderItem.builder()
                .order(order)
                .nameProduct("product1")
                .quantity(1)
                .description("product1")
                .build();
        List<OrderItem> orderDTOs = new ArrayList<>();
        orderDTOs.add(orderItem);

        order.setId(1L);
        order.setItems(orderDTOs);
        order.setUserId(1L);
        return order;
    }

    public ResponseMsg getResponseMsg() {
        return new ResponseMsg(1L, "Order was successfully created");
    }

    public List<Order> getListOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(getOrder());
        return orders;
    }
}
