package com.cherpe.product;

import java.util.List;

public interface ProductPort {

    Product save(Product product);
    Product findById(Long id);
    List<Product> listByIds(List<Long> ids);
}
