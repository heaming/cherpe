package com.cherpe.service;

import com.cherpe.product.ProductPort;
import com.cherpe.product.Product;
import com.cherpe.usecase.ProductDeleteUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ProductDeleteService implements ProductDeleteUsecase {
    private final ProductPort productPort;

    @Transactional
    @Override
    public Product delete(Request request) {
        Product product = productPort.findById(request.getProductId());

        if (product == null) return null;

        Product deletedProduct = product.delete();
        productPort.save(deletedProduct);

        return deletedProduct;
    }

}
