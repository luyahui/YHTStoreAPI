package com.yhtart.repository;

import com.yhtart.model.ProductShape;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductShapeRepository extends CrudRepository<ProductShape, Long> {
    @Query(value = "SELECT COUNT(*) FROM product WHERE product.type_id IN (SELECT id FROM product_type WHERE shape_id = 36)",
            nativeQuery = true)
    long countProducts(long id);
}
