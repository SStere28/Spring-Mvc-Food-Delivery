package com.epam.training.fooddelivery.service;

import com.epam.training.fooddelivery.domain.Cart;
import com.epam.training.fooddelivery.domain.Customer;
import com.epam.training.fooddelivery.domain.User;
import com.epam.training.fooddelivery.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultCustomerService implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public DefaultCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public Customer authenticate(User user) {

        List<Customer> customers = customerRepository.findAll();
        if (customers.stream()
                .anyMatch(customer ->
                        customer.getEmail().
                                equals(user.getEmail()) && customer.getPassword()
                                .equals(user.getPassword()))) {
            Customer customer1 = customers.stream().filter(customer -> customer.getPassword()
                    .equals(user.getPassword())).toList().get(0);
            Cart cart = new Cart();
            cart.setPrice(new BigDecimal(0));
            cart.setOrderItems(new ArrayList<>());
            customer1.setCart(cart);
            return customer1;
        } else {
            throw new AuthenticationException("User it's not found");
        }
    }
}
