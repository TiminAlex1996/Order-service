package ru.sber.orderservice.persistent.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders_item")
@Builder
@Schema(description = "Order item model information")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Product name")
    @Column(name = "name_product")
    private String nameProduct;

    @Schema(description = "Quantity of products")
    @Column(name = "quantity")
    private int quantity;

    @Schema(description = "Description of products")
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "order_id")
    private Order order;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;
        OrderItem orderItem = (OrderItem) o;
        return getQuantity() == orderItem.getQuantity()
                && Objects.equals(getId(), orderItem.getId())
                && Objects.equals(getNameProduct(), orderItem.getNameProduct())
                && Objects.equals(getDescription(), orderItem.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNameProduct(), getQuantity(), getDescription());
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", nameProduct='" + nameProduct + '\'' +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                '}';
    }
}
