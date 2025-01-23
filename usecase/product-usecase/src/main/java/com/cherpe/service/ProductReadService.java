package com.cherpe.service;

import com.cherpe.product.ProductPort;
import com.cherpe.product.ResolvedProduct;
import com.cherpe.usecase.ProductReadUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductReadService implements ProductReadUsecase {

    private final ProductPort productPort;

    @Override
    public ResolvedProduct getById(Long productId) {
        return ResolvedProduct.generate(productPort.findById(productId), "categoryName");
    }
}
