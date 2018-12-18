package com.yhtart.service;

import com.yhtart.model.ProductType;
import com.yhtart.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeService {
    @Autowired
    private ProductTypeRepository productTypeRepository;

    public Page<ProductType> findAll(int pageNo, int pageSize) {
        return productTypeRepository.findAll(PageRequest.of(pageNo, pageSize));
    }

    public ProductType findById(long id) {
        return productTypeRepository.findById(id).orElse(null);
    }

    public ProductType save(ProductType type) {
        return productTypeRepository.save(type);
    }

    public boolean exists(long id) {
        return productTypeRepository.existsById(id);
    }

    public void delete(long id) {
        productTypeRepository.deleteById(id);
    }
}
