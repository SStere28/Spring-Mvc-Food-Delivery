package com.epam.training.fooddelivery.controller;

import com.epam.training.fooddelivery.convertors.CartConvertor;
import com.epam.training.fooddelivery.convertors.OrderConvertor;
import com.epam.training.fooddelivery.domain.Customer;
import com.epam.training.fooddelivery.model.CartModel;
import com.epam.training.fooddelivery.model.OrderModel;
import com.epam.training.fooddelivery.repository.CustomerRepository;
import com.epam.training.fooddelivery.repository.OrderRepository;
import com.epam.training.fooddelivery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderService orderService;


    @RequestMapping(value = "/orderservice/orders", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> listAllOrders(HttpServletRequest request) {
         String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || !authentication.isAuthenticated() ){
            //  httpServletResponse.setStatus(403);
            return ResponseEntity.status(403).build();
        }
        OrderConvertor orderConvertor = new OrderConvertor();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        System.out.println("Username "+username);
        Customer customer = customerRepository.findByEmail(username);
        System.out.println("Customer "+customer);
        System.out.println("List orders"+orderRepository.findAllByCustomerId(customer.getId()));
        return new ResponseEntity<>(orderConvertor.convert(orderRepository.findAllByCustomerId(customer.getId())), HttpStatus.OK); }

    @RequestMapping(value = "/orderservice/orders/{orderId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> listAllOrders(@PathVariable("orderId") Integer orderId, HttpServletResponse httpServletResponse) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || !authentication.isAuthenticated() ){
            //  httpServletResponse.setStatus(403);
            return ResponseEntity.status(403).build();
        }
        System.out.println("List orders by id");
        OrderConvertor orderConvertor = new OrderConvertor();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        Customer customer = customerRepository.findByEmail(username);

        if(!orderId.equals(customer.getId())){
            return ResponseEntity.status(403).build();
        }

        return new ResponseEntity<>(orderConvertor.convert(orderRepository.findAllByCustomerId(Long.valueOf(orderId))), HttpStatus.OK); }

//    @RequestMapping(value = "/orderservice/orders", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//    public @ResponseBody OrderModel createOrder(@RequestBody CartModel cartModel,HttpServletResponse httpServletResponse) {
//        OrderConvertor orderConvertor = new OrderConvertor();
//        CartConvertor cartConvertor=new CartConvertor();
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String username = auth.getName();
//        Customer customer = customerRepository.findByEmail(username);
//        customer.setCart(cartConvertor.cartModel(cartModel));
//        orderService.createOrder();
//
//        return orderConvertor.convert(orderRepository.findAll()); }
}
