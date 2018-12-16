package com.yhtart.repository;

import com.yhtart.model.Product;
import com.yhtart.model.Recommendation;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {

    @Query(value = "select r from Recommendation r where r.product.id = :product_id")
    Recommendation findByProductId(@Param("product_id") long product_id);

    @Transactional
    @Modifying
    @Query(value = "delete from Recommendation r where r.product.id = :product_id")
    void deleteByProductId(@Param("product_id") long product_id);
}
