package com.cherpe.usecase;

import com.cherpe.product.ResolvedProduct;

public interface ProductReadUsecase {
    ResolvedProduct getById(Long productId);
}
