package com.yhtart.service;

import com.yhtart.model.Author;
import com.yhtart.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Transactional
    public Author save(Author a) {
        return authorRepository.save(a);
    }

    public Author findByID(long id) {
        return authorRepository.findById(id).orElse(null);
    }

    public Page<Author> findAll(int pageNo, int pageSize) {
        return authorRepository.findAll(PageRequest.of(pageNo, pageSize));
    }

    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }

    public boolean exists(long id) {
        return authorRepository.existsById(id);
    }

    @Transactional
    public void delete(long id) {
        authorRepository.deleteById(id);
    }

    public Map<String, List<Author>> findAllByLevel() {
        Map<String, List<Author>> map = new HashMap<>();
        Iterable<Author> authors = authorRepository.findAll();
        for (Author author : authors) {
            String title = author.getLevel().getTitle();
            if (!map.containsKey(title))
                map.put(title, new ArrayList<>());
            map.get(title).add(author);
        }
        return map;
    }

}
