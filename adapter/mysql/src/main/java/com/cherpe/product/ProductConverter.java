package com.cherpe.product;

public class ProductConverter {
    public static Product toModel(ProductEntity productEntity) {
        return new Product(
                productEntity.getId(),
                productEntity.getName(),
                productEntity.getContent(),
                productEntity.getPrice(),
                productEntity.getCategoryId(),
                productEntity.getCreatedAt(),
                productEntity.getUpdatedAt(),
                productEntity.getDeletedAt()
        );

    }

    public static ProductEntity toEntity(Product product) {
        return new ProductEntity(
                product.getId(),
                product.getName(),
                product.getContent(),
                product.getPrice(),
                product.getCategoryId(),
                product.getCreatedAt(),
                product.getUpdatedAt(),
                product.getDeletedAt()
        );
    }

}
