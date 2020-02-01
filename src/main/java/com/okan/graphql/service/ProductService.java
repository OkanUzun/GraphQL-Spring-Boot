package com.okan.graphql.service;

import com.okan.graphql.domain.Product;
import com.okan.graphql.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public Product createProduct(final String code, final String name, final Integer maxSellableQuantity, final BigDecimal price) {
        final Product product = new Product();
        product.setCode(code);
        product.setName(name);
        product.setMaxSellableQuantity(maxSellableQuantity);
        product.setPrice(price);
        return getProductRepository().save(product);
    }

    @Transactional(readOnly = true)
    public List<Product> getAllProducts(final int count) {
        return getProductRepository().findAll().stream().limit(count).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<Product> getProduct(final int id) {
        return getProductRepository().findById(id);
    }

    protected ProductRepository getProductRepository() {
        return productRepository;
    }
}
