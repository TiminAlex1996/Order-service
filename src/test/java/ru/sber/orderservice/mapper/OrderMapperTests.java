package ru.sber.orderservice.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.sber.orderservice.data.DataForTest;
import ru.sber.orderservice.dto.OrderDto;
import ru.sber.orderservice.persistent.entity.Order;

@SpringBootTest
public class OrderMapperTests {
    @Autowired
    Mapper<OrderDto, Order> orderMapper;
    DataForTest data = new DataForTest();

    @Test
    public void OrderDTOtoOrderTest_thenSuccess() {
        Order expected = data.getOrder();

        Order result = orderMapper.map(data.orderDto());

        Assertions.assertEquals(expected, result);
    }
}
