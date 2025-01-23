package com.cherpe.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Product { // 원천 데이터 관리

    private Long id;
    private String name;
    private String content;
    private Long price;
    private Long categoryId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public Product update(String name, String content, Long price, Long categoryId) {
        this.name = name;
        this.content = content;
        this.price = price;
        this.categoryId = categoryId;
        this.updatedAt = LocalDateTime.now();
        return this;
    }

    public Product delete() {
        LocalDateTime now = LocalDateTime.now();
        this.deletedAt = now;
        this.updatedAt = now;
        return this;
    }

    public Product unDelete() {
        this.deletedAt = null;
        this.updatedAt = LocalDateTime.now();
        return this;
    }

    public static Product generate(
            String name,
            String content,
            Long price,
            Long categoryId
    ) {
        LocalDateTime now = LocalDateTime.now();
        return new Product(
                null,
                name,
                content,
                price,
                categoryId,
                now,
                now,
                null
        );
    }
}
