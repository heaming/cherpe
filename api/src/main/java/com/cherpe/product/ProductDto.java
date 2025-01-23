package com.cherpe.product;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductDto {
    private final Long id;
    private final String name;
    private final String content;
    private final Long price;
    private final Long categoryId;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final LocalDateTime deletedAt;
}
