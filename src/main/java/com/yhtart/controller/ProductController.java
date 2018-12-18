package com.yhtart.controller;

import com.yhtart.model.Product;
import com.yhtart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.sql.Date;

@RestController
@RequestMapping(path = "/goods")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public ResponseEntity getAllProducts(@RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
                                         @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
        Page<Product> products = productService.findAll(pageNo, pageSize);

        return products.hasContent() ? ResponseEntity.ok(products) : new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity getProduct(@PathVariable long id) {
        Product product = productService.find(id);
        return product == null ? new ResponseEntity(HttpStatus.NO_CONTENT) : ResponseEntity.ok(product);
    }

    @GetMapping("/search")
    public ResponseEntity searchProduct(@PathParam("keyword") String keyword,
                                        @RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
                                        @RequestParam(name = "pageSize", defaultValue = "10") int pageSize){
        Page<Product> products;
        if(keyword.equals(""))
            products = productService.findAll(pageNo, pageSize);
        else
            products = productService.findByKeyword(keyword, pageNo, pageSize);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/author")
    public ResponseEntity searchByAuthor(@PathParam("keyword") String keyword,
                                        @RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
                                        @RequestParam(name = "pageSize", defaultValue = "10") int pageSize){
        Page<Product> products;
        if(keyword.equals(""))
            products = productService.findAll(pageNo, pageSize);
        else
            products = productService.findByAuthor(keyword, pageNo, pageSize);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/material")
    public ResponseEntity searchByMaterial(@PathParam("keyword") String keyword,
                                         @RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
                                         @RequestParam(name = "pageSize", defaultValue = "10") int pageSize){
        Page<Product> products;
        if(keyword.equals(""))
            products = productService.findAll(pageNo, pageSize);
        else
            products = productService.findByMaterial(keyword, pageNo, pageSize);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/type")
    public ResponseEntity searchByType(@PathParam("keyword") String keyword,
                                         @RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
                                         @RequestParam(name = "pageSize", defaultValue = "10") int pageSize){
        Page<Product> products;
        if(keyword.equals(""))
            products = productService.findAll(pageNo, pageSize);
        else
            products = productService.findByType(keyword, pageNo, pageSize);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/num")
    public ResponseEntity searchByNum(@PathParam("keyword") String keyword,
                                       @RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
                                       @RequestParam(name = "pageSize", defaultValue = "10") int pageSize){
        Page<Product> products;
        if(keyword.equals(""))
            products = productService.findAll(pageNo, pageSize);
        else
            products = productService.findByNum(keyword, pageNo, pageSize);
        return ResponseEntity.ok(products);
    }

    @PutMapping("/{id}")
    public ResponseEntity editProduct(@PathVariable long id, @RequestBody Product product) {
        if (!productService.exists(id))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        try {
            product.setId(id);
            product.setDate(new Date(System.currentTimeMillis()));
            if (productService.save(product) != null)
                return ResponseEntity.ok(product);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("")
    public ResponseEntity addProduct(@RequestBody Product product) {

        try {
            product.setDate(new Date(System.currentTimeMillis()));
            product.setClicks(0);
            product = productService.save(product);
            if (product != null)
                return new ResponseEntity(product, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable long id) {
        if (!productService.exists(id))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        productService.delete(id);
        return ResponseEntity.ok(null);
    }
}
