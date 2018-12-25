package com.yhtart.controller;

import com.yhtart.model.Engraving;
import com.yhtart.service.EngravingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("engravings")
public class EngravingController {

    @Autowired
    private EngravingService engravingService;

    @GetMapping("")
    public ResponseEntity getAllAuthors(@RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
                                        @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
        Page<Engraving> engravings = engravingService.findAll(pageNo, pageSize);

        return engravings.hasContent() ? new ResponseEntity(engravings, HttpStatus.OK) : new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity getAuthor(@PathVariable long id){
        Engraving engraving = engravingService.findByID(id);
        return engraving == null ? new ResponseEntity(HttpStatus.NO_CONTENT) : ResponseEntity.ok(engraving);
    }

    @PutMapping("/{id}")
    public ResponseEntity editAuthor(@PathVariable long id, @RequestBody Engraving engraving){
        if(!engravingService.exists(id))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        try{
            engraving.setId(id);
            engraving = engravingService.save(engraving);
            if(engraving != null)
                return ResponseEntity.ok(engraving);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    public ResponseEntity addAuthor(@RequestBody Engraving engraving){
        try{
            engraving = engravingService.save(engraving);
            if(engraving != null)
                return new ResponseEntity(engraving, HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAuthor(@PathVariable long id){
        if(!engravingService.exists(id))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        engravingService.delete(id);
        return ResponseEntity.ok(null);
    }
}
