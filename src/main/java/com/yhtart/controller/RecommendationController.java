package com.yhtart.controller;

import com.yhtart.model.Recommendation;
import com.yhtart.service.ProductService;
import com.yhtart.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("recommendGoods")
public class RecommendationController {

    @Autowired
    private ProductService productService;
    @Autowired
    private RecommendationService recommendationService;

    @GetMapping
    public ResponseEntity getRecommendations() {
        return ResponseEntity.ok(recommendationService.findAll());
    }

    @PostMapping
    public ResponseEntity addRecommendation(@RequestBody Recommendation recommendation) {
        try {
            long product_id = recommendation.getProduct().getId();
            if (productService.exists(product_id)) {
                recommendation.setProduct(productService.find(product_id));
                recommendation = recommendationService.save(recommendation);
                return ResponseEntity.ok(recommendation.getProduct());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{product_id}")
    public ResponseEntity deleteRecommendation(@PathVariable long product_id) {
        if (!recommendationService.exists(product_id)) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        recommendationService.delete(product_id);
        return ResponseEntity.ok(null);
    }

}
