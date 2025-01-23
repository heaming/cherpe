package com.cherpe.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.cherpe.product.ProductConverter.toEntity;
import static com.cherpe.product.ProductConverter.toModel;

@RequiredArgsConstructor
@Component
public class ProductAdapter implements ProductPort {

    private final ProductJpaRepository productJpaRepository;

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = productJpaRepository.save(toEntity(product));
        return toModel(productEntity);
    }

    @Override
    public Product findById(Long id) {
        ProductEntity productEntity = productJpaRepository.findById(id).orElse(null);

        if (productEntity == null) {
            return null;
        }
        return toModel(productEntity);
    }

    @Override
    public List<Product> listByIds(List<Long> ids) {
        List<ProductEntity> productEntities = productJpaRepository.findAllById(ids);
        return productEntities.stream().map(ProductConverter::toModel).toList();
    }
}
