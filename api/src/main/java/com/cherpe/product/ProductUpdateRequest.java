package com.cherpe.product;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductUpdateRequest {
    private String name;
    private String content;
    private Long price;
    private Long categoryId;
}
