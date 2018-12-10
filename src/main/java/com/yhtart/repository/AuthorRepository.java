package com.yhtart.repository;

import com.yhtart.model.Author;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
