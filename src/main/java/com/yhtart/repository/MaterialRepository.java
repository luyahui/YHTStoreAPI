package com.yhtart.repository;

import com.yhtart.model.Material;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface MaterialRepository extends CrudRepository<Material, Long> {
    Page<Material> findAll(Pageable of);
}
