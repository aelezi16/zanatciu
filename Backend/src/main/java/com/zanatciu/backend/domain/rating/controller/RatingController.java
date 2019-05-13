package com.zanatciu.backend.domain.rating.controller;

import com.zanatciu.backend.domain.rating.dto.RatingDto;
import com.zanatciu.backend.domain.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    private RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService){
        this.ratingService = ratingService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RatingDto> getById(@PathVariable String id){
        return null;
    }

    @GetMapping("/pub")
    public ResponseEntity<List<RatingDto>> getByPublication(@RequestParam String pubId){
        return null;
    }

    @GetMapping("/ratee")
    public ResponseEntity<List<RatingDto>> getByRatee(@RequestParam String rateeId){
        return null;
    }

    @PostMapping
    public ResponseEntity<RatingDto> post(@Valid @RequestBody RatingDto ratingDto){
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<RatingDto> update(@PathVariable String id, @RequestParam String ownerId){
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RatingDto> delete(@PathVariable String id, @RequestParam String ownerId){
        return null;
    }

}
