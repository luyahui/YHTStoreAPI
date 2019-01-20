package com.yhtart.controller;

import com.yhtart.annotation.PassToken;
import com.yhtart.model.Product;
import com.yhtart.service.ProductService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping(path = "/goods")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PassToken
    @GetMapping("")
    public ResponseEntity getAllProducts(@RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
                                         @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
        Page<Product> products = productService.findAll(pageNo, pageSize);

        return products.hasContent() ? ResponseEntity.ok(products) : new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PassToken
    @GetMapping("/{id}")
    public ResponseEntity getProduct(@PathVariable long id) {
        Product product = productService.find(id);
        return product == null ? new ResponseEntity(HttpStatus.NO_CONTENT) : ResponseEntity.ok(product);
    }

    @PassToken
    @GetMapping("/search")
    public ResponseEntity searchProduct(@RequestParam(value = "keyword", defaultValue = "") String keyword,
                                        @RequestParam(value = "collection", defaultValue = "") String collection,
                                        @RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
                                        @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
        Page<Product> products;
        if (keyword.equals(""))
            products = productService.findAll(collection, pageNo, pageSize);
        else
            products = productService.findByKeyword(keyword, collection, pageNo, pageSize);
        return ResponseEntity.ok(products);
    }

    @PassToken
    @GetMapping("/author")
    public ResponseEntity searchByAuthor(@RequestParam(value = "keyword", defaultValue = "") String keyword,
                                         @RequestParam(value = "collection", defaultValue = "") String collection,
                                         @RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
                                         @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
        Page<Product> products;
        if (keyword.equals(""))
            products = productService.findAll(collection, pageNo, pageSize);
        else
            products = productService.findByAuthor(keyword, collection, pageNo, pageSize);
        return ResponseEntity.ok(products);
    }

    @PassToken
    @GetMapping("/material")
    public ResponseEntity searchByMaterial(@RequestParam(value = "keyword", defaultValue = "") String keyword,
                                           @RequestParam(value = "collection", defaultValue = "") String collection,
                                           @RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
                                           @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
        Page<Product> products;
        if (keyword.equals(""))
            products = productService.findAll(collection, pageNo, pageSize);
        else
            products = productService.findByMaterial(keyword, collection, pageNo, pageSize);
        return ResponseEntity.ok(products);
    }

    @PassToken
    @GetMapping("/type")
    public ResponseEntity searchByType(@RequestParam(value = "keyword", defaultValue = "") String keyword,
                                       @RequestParam(value = "collection", defaultValue = "") String collection,
                                       @RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
                                       @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
        Page<Product> products;
        if (keyword.equals(""))
            products = productService.findAll(collection, pageNo, pageSize);
        else
            products = productService.findByType(keyword, collection, pageNo, pageSize);
        return ResponseEntity.ok(products);
    }

    @PassToken
    @GetMapping("/num")
    public ResponseEntity searchByNum(@RequestParam(value = "keyword", defaultValue = "") String keyword,
                                      @RequestParam(value = "collection", defaultValue = "") String collection,
                                      @RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
                                      @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
        Page<Product> products;
        if (keyword.equals(""))
            products = productService.findAll(collection, pageNo, pageSize);
        else
            products = productService.findByNum(keyword, collection, pageNo, pageSize);
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

    @PatchMapping("/sell/{id}")
    public ResponseEntity sellProduct(@PathVariable long id, @RequestBody String json) {
        if (!productService.exists(id))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        try {
            JSONObject obj = new JSONObject(json);
            boolean sold = obj.getBoolean("sold");
            productService.sell(id, sold);
            return ResponseEntity.ok(null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
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
        try {
            productService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(null);
    }
}
