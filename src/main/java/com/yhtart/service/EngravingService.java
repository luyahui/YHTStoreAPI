package com.yhtart.service;

import com.yhtart.model.Engraving;
import com.yhtart.repository.EngravingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EngravingService {
    @Autowired
    private EngravingRepository engravingRepository;

    public Page<Engraving> findAll(int pageNo, int pageSize) {
        return engravingRepository.findAll(PageRequest.of(pageNo, pageSize));
    }

    public Engraving findByID(long id) {
        return engravingRepository.findById(id).orElse(null);
    }

    public boolean exists(long id) {
        return engravingRepository.existsById(id);
    }

    @Transactional
    public Engraving save(Engraving engraving) {
        return engravingRepository.save(engraving);
    }

    @Transactional
    public void delete(long id) {
        engravingRepository.deleteById(id);
    }
}
