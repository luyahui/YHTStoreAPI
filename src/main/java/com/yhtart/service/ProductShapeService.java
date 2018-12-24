package com.yhtart.service;

import com.yhtart.model.ProductShape;
import com.yhtart.repository.ProductShapeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ProductShapeService {
    @Autowired
    private ProductShapeRepository productShapeRepository;

    public Iterable<ProductShape> getAll() {
        return productShapeRepository.findAll();
    }

    public ProductShape getById(long id) {
        return productShapeRepository.findById(id).orElse(null);
    }

    public boolean exists(long id) {
        return productShapeRepository.existsById(id);
    }

    @Transactional
    public ProductShape save(ProductShape shape) {
        return productShapeRepository.save(shape);
    }

    @Transactional
    public void delete(long id) {
        productShapeRepository.deleteById(id);
    }
}
