package com.yhtart.service;

import com.yhtart.model.Author;
import com.yhtart.model.AuthorLevel;
import com.yhtart.repository.AuthorLevelRepository;
import com.yhtart.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AuthorLevelService {

    @Autowired
    private AuthorLevelRepository authorLevelRepository;

    @Autowired
    private AuthorRepository authorRepository;

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

    public long countProducts(long id){
        return authorLevelRepository.countProducts(id);
    }

    @Transactional
    public void delete(long id) throws Exception {
        long countProducts = authorLevelRepository.countProducts(id);
        if(countProducts != 0)
            throw new Exception("There are products belonging to this author level.");
        List<Author> authors = authorLevelRepository.findById(id).get().getList();
        authorRepository.deleteAll(authors);
        authorLevelRepository.deleteById(id);
    }

    public boolean exists(long id) {
        return authorLevelRepository.existsById(id);
    }
}
