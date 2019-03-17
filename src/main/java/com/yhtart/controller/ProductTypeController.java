package com.yhtart.controller;

import com.yhtart.annotation.PassToken;
import com.yhtart.model.ProductType;
import com.yhtart.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "types")
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    //    @PassToken
//    @GetMapping("")
//    public ResponseEntity getAllTypes(@RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
//                                      @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
//        Page<ProductType> types = productTypeService.findAll(pageNo, pageSize);
//        return types.hasContent() ? ResponseEntity.ok(types) : new ResponseEntity(HttpStatus.NO_CONTENT);
//    }
    @PassToken
    @GetMapping("")
    public ResponseEntity getAllTypes() {
        Iterable<ProductType> types = productTypeService.findAll();
        return types.iterator().hasNext() ? ResponseEntity.ok(types) : new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PassToken
    @GetMapping("/{id}")
    public ResponseEntity getType(@PathVariable(value = "id") long id) {
        ProductType type = productTypeService.findById(id);
        return type != null ? ResponseEntity.ok(type) : new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping("")
    public ResponseEntity addType(@RequestBody ProductType type) {
        try {
            type = productTypeService.save(type);
            if (type != null)
                return new ResponseEntity(type, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity editType(@PathVariable(value = "id") long id, @RequestBody ProductType type) {
        if (!productTypeService.exists(id))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);

        try {
            type.setId(id);
            type = productTypeService.save(type);
            if (type != null)
                return ResponseEntity.ok(type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteType(@PathVariable(value = "id") long id) {
        if (!productTypeService.exists(id))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        try {
            productTypeService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(null);
    }
}
