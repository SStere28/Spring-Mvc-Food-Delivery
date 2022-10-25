package com.epam.training.fooddelivery.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.mapping.ToOne;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "_ORDER")
@ToString(exclude = {"customer"})
@EqualsAndHashCode(exclude = {"customer"})
public class Order {
    @Id
    @Column(name = "ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;
    @Column
    private BigDecimal price;
    @Column
    private LocalDateTime timestampCreated;
    @Transient
    private List<OrderItem> orderItems;

    public Order() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long orderId) {
        this.id = orderId;
    }



    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getTimestampCreated() {
        return timestampCreated;
    }

    public void setTimestampCreated(LocalDateTime timestampCreated) {
        this.timestampCreated = timestampCreated;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }



        @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", price=" + price +
                ", timestampCreated=" + timestampCreated +
                ", orderItems=" + orderItems +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(getId(), order.getId()) && Objects.equals(getPrice(), order.getPrice()) && Objects.equals(getTimestampCreated(), order.getTimestampCreated()) && Objects.equals(getOrderItems(), order.getOrderItems());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPrice(), getTimestampCreated(), getOrderItems());
    }
}
