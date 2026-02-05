package com.example.shure.service;

import com.example.shure.model.Cart;

import java.util.List;
import java.util.Optional;

public interface CartService {

    Cart createCart(Cart cart);

    List<Cart> getAllCarts();

    Optional<Cart> getCartById(Long id);

    Cart updateCart(Long id, Cart cart);

    void deleteCart(Long id);
}
