package org.graph.graphqlexample.controller;

import lombok.RequiredArgsConstructor;
import org.graph.graphqlexample.entity.Order;
import org.graph.graphqlexample.entity.User;
import org.graph.graphqlexample.service.OrderService;
import org.graph.graphqlexample.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final UserService userService;

    @MutationMapping
    public Order createOrder(@Argument String address,@Argument int totalPrice,
                             @Argument int userId
    ){
        User user=userService.getUserById(userId);
        Order order1=new Order();
        order1.setUser(user);
        order1.setAddress(address);
        order1.setTotalPrice(totalPrice);

        return orderService.createOrder(order1);
    }
    @MutationMapping
    public Boolean deleteOrderById(@Argument  Integer orderId){
        return orderService.deleteOrderById(orderId);
    }

    @QueryMapping
    public List<Order> getOrders(){
        return orderService.findAllOrders();
    }

    @QueryMapping
    public Order getOrder(@Argument Integer orderId){
        return orderService.findOrderById(orderId);
    }
}
