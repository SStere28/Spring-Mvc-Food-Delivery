package com.epam.training.fooddelivery.convertors;

import com.epam.training.fooddelivery.domain.Order;
import com.epam.training.fooddelivery.model.OrderModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderConvertor {

    public List<OrderModel> convert(List<Order> orders) {
        List<OrderModel> orderModels = new ArrayList<>();
        OrderItemConvertor orderItemConvertor=new OrderItemConvertor();
        for (Order order: orders
             ) {
            OrderModel orderModel=new OrderModel();
            orderModel.setId(order.getId());
            orderModel.setPrice(order.getPrice());
            //mai e de implementat
           // orderModel.setOrderItemModels(orderItemConvertor.convert(order.getOrderItems()));
            orderModels.add(orderModel);
        }
        return orderModels;
    }
    public OrderModel convert(Order orders) {
        return null;
    }
}
