package com.yhtart.repository;

import com.yhtart.model.MaterialType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MaterialTypeRepository extends CrudRepository<MaterialType, Long> {

    @Query(value = "SELECT COUNT(*) FROM product\n WHERE product.material_id IN (SELECT id FROM material WHERE type_id = :id)", nativeQuery = true)
    long countProducts(@Param("id") long id);
}
