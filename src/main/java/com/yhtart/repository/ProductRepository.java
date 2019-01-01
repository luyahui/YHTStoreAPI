package com.yhtart.repository;

import com.yhtart.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends CrudRepository<Product, Long> {
    Page<Product> findAll(Pageable of);

    @Query(value = "select p from Product  p where p.collection.name like %:collection%")
    Page<Product> findAll(@Param("collection") String collection, Pageable of);

    @Query(value = "select p from Product p where p.name like %:keyword% and p.collection.name like %:collection%")
    Page<Product> findByKeyword(@Param("keyword") String keyword, @Param("collection") String collection, Pageable of);

    @Query(value = "select p from Product p where p.author.name like %:keyword% and p.collection.name like %:collection%")
    Page<Product> findByAuthor(@Param("keyword") String keyword, @Param("collection") String collection, Pageable of);

    @Query(value = "select p from Product p where p.material.material like %:keyword% and p.collection.name like %:collection%")
    Page<Product> findByMaterial(@Param("keyword") String keyword, @Param("collection") String collection, Pageable of);

    @Query(value = "select p from Product p where p.type.type like %:keyword% and p.collection.name like %:collection%")
    Page<Product> findByType(@Param("keyword") String keyword, @Param("collection") String collection, Pageable of);

    @Query(value = "select p from Product p where p.num like %:keyword% and p.collection.name like %:collection%")
    Page<Product> findByNum(@Param("keyword") String keyword, @Param("collection") String collection, Pageable of);
}
