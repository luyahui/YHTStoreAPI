package com.yhtart.service;

import com.yhtart.model.Material;
import com.yhtart.model.MaterialType;
import com.yhtart.repository.MaterialRepository;
import com.yhtart.repository.MaterialTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MaterialTypeService {
    @Autowired
    private MaterialTypeRepository materialTypeRepository;
    @Autowired
    private MaterialRepository materialRepository;

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
    public void delete(long id) throws Exception {
        long countProducts = materialTypeRepository.countProducts(id);
        if (countProducts != 0)
            throw new Exception("There are products belonging to this material type");

        List<Material> materials = materialTypeRepository.findById(id).get().getList();
        materialRepository.deleteAll(materials);
        materialTypeRepository.deleteById(id);
    }
}
