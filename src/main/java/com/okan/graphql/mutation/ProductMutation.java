package com.okan.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.okan.graphql.domain.Product;
import com.okan.graphql.service.ProductService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductMutation implements GraphQLMutationResolver {

    private final ProductService productService;

    public ProductMutation(final ProductService productService) {
        this.productService = productService;
    }

    public Product createProduct(final String code, final String name, final Integer maxSellableQuantity, final BigDecimal price) {
        return getProductService().createProduct(code, name, maxSellableQuantity, price);
    }

    protected ProductService getProductService() {
        return productService;
    }
}
