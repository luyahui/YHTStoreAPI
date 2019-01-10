package com.yhtart.controller;

import com.yhtart.model.MaterialType;
import com.yhtart.service.MaterialTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("materialTypes")
public class MaterialTypeController {
    @Autowired
    private MaterialTypeService materialTypeService;

    @GetMapping
    public ResponseEntity getAllTypes() {
        Iterable<MaterialType> types = materialTypeService.findAll();
        return ResponseEntity.ok(types);
    }

    @GetMapping("/{id}")
    public ResponseEntity getType(@PathVariable(name = "id") long id) {
        MaterialType type = materialTypeService.findById(id);
        return type == null ? new ResponseEntity(HttpStatus.BAD_REQUEST) : ResponseEntity.ok(type);
    }

    @PutMapping("/{id}")
    public ResponseEntity editType(@PathVariable(name = "id") long id,
                                   @RequestBody MaterialType type) {
        if (!materialTypeService.exists(id))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        try {
            type.setId(id);
            type = materialTypeService.save(type);
            if (type != null)
                return ResponseEntity.ok(type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    public ResponseEntity addType(@RequestBody MaterialType type) {
        try {
            type = materialTypeService.save(type);
            if (type != null)
                return new ResponseEntity(type, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteType(@PathVariable(name = "id") long id) {
        if (!materialTypeService.exists(id))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        try {
            materialTypeService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(null);
    }
}
