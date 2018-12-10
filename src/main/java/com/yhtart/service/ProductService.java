package com.yhtart.service;

import com.yhtart.model.Author;
import com.yhtart.model.Product;
import com.yhtart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public Product save(Product p){
        return productRepository.save(p);
    }

    public Page<Product> findAll(int pageNo, int pageSize) {
        return productRepository.findAll(PageRequest.of(pageNo, pageSize));
    }
}