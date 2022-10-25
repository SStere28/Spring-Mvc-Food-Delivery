package com.epam.training.fooddelivery.convertors;

import com.epam.training.fooddelivery.domain.OrderItem;
import com.epam.training.fooddelivery.model.OrderItemModel;

import java.util.ArrayList;
import java.util.List;

public class OrderItemConvertor {

    public List<OrderItemModel> convert(List<OrderItem> orderItems){

        List<OrderItemModel> orderItemModels=new ArrayList<>();
        for (OrderItem orderItem : orderItems
        ){
            OrderItemModel orderItemModel=new OrderItemModel();
            orderItemModel.setId(orderItem.getId());;
            orderItemModel.setPrice(orderItem.getPrice());
            orderItemModel.setPieces(orderItem.getPieces());
            FoodConvertor foodConvertor=new FoodConvertor();
            orderItemModel.setFoodModel(foodConvertor.convertFood(orderItem.getFood()));

        }
        return orderItemModels;
    }

    public List<OrderItem> convertOrderItem(List<OrderItemModel> orderItems){

        List<OrderItem> orderItemModels=new ArrayList<>();
        for (OrderItemModel orderItem : orderItems
        ){
            OrderItemModel orderItemModel=new OrderItemModel();
            orderItemModel.setId(orderItem.getId());;
            orderItemModel.setPrice(orderItem.getPrice());
            orderItemModel.setPieces(orderItem.getPieces());
            FoodConvertor foodConvertor=new FoodConvertor();
         //   orderItemModel.setFoodModel(foodConvertor.convertFood(orderItem.getFood()));

        }
        return orderItemModels;
    }
}
