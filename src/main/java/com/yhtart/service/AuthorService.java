package com.yhtart.service;

import com.yhtart.model.Author;
import com.yhtart.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public Author save(Author a){
        return authorRepository.save(a);
    }

    public Author findByID(long id){
        return authorRepository.findById(id).orElse(null);
    }

    public Page<Author> findAll(int pageNo, int pageSize) {
        return authorRepository.findAll(PageRequest.of(pageNo, pageSize));
    }

    public boolean exists(long id) {
        return authorRepository.existsById(id);
    }

    public void delete(long id) {
        authorRepository.deleteById(id);
    }
}
