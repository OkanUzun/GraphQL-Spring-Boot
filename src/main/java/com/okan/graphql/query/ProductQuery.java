package com.okan.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.okan.graphql.domain.Product;
import com.okan.graphql.service.ProductService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductQuery implements GraphQLQueryResolver {

    private final ProductService productService;

    public ProductQuery(final ProductService productService) {
        this.productService = productService;
    }

    public List<Product> getProducts(final int count) {
        return getProductService().getAllProducts(count);
    }

    public Optional<Product> getProduct(final int id) {
        return getProductService().getProduct(id);
    }

    protected ProductService getProductService() {
        return productService;
    }
}
