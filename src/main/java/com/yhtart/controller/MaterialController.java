package com.yhtart.controller;

import com.yhtart.model.Material;
import com.yhtart.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "materials")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @GetMapping("")
    public ResponseEntity getAllMaterials(@RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
                                          @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
        Page<Material> materials = materialService.findAll(pageNo, pageSize);

        return materials.hasContent() ? ResponseEntity.ok(materials) : new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity getMaterial(@PathVariable(value = "id") long id) {
        Material material = materialService.findById(id);
        return material != null ? ResponseEntity.ok(material) : new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping("")
    public ResponseEntity addMaterial(@RequestBody Material material) {
        try {
            material = materialService.save(material);
            return new ResponseEntity(material, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity editMaterial(@PathVariable(value = "id") long id, @RequestBody Material material){
        try{
            if(!materialService.exists(id))
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            material.setId(id);
            return ResponseEntity.ok(material);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMaterial(@PathVariable(value = "id") long id){
        if(!materialService.exists(id))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        materialService.delete(id);
        return ResponseEntity.ok(null);
    }
}
