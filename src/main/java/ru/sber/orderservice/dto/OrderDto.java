package ru.sber.orderservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Schema(description = "OrderDto model information")
@Data
@AllArgsConstructor
@Builder
public class OrderDto {
    @Schema(description = "User id")
    @Min(value = 1, message = "User id must be more than or equal to 1")
    private long userId;

    @Schema(description = "List orderItems")
    private List<@Valid OrderItemDto> items;
}
