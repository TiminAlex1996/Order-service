package ru.sber.orderservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Response to order creation request")
public class ResponseMsg {
    @Schema(description = "Order id")
    private Long orderId;

    @Schema(description = "message")
    private String message;
}
