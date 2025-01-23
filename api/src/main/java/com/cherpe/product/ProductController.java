package com.cherpe.product;

import com.cherpe.usecase.ProductCreateUsecase;
import com.cherpe.usecase.ProductDeleteUsecase;
import com.cherpe.usecase.ProductReadUsecase;
import com.cherpe.usecase.ProductUpdateUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductCreateUsecase productCreateUsecase;
    private final ProductUpdateUsecase productUpdateUsecase;
    private final ProductReadUsecase productReadUsecase;
    private final ProductDeleteUsecase productDeleteUsecase;

    @PostMapping
    ResponseEntity<ProductDto> createProduct(@RequestBody ProductCreateRequest request) {
        Product product = productCreateUsecase.createProduct(
                new ProductCreateUsecase.Request(
                        request.getName(),
                        request.getContent(),
                        request.getPrice(),
                        request.getCategoryId()
                )
        );

        return ResponseEntity.ok().body(toDto(product));
    }

    @PutMapping("/{productId}")
    ResponseEntity<ProductDto> updateProdcut(@PathVariable Long productId, @RequestBody ProductUpdateRequest request) {
        Product product = productUpdateUsecase.update(
                new ProductUpdateUsecase.Request(
                        productId,
                        request.getName(),
                        request.getContent(),
                        request.getPrice(),
                        request.getCategoryId()
                )
        );

        if (product == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(toDto(product));
    }

    @GetMapping("/{productId}/detail")
    ResponseEntity<ProductDetailDto> getProduct(@PathVariable Long productId) {
        ResolvedProduct resolvedProduct = productReadUsecase.getById(productId);

        if (resolvedProduct == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(toDto(resolvedProduct));
    }

    @DeleteMapping("/{productId}")
    ResponseEntity<ProductDto> deleteProduct(@PathVariable Long productId) {
        Product product = productDeleteUsecase.delete(new ProductDeleteUsecase.Request(productId));

        if (product == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(toDto(product));
    }

    private ProductDto toDto(Product product) {
        return new ProductDto(
            product.getId(),
            product.getName(),
            product.getContent(),
            product.getPrice(),
            product.getCategoryId(),
            product.getCreatedAt(),
            product.getUpdatedAt(),
            product.getDeletedAt()
        );
    }

    private ProductDetailDto toDto(ResolvedProduct resolvedProduct) {
        return new ProductDetailDto(
                resolvedProduct.getId(),
                resolvedProduct.getName(),
                resolvedProduct.getContent(),
                resolvedProduct.getPrice(),
                resolvedProduct.getCategoryId(),
                resolvedProduct.getCategoryName(),
                resolvedProduct.getCreatedAt(),
                resolvedProduct.getUpdatedAt(),
                resolvedProduct.isUpdated()
        );
    }
}