package com.zanatciu.backend.domain.rating.controller;

import com.zanatciu.backend.domain.rating.dto.RatingDto;
import com.zanatciu.backend.domain.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rating")
public class RatingController {

    private RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RatingDto> getById(@PathVariable String id) {
        RatingDto dto = ratingService.getById(id);

        return dto != null
                ? new ResponseEntity<>(dto, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/pub")
    public ResponseEntity<List<RatingDto>> getByPublication(@RequestParam String publicationId) {

        List<RatingDto> list = ratingService.getByPublicationId(publicationId);
        return !list.isEmpty()
                ? new ResponseEntity<>(list, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/username")
    public ResponseEntity<List<RatingDto>> getByUsername(@RequestParam String username) {
        List<RatingDto> list = ratingService.getByUsername(username);

        return !list.isEmpty()
                ? new ResponseEntity<>(list, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<RatingDto> post(@Valid @RequestBody RatingDto ratingDto) {
        RatingDto dto = ratingService.save(ratingDto);

        return dto != null
                ? new ResponseEntity<>(dto, HttpStatus.CREATED)
                : new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RatingDto> update(@PathVariable String id, @RequestBody RatingDto ratingDto) {
        RatingDto dto = ratingService.save(ratingDto, id);

        return dto != null
                ? new ResponseEntity<>(dto, HttpStatus.ACCEPTED)
                : new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        ratingService.delete(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

}
