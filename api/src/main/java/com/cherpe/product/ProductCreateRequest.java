package com.cherpe.product;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ProductCreateRequest {
    private String name;
    private String content;
    private Long price;
    private Long categoryId;
}
