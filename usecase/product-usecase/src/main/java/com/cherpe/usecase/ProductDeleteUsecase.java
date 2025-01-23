package com.cherpe.usecase;

import com.cherpe.product.Product;
import lombok.Data;

public interface ProductDeleteUsecase {

    Product delete(Request request);

    @Data
    class Request {
        private final Long productId;
    }
}
