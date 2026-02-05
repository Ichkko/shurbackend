package com.example.shure.service.ipml;

import com.example.shure.model.Product;
import com.example.shure.repository.ProductRepository;
import com.example.shure.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceIpml implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceIpml(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        existing.setName(product.getName());
        existing.setDescription(product.getDescription());
        existing.setPrice(product.getPrice());
        existing.setImage(product.getImage());
        existing.setCategory(product.getCategory());
        existing.setStock(product.getStock());

        return productRepository.save(existing);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
