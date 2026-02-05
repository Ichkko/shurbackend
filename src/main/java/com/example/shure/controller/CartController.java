package com.example.shure.controller;

import com.example.shure.model.Cart;
import com.example.shure.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
        return ResponseEntity.ok(cartService.createCart(cart));
    }

    @GetMapping
    public ResponseEntity<List<Cart>> getAllCarts() {
        return ResponseEntity.ok(cartService.getAllCarts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable Long id) {
        return cartService.getCartById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable Long id, @RequestBody Cart cart) {
        return ResponseEntity.ok(cartService.updateCart(id, cart));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCart(@PathVariable Long id) {
        cartService.deleteCart(id);
        return ResponseEntity.ok("Cart deleted successfully");
    }
}
