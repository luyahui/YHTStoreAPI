package com.yhtart.controller;

import com.yhtart.annotation.PassToken;
import com.yhtart.model.Author;
import com.yhtart.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PassToken
    @GetMapping("")
    public ResponseEntity getAllAuthors(@RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
                                        @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
        Page<Author> authors = authorService.findAll(pageNo, pageSize);

        return authors.hasContent() ? new ResponseEntity(authors, HttpStatus.OK) : new ResponseEntity(HttpStatus.NO_CONTENT);
    }
//
//    @GetMapping("/levels")
//    public ResponseEntity getAuthorsByLevel(){
//        Map<String, List<Author>> authors = authorService.findAllByLevel();
//        return ResponseEntity.ok(authors);
//    }

    @PassToken
    @GetMapping("/{id}")
    public ResponseEntity getAuthor(@PathVariable long id) {
        Author author = authorService.findByID(id);
        return author == null ? new ResponseEntity(HttpStatus.NO_CONTENT) : ResponseEntity.ok(author);
    }

    @PutMapping("/{id}")
    public ResponseEntity editAuthor(@PathVariable long id, @RequestBody Author author) {
        if (!authorService.exists(id))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        try {
            author.setId(id);
            author = authorService.save(author);
            if (author != null)
                return ResponseEntity.ok(author);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    public ResponseEntity addAuthor(@RequestBody Author author) {
        try {
            author = authorService.save(author);
            if (author != null)
                return new ResponseEntity(author, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAuthor(@PathVariable long id) {
        if (!authorService.exists(id))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        try {
            authorService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(null);
    }
}
