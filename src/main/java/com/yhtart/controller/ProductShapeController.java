package com.yhtart.controller;

import com.yhtart.model.ProductShape;
import com.yhtart.service.ProductShapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("shapes")
public class ProductShapeController {

    @Autowired
    private ProductShapeService productShapeService;

    @GetMapping
    public ResponseEntity getAllShapes() {
        Iterable<ProductShape> shapes = productShapeService.getAll();
        return ResponseEntity.ok(shapes);
    }

    @GetMapping("/{id}")
    public ResponseEntity getShape(@PathVariable(name = "id") long id) {
        ProductShape shape = productShapeService.getById(id);
        return shape == null ? new ResponseEntity(HttpStatus.NO_CONTENT) : ResponseEntity.ok(shape);
    }

    @PutMapping("/{id}")
    public ResponseEntity editShape(@PathVariable(name = "id") long id,
                                    @RequestBody ProductShape shape) {
        if (!productShapeService.exists(id))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        try {
            shape.setId(id);
            shape = productShapeService.save(shape);
            if (shape != null)
                return ResponseEntity.ok(shape);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    public ResponseEntity addShape(@RequestBody ProductShape shape) {
        try {
            shape = productShapeService.save(shape);
            if (shape != null)
                return new ResponseEntity(shape, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteType(@PathVariable(name = "id") long id){
        if(!productShapeService.exists(id))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        productShapeService.delete(id);
        return ResponseEntity.ok(null);
    }
}
