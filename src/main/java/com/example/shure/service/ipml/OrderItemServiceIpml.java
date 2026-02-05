package com.example.shure.service.ipml;

import com.example.shure.model.OrderItem;
import com.example.shure.repository.OrderItemRepository;
import com.example.shure.service.OrderItemService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemServiceIpml implements OrderItemService {

    private final OrderItemRepository orderItemRepository;

    public OrderItemServiceIpml(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    @Override
    public Optional<OrderItem> getOrderItemById(Long id) {
        return orderItemRepository.findById(id);
    }

    @Override
    public OrderItem updateOrderItem(Long id, OrderItem orderItem) {
        OrderItem existing = orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order item not found"));

        existing.setOrder(orderItem.getOrder());
        existing.setProduct(orderItem.getProduct());
        existing.setQuantity(orderItem.getQuantity());
        existing.setPrice(orderItem.getPrice());

        return orderItemRepository.save(existing);
    }

    @Override
    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }
}
