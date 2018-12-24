package com.yhtart.service;

import com.yhtart.model.Material;
import com.yhtart.repository.MaterialRepository;
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
public class MaterialService {
    @Autowired
    private MaterialRepository materialRepository;

    public Page<Material> findAll(int pageNo, int pageSize) {
        return materialRepository.findAll(PageRequest.of(pageNo, pageSize));
    }

    public Material findById(long id) {
        return materialRepository.findById(id).orElse(null);
    }

    @Transactional
    public Material save(Material material) {
        return materialRepository.save(material);
    }

    public boolean exists(long id) {
        return materialRepository.existsById(id);
    }

    @Transactional
    public void delete(long id) {
        materialRepository.deleteById(id);
    }

    public Map<String, List<Material>> findAllByType() {
        Iterable<Material> materials = materialRepository.findAll();
        Map<String, List<Material>> map = new HashMap<>();
        for (Material material : materials) {
            String type = material.getType().getName();
            if (!map.containsKey(type))
                map.put(type, new ArrayList<>());
            map.get(type).add(material);
        }
        return map;
    }
}
