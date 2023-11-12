package ru.sber.orderservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.sber.orderservice.data.DataForTest;
import ru.sber.orderservice.dto.OrderDto;
import ru.sber.orderservice.mapper.Mapper;
import ru.sber.orderservice.persistent.entity.Order;
import ru.sber.orderservice.persistent.repository.OrdersRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class OrderServiceTests {
    DataForTest data = new DataForTest();
    @Autowired
    private OrderService orderService;
    @MockBean
    private OrdersRepository ordersRepository;
    @MockBean
    private Mapper<OrderDto, Order> orderMapper;

    @Test
    public void createOrder_thenSuccess() {
        Mockito.when(orderMapper.map(data.orderDto())).thenReturn(data.getOrder());
        Mockito.when(ordersRepository.save(data.getOrder())).thenReturn(data.getOrder());

        orderService.createdOrder(data.orderDto());

        Mockito.verify(orderMapper, Mockito.times(1)).map(data.orderDto());
        Mockito.verify(ordersRepository, Mockito.times(1)).save(data.getOrder());
    }

    @Test
    public void getAllOrder_thenSuccess() {
        Mockito.when(ordersRepository.findAll()).thenReturn(data.getListOrder());

        orderService.getAllOrders();

        Mockito.verify(ordersRepository, Mockito.times(1)).findAll();
    }

}
