package com.yhtart.service;

import com.yhtart.model.ProductType;
import com.yhtart.repository.ProductTypeRepository;
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
public class ProductTypeService {
    @Autowired
    private ProductTypeRepository productTypeRepository;

    public Page<ProductType> findAll(int pageNo, int pageSize) {
        return productTypeRepository.findAll(PageRequest.of(pageNo, pageSize));
    }

    public Iterable<ProductType> findAll() {
        return productTypeRepository.findAll();
    }

    public ProductType findById(long id) {
        return productTypeRepository.findById(id).orElse(null);
    }

    @Transactional
    public ProductType save(ProductType type) {
        return productTypeRepository.save(type);
    }

    public boolean exists(long id) {
        return productTypeRepository.existsById(id);
    }

    @Transactional
    public void delete(long id) {
        productTypeRepository.deleteById(id);
    }

    public Map<String, List<ProductType>> findAllByShape() {
        Map<String, List<ProductType>> map = new HashMap<>();
        Iterable<ProductType> types = productTypeRepository.findAll();

        for(ProductType type : types){
            String shape = type.getShape().getShape();
            if(!map.containsKey(shape))
                map.put(shape, new ArrayList<>());
            map.get(shape).add(type);
        }

        return map;
    }

}
