package com.cherpe.usecase;

import com.cherpe.product.Product;
import lombok.Data;

public interface ProductCreateUsecase {

    Product createProduct(Request request);

    @Data
    class Request {
        private final String name;
        private final String content;
        private final Long price;
        private final Long categoryId;
    }
}
