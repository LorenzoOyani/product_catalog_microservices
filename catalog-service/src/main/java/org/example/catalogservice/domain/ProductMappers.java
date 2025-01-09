package org.example.catalogservice.domain;

import org.springframework.stereotype.Component;

@Component
public class ProductMappers {

    public ProductEntity toEntity(Product product) {
        if ( product == null ) {
            return null;
        }
        ProductEntity productEntity = new ProductEntity();
        productEntity.setCode(product.getCode());
        productEntity.setName(product.getName());
        productEntity.setDescription(product.getDescription());
        productEntity.setPrice(product.getPrice());
        productEntity.setImageUrl(product.getImageUrl());
        return productEntity;

    }

    public Product toModel(ProductEntity productEntity) {
        if ( productEntity == null ) {
            return null;
        }
        Product product = new Product();
        product.setCode(productEntity.getCode());
        product.setName(productEntity.getName());
        product.setDescription(productEntity.getDescription());
        product.setPrice(productEntity.getPrice());
        product.setImageUrl(productEntity.getImageUrl());
        return product;
    }
}
