package com.cherpe.usecase;

import com.cherpe.product.Product;
import lombok.Data;

public interface ProductUpdateUsecase {
    Product update(Request request);

    @Data
    class Request {
        private final Long productId;
        private final String name;
        private final String content;
        private final Long price;
        private final Long categoryId;
    }
}
