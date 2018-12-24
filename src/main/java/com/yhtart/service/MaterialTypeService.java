package com.yhtart.service;

import com.yhtart.model.MaterialType;
import com.yhtart.repository.MaterialTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MaterialTypeService {
    @Autowired
    private MaterialTypeRepository materialTypeRepository;

    public Iterable<MaterialType> findAll() {
        return materialTypeRepository.findAll();
    }

    public MaterialType findById(long id) {
        return materialTypeRepository.findById(id).orElse(null);
    }

    public boolean exists(long id) {
        return materialTypeRepository.existsById(id);
    }

    @Transactional
    public MaterialType save(MaterialType type) {
        return materialTypeRepository.save(type);
    }

    @Transactional
    public void delete(long id) {
        materialTypeRepository.deleteById(id);
    }
}
