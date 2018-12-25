package com.yhtart.repository;

import com.yhtart.model.Engraving;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface EngravingRepository extends CrudRepository<Engraving, Long> {
    Page<Engraving> findAll(Pageable of);
}
