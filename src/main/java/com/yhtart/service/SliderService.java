package com.yhtart.service;

import com.yhtart.model.Slider;
import com.yhtart.repository.SliderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SliderService {
    @Autowired
    private SliderRepository sliderRepository;

    public Iterable<Slider> findAll() {
        return sliderRepository.findAll();
    }

    public Slider save(Slider slider) {
        return sliderRepository.save(slider);
    }

    public boolean exists(long id) {
        return sliderRepository.existsById(id);
    }

    public void delete(long id) {
        sliderRepository.deleteById(id);
    }
}
