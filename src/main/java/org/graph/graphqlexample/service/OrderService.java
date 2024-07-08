package org.graph.graphqlexample.service;

import lombok.RequiredArgsConstructor;
import org.graph.graphqlexample.entity.Order;
import org.graph.graphqlexample.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public Order createOrder(Order order){
        if(order==null){
            throw new RuntimeException("order is null");
        }
        return orderRepository.save(order);
    }

    public Order findOrderById(Integer id){
        Order order=orderRepository.findById(id).orElseThrow(()->new RuntimeException("no order found with this id "+id));
        return order;
    }

    public Boolean deleteOrderById(Integer id){
        Order order=orderRepository.findById(id).orElseThrow(()->new RuntimeException("no order found with this id "+id));
        orderRepository.deleteById(id);
        return true;
    }

    public List<Order> findAllOrders(){
        return orderRepository.findAll();
    }

}
