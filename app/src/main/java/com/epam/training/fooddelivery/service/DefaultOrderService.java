package com.epam.training.fooddelivery.service;

import com.epam.training.fooddelivery.domain.Cart;
import com.epam.training.fooddelivery.domain.Customer;
import com.epam.training.fooddelivery.domain.Order;
import com.epam.training.fooddelivery.domain.OrderItem;
import com.epam.training.fooddelivery.repository.CustomerRepository;
import com.epam.training.fooddelivery.repository.OrderItemRepository;
import com.epam.training.fooddelivery.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class DefaultOrderService implements OrderService {

    OrderRepository orderRepository;
    OrderItemRepository orderItemRepository;
    CustomerRepository customerRepository;
    long id;

    @Autowired
    public DefaultOrderService(OrderRepository orderRepository, OrderItemRepository orderItemRepository,
                               CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public Order createOrder(Customer customer) {
        if (customer.getCart().getPrice().intValue() == 0)
            throw new IllegalStateException();

        if (customer.getCart().getPrice().intValue() > customer.getBalance().intValue())
            throw new LowBalanceException("You don't have enough money, your balance is only " + customer.getBalance() + " EUR. " +
                    "We do not empty your cart, please remove some of the items.");

        Order order = getNewOrder(customer);

        List<OrderItem> orderItems = customer.getCart().getOrderItems();
        id = orderItemRepository.findAll().get((int) (orderRepository.count() - 1)).getId() + 1;
        orderItems.forEach(orderItem -> orderItem.setId(id += 1));

        customerRepository.save(customer);
        orderRepository.save(order);
        orderItemRepository.saveAll(orderItems);

        customer.setCart(new Cart());
        updateOrders(customer, order);
        return order;

    }

    private void updateOrders(Customer customer, Order order) {
        List<Order> orders;
        if (customer.getOrders().size() > 0) {
            orders = customer.getOrders();
        } else {
            orders = new ArrayList<>();
        }
        orders.add(order);
        customer.setOrders(orders);
    }


    private Order getNewOrder(Customer customer) {
        Order order = new Order();
        Long orderId = orderRepository.findAll().stream().max(Comparator.comparing(Order::getId)).get().getId() + 1;
        order.setId(orderId);
        order.setPrice(customer.getCart().getPrice());
        order.setTimestampCreated(LocalDateTime.now());
        order.setCustomer(customer);
        order.setOrderItems(customer.getCart().getOrderItems());
        return order;
    }
}
