package ru.sber.orderservice.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.sber.orderservice.api.controller.OrderController;
import ru.sber.orderservice.data.DataForTest;
import ru.sber.orderservice.service.OrderService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderController.class)
public class OrderControllerTests {

    DataForTest data = new DataForTest();
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private OrderService service;

    @Test
    void CreatedOrderTest_thenSuccess() throws Exception {
        when(service.createdOrder(data.orderDto())).thenReturn(data.getOrder());
        mockMvc.perform(post("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(data.orderDto())))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(data.getResponseMsg())));
    }

    @Test
    void GetOrdersTest_thenSuccess() throws Exception {
        when(service.getAllOrders()).thenReturn(data.getListOrder());
        mockMvc.perform(get("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(data.getListOrder())));
    }
}
