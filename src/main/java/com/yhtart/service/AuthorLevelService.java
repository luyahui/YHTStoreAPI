package com.yhtart.service;

import com.yhtart.model.AuthorLevel;
import com.yhtart.repository.AuthorLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AuthorLevelService {

    @Autowired
    private AuthorLevelRepository authorLevelRepository;

    public Iterable<AuthorLevel> findAll() {
        return authorLevelRepository.findAll();
    }

    public AuthorLevel findById(long id) {
        return authorLevelRepository.findById(id).orElse(null);
    }

    @Transactional
    public AuthorLevel save(AuthorLevel level) {
        return authorLevelRepository.save(level);
    }

    @Transactional
    public void delete(long id) {
        authorLevelRepository.deleteById(id);
    }

    public boolean exists(long id) {
        return authorLevelRepository.existsById(id);
    }
}
