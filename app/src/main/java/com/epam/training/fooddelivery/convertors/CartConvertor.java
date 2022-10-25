package com.epam.training.fooddelivery.convertors;

import com.epam.training.fooddelivery.domain.Cart;
import com.epam.training.fooddelivery.model.CartModel;

public class CartConvertor {

    public CartModel cartModel(Cart cart) {
        CartModel cartModel = new CartModel();
        cartModel.setPrice(cart.getPrice());
        OrderItemConvertor orderConvertor = new OrderItemConvertor();
        cartModel.setOrderItemModels(orderConvertor.convert(cart.getOrderItems()));

        return cartModel;
    }
    public Cart cart(CartModel cartModel){
        Cart cart=new Cart();
        cart.setPrice(cartModel.getPrice());
      //  cart.setOrderItems();
        return cart;
    }
}
