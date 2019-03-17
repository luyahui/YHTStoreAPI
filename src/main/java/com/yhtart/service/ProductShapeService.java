package com.yhtart.service;

import com.yhtart.model.ProductShape;
import com.yhtart.model.ProductType;
import com.yhtart.repository.ProductShapeRepository;
import com.yhtart.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductShapeService {
    @Autowired
    private ProductShapeRepository productShapeRepository;

    @Autowired
    private ProductTypeRepository productTypeRepository;

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
    public void delete(long id) throws Exception {
        long countProducts = productShapeRepository.countProducts(id);
        if(countProducts != 0)
            throw new Exception("There are products belonging to this shape.");
        List<ProductType> types = productShapeRepository.findById(id).get().getList();
        productTypeRepository.deleteAll(types);
        productShapeRepository.deleteById(id);
    }
}
