package com.yhtart.repository;

import com.yhtart.model.AuthorLevel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AuthorLevelRepository extends CrudRepository<AuthorLevel, Long> {

    @Query(value = "select count(*) from product where product.author_id in (select id from author where level_id = :id)",
            nativeQuery = true)
    long countProducts(@Param("id") long id);
}
