package com.yhtart.service;

import com.yhtart.model.Material;
import com.yhtart.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class MaterialService {
    @Autowired
    private MaterialRepository materialRepository;

    public Page<Material> findAll(int pageNo, int pageSize) {
        return materialRepository.findAll(PageRequest.of(pageNo, pageSize));
    }

    public Material findById(long id) {
        return materialRepository.findById(id).orElse(null);
    }

    public Material save(Material material) {
        return materialRepository.save(material);
    }

    public boolean exists(long id) {
        return materialRepository.existsById(id);
    }

    public void delete(long id) {
        materialRepository.deleteById(id);
    }
}
