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
    public Product save(Product p) {
        return productRepository.save(p);
    }

    public Page<Product> findAll(int pageNo, int pageSize) {
        return productRepository.findAll(PageRequest.of(pageNo, pageSize));
    }

    public Page<Product> findAll(String collection, int pageNo, int pageSize) {
        return productRepository.findAll(collection, PageRequest.of(pageNo, pageSize));
    }

    public Product find(long id) {
        return productRepository.findById(id).orElse(null);
    }

    public boolean exists(long id) {
        return productRepository.existsById(id);
    }

    @Transactional
    public void delete(long id) {
        productRepository.deleteById(id);
    }

    public Page<Product> findByKeyword(String keyword, String collection, int pageNo, int pageSize) {
        return productRepository.findByKeyword(keyword, collection, PageRequest.of(pageNo, pageSize));
    }

    public Page<Product> findByAuthor(String keyword, String collection, int pageNo, int pageSize) {
        return productRepository.findByAuthor(keyword, collection, PageRequest.of(pageNo, pageSize));
    }

    public Page<Product> findByMaterial(String keyword, String collection, int pageNo, int pageSize) {
        return productRepository.findByMaterial(keyword, collection, PageRequest.of(pageNo, pageSize));
    }

    public Page<Product> findByType(String keyword, String collection, int pageNo, int pageSize) {
        return productRepository.findByType(keyword, collection, PageRequest.of(pageNo, pageSize));
    }

    public Page<Product> findByNum(String keyword, String collection, int pageNo, int pageSize) {
        return productRepository.findByNum(keyword, collection, PageRequest.of(pageNo, pageSize));
    }

    public void sell(long id) {
        productRepository.sell(id);
    }
}
