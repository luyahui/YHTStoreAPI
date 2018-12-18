package com.yhtart.repository;

import com.yhtart.model.ProductType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ProductTypeRepository extends CrudRepository<ProductType, Long> {
    Page<ProductType> findAll(Pageable of);
}
