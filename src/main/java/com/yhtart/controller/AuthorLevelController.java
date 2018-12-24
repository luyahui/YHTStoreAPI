package com.yhtart.controller;

import com.yhtart.model.AuthorLevel;
import com.yhtart.service.AuthorLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("levels")
public class AuthorLevelController {

    @Autowired
    private AuthorLevelService authorLevelService;

    @GetMapping
    public ResponseEntity getAllLevels() {
        Iterable<AuthorLevel> levels = authorLevelService.findAll();
        return ResponseEntity.ok(levels);
    }

    @GetMapping("/{id}")
    public ResponseEntity getLevel(@PathVariable(name = "id") long id) {
        AuthorLevel level = authorLevelService.findById(id);
        if (level == null)
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return ResponseEntity.ok(level);
    }

    @PutMapping("/{id}")
    public ResponseEntity editLevel(@PathVariable(name = "id") long id, @RequestBody AuthorLevel level) {
        if (!authorLevelService.exists(id))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        try {
            level.setId(id);
            level = authorLevelService.save(level);
            if (level != null)
                return ResponseEntity.ok(level);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    public ResponseEntity addLevel(@RequestBody AuthorLevel level) {
        try {
            level = authorLevelService.save(level);
            if (level != null)
                return new ResponseEntity(level, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteLevel(@PathVariable("id") long id) {
        if (!authorLevelService.exists(id))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        authorLevelService.delete(id);
        return ResponseEntity.ok(null);
    }
}
