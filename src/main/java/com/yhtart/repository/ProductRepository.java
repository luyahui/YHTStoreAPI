package com.yhtart.repository;

import com.yhtart.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends CrudRepository<Product, Long> {
    Page<Product> findAll(Pageable of);

    @Query(value = "select p from Product p where p.author.name like %:keyword% or p.name like %:keyword%")
    Page<Product> findByKeyword(@Param("keyword") String keyword, Pageable of);
}
