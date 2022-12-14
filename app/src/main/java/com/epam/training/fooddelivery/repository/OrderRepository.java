package com.epam.training.fooddelivery.repository;

import com.epam.training.fooddelivery.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {

    List<Order> findAllByCustomerId(Long customerId);
}
