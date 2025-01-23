package com.cherpe.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResolvedProduct {
    private Long id;
    private String name;
    private String content;
    private Long price;
    private Long categoryId;
    private String categoryName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean updated;

    public static ResolvedProduct generate(Product product, String categoryName) {
        return new ResolvedProduct(
                product.getId(),
                product.getName(),
                product.getContent(),
                product.getPrice(),
                product.getCategoryId(),
                categoryName,
                product.getCreatedAt(),
                product.getUpdatedAt(),
                !product.getCreatedAt().equals(product.getUpdatedAt())
        );
    }
}
