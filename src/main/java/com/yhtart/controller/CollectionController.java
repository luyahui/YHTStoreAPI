package com.yhtart.controller;

import com.yhtart.annotation.PassToken;
import com.yhtart.model.Collection;
import com.yhtart.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("collections")
public class CollectionController {

    @Autowired
    private CollectionService collectionService;

    @PassToken
    @GetMapping("")
    public ResponseEntity getAllCollections() {
        Iterable<Collection> collections = collectionService.findAll();

        return collections.iterator().hasNext() ? new ResponseEntity(collections, HttpStatus.OK) : new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCollection(@PathVariable long id) {
        Collection collection = collectionService.findByID(id);
        return collection == null ? new ResponseEntity(HttpStatus.NO_CONTENT) : ResponseEntity.ok(collection);
    }

    @PutMapping("/{id}")
    public ResponseEntity editCollection(@PathVariable long id, @RequestBody Collection collection) {
        if (!collectionService.exists(id))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        try {
            collection.setId(id);
            collection = collectionService.save(collection);
            if (collection != null)
                return ResponseEntity.ok(collection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    public ResponseEntity addCollection(@RequestBody Collection collection) {
        try {
            collection = collectionService.save(collection);
            if (collection != null)
                return new ResponseEntity(collection, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCollection(@PathVariable long id) {
        if (!collectionService.exists(id))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        try {
            collectionService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(null);
    }
}
