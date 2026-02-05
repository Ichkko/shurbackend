package com.example.shure.service.ipml;

import com.example.shure.model.Cart;
import com.example.shure.repository.CartRepository;
import com.example.shure.service.CartService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceIpml implements CartService {

    private final CartRepository cartRepository;

    public CartServiceIpml(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    @Override
    public Optional<Cart> getCartById(Long id) {
        return cartRepository.findById(id);
    }

    @Override
    public Cart updateCart(Long id, Cart cart) {
        Cart existing = cartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        existing.setUser(cart.getUser());
        existing.setProduct(cart.getProduct());
        existing.setQuantity(cart.getQuantity());

        return cartRepository.save(existing);
    }

    @Override
    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }
}
