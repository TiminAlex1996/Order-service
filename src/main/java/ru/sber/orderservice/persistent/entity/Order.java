package ru.sber.orderservice.persistent.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
@Schema(description = "Order model information")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "User id")
    @Column(name = "user_id")
    private long userId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "order")
    @JsonManagedReference
    private List<OrderItem> items;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return getUserId() == order.getUserId()
                && Objects.equals(getItems(), order.getItems());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserId(), getItems());
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", items=" + items +
                '}';
    }
}
