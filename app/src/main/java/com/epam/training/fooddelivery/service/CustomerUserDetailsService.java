package com.epam.training.fooddelivery.service;

import com.epam.training.fooddelivery.domain.Customer;
import com.epam.training.fooddelivery.domain.User;
import com.epam.training.fooddelivery.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        Customer customer = new Customer();
        customer=customerRepository.findByEmail(email);
        User user = new User();
        if (customer == null) {
            System.out.println("Customer null: "+email);
            throw new UsernameNotFoundException(email);
        }else {
            user.setEmail(customer.getEmail());
            user.setPassword(customer.getPassword());
            System.out.println(customer);
        }
        return new MyUserDetails(user);
    }




}