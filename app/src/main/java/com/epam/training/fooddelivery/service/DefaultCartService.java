package com.epam.training.fooddelivery.service;

import com.epam.training.fooddelivery.domain.Cart;
import com.epam.training.fooddelivery.domain.Customer;
import com.epam.training.fooddelivery.domain.Food;
import com.epam.training.fooddelivery.domain.OrderItem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultCartService implements CartService {

    int priceCart;

    public DefaultCartService() {
    }

    @Override
    @Transactional
    public void updateCart(Customer customer, Food food, int pieces) {

        OrderItem orderItem = new OrderItem();
        orderItem.setPieces(pieces);
        orderItem.setFood(food);
        orderItem.setPrice(food.getPrice().multiply(new BigDecimal(pieces)));

        // Verificam daca exista produse in cos
        if (!customer.getCart().getOrderItems().isEmpty()) {

            List<OrderItem> orderItems = customer.getCart().getOrderItems();
            //Eliminam produse din cos
            if (pieces == 0) {
                orderItems.removeIf(orderItem1 -> orderItem1.getFood() == food);
                priceCart = 0;
                orderItems.forEach(orderItem1 -> priceCart += orderItem1.getPrice().intValue());
                customer.getCart().setPrice(new BigDecimal(priceCart));
            }
            //Update la produse existente in cos
            else if (orderItems.stream().anyMatch(orderItem1 -> orderItem1.getFood() == food)) {

                //  Cauta orderitem daca exista update la element
                int index = orderItems.indexOf(orderItems.stream()
                        .filter(orderItem1 -> orderItem1.getFood().equals(food)).toList().get(0));
                orderItems.set(index, orderItem);
                customer.getCart().setOrderItems(orderItems);
                priceCart = 0;
                orderItems.forEach(orderItem1 -> priceCart += orderItem1.getPrice().intValue());
                customer.getCart().setPrice(BigDecimal.valueOf(priceCart));

            }
            //Adaugam produse noi in cosul existent
            else {
                orderItems.add(orderItem);
                customer.getCart().setOrderItems(orderItems);
                customer.getCart().setPrice(food.getPrice().multiply(new BigDecimal(pieces)).add(customer.getCart().getPrice()));
            }
        }
        //Facem un nou cos
        else {
            Cart cart = new Cart();
            List<OrderItem> orderItems = new ArrayList<>();
            orderItems.add(orderItem);
            cart.setPrice(BigDecimal.valueOf((long) food.getPrice().intValue() * pieces));
            cart.setOrderItems(orderItems);
            customer.setCart(cart);
        }
    }
}
