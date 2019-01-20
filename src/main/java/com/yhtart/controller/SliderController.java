package com.yhtart.controller;

import com.yhtart.annotation.PassToken;
import com.yhtart.model.Slider;
import com.yhtart.service.SliderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping("sliderList")
public class SliderController {
    @Autowired
    private SliderService sliderService;

    @PassToken
    @GetMapping
    public ResponseEntity getSliderList() {
        Iterable<Slider> sliderList = sliderService.findAll();
        return ResponseEntity.ok(sliderList);
    }

    @PostMapping
    public ResponseEntity addSlider(@RequestBody Slider slider) {
        try {
            slider.setDate(new Date(System.currentTimeMillis()));
            slider = sliderService.save(slider);
            if (slider != null)
                return new ResponseEntity(slider, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity editSlider(@PathVariable long id, @RequestBody Slider slider) {
        if (!sliderService.exists(id))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        try {
            slider.setId(id);
            slider.setDate(new Date(System.currentTimeMillis()));
            slider = sliderService.save(slider);
            if (slider != null)
                return new ResponseEntity(slider, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        if (!sliderService.exists(id))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        try {
            sliderService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(null);
    }
}
