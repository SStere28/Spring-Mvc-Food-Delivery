package com.epam.training.fooddelivery.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "ORDER_ITEM")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ID", unique = true)
    private Long id;
    @OneToOne()
    @JoinColumn(name = "FOOD_ID")
    private Food food;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "ORDER_ID")
    private Order order;
    @Column
    private int pieces;
    @Column
    private BigDecimal price;


    public OrderItem() {
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", food=" + food +
                ", order=" + order +
                ", pieces=" + pieces +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;
        OrderItem orderItem = (OrderItem) o;
        return getPieces() == orderItem.getPieces() && Objects.equals(getId(), orderItem.getId()) && Objects.equals(getFood(), orderItem.getFood()) && Objects.equals(getOrder(), orderItem.getOrder()) && Objects.equals(getPrice(), orderItem.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFood(), getOrder(), getPieces(), getPrice());
    }
}
