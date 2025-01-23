package com.cherpe.service;

import com.cherpe.product.ProductPort;
import com.cherpe.product.Product;
import com.cherpe.usecase.ProductCreateUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ProductCreateService implements ProductCreateUsecase {

    private final ProductPort productPort;

    @Transactional
    @Override
    public Product createProduct(Request request) {

        Product product = productPort.save(
                Product.generate(
                        request.getName(),
                        request.getContent(),
                        request.getPrice(),
                        request.getCategoryId()
                )
        );

        return product;
    }
}
