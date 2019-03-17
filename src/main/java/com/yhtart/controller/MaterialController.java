package com.yhtart.controller;

import com.yhtart.annotation.PassToken;
import com.yhtart.model.Material;
import com.yhtart.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "materials")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

//    @PassToken
//    @GetMapping("")
//    public ResponseEntity getAllMaterials(@RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
//                                          @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
//        Page<Material> materials = materialService.findAll(pageNo, pageSize);
//
//        return materials.hasContent() ? ResponseEntity.ok(materials) : new ResponseEntity(HttpStatus.NO_CONTENT);
//    }
    @PassToken
    @GetMapping("")
    public ResponseEntity getAllMaterials() {
        Iterable<Material> materials = materialService.findAll();
        return materials.iterator().hasNext() ? ResponseEntity.ok(materials) : new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PassToken
    @GetMapping("/{id}")
    public ResponseEntity getMaterial(@PathVariable(value = "id") long id) {
        Material material = materialService.findById(id);
        return material != null ? ResponseEntity.ok(material) : new ResponseEntity(HttpStatus.NO_CONTENT);
    }

//    @GetMapping("/types")
//    public ResponseEntity getMaterialsByType(){
//        Map<String, List<Material>> materials = materialService.findAllByType();
//        return ResponseEntity.ok(materials);
//    }

    @PostMapping("")
    public ResponseEntity addMaterial(@RequestBody Material material) {
        try {
            material = materialService.save(material);
            if (material != null)
                return new ResponseEntity(material, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity editMaterial(@PathVariable(value = "id") long id, @RequestBody Material material) {
        if (!materialService.exists(id))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        try {
            material.setId(id);
            material = materialService.save(material);
            if (material != null)
                return ResponseEntity.ok(material);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMaterial(@PathVariable(value = "id") long id) {
        if (!materialService.exists(id))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        try {
            materialService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(null);
    }
}
