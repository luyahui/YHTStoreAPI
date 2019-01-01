package com.yhtart.service;

import com.yhtart.model.Collection;
import com.yhtart.repository.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CollectionService {

    @Autowired
    private CollectionRepository collectionRepository;

    public Iterable<Collection> findAll() {
        return collectionRepository.findAll();
    }

    public Collection findByID(long id) {
        return collectionRepository.findById(id).orElse(null);
    }

    public boolean exists(long id) {
        return collectionRepository.existsById(id);
    }

    @Transactional
    public Collection save(Collection collection) {
        return collectionRepository.save(collection);
    }

    @Transactional
    public void delete(long id) {
        collectionRepository.deleteById(id);
    }
}
