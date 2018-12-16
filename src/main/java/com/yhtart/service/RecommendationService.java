package com.yhtart.service;

import com.yhtart.model.Product;
import com.yhtart.model.Recommendation;
import com.yhtart.repository.ProductRepository;
import com.yhtart.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecommendationService {

    @Autowired
    private RecommendationRepository recommendationRepository;
//
//    @Autowired
//    private ProductRepository productRepository;

    public Recommendation save(Recommendation recommendation) {
        return recommendationRepository.save(recommendation);
    }

    public boolean exists(long product_id) {
        return recommendationRepository.findByProductId(product_id) != null;
    }

    public void delete(long product_id) {
        recommendationRepository.deleteByProductId(product_id);
    }

    public Iterable<Recommendation> findAll() {
        return recommendationRepository.findAll();
    }
}
