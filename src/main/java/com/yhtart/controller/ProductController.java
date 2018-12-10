package com.yhtart.controller;

import com.yhtart.model.Product;
import com.yhtart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

//    @GetMapping(path = "/hello")
//    public String hello(){
//        return "hello world";
//    }

    @GetMapping("")
    public ResponseEntity getAllProducts(@RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
                                         @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
        Page<Product> products = productService.findAll(pageNo, pageSize);

        return products.hasContent() ? ResponseEntity.ok(products) : new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
