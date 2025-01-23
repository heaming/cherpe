package com.cherpe.service;

import com.cherpe.product.ProductPort;
import com.cherpe.product.Product;
import com.cherpe.usecase.ProductUpdateUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductUpdateService implements ProductUpdateUsecase {

    private final ProductPort productPort;

    @Transactional
    @Override
    public Product update(Request request) {
        Product product = productPort.findById(request.getProductId());
        if (product == null) return null;

        product.update(
                request.getName(),
                request.getContent(),
                request.getPrice(),
                request.getCategoryId()
        );

        Product savedProduct = productPort.save(product);

        return savedProduct;
    }
}
