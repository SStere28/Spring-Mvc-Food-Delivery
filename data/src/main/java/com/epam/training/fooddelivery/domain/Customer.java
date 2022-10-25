package com.epam.training.fooddelivery.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CUSTOMER")
@ToString(exclude = "orders")
public class Customer extends User {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private BigDecimal balance;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private List<Order> orders;
    @Transient
    private Cart cart;


    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public List<Order> getOrders() {
        return orders;
    }


    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Cart getCart() {
        return cart;
    }

    @Autowired
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", orders=" + orders +
                ", cart=" + cart +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(getId(), customer.getId()) && Objects.equals(getName(), customer.getName()) && Objects.equals(getBalance(), customer.getBalance()) && Objects.equals(getOrders(), customer.getOrders()) && Objects.equals(getCart(), customer.getCart());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getName(), getBalance(), getOrders(), getCart());
    }
}
