package com.example.shure.service.ipml;

import com.example.shure.model.Order;
import com.example.shure.repository.OrderRepository;
import com.example.shure.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceIpml implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceIpml(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order updateOrder(Long id, Order order) {
        Order existing = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        existing.setUser(order.getUser());
        existing.setTotal(order.getTotal());
        existing.setStatus(order.getStatus());
        existing.setShippingAddress(order.getShippingAddress());
        existing.setPhone(order.getPhone());

        return orderRepository.save(existing);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
