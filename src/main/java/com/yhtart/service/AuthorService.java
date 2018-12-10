package com.yhtart.service;

import com.yhtart.model.Author;
import com.yhtart.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public Author save(Author a){
        return authorRepository.save(a);
    }
}
