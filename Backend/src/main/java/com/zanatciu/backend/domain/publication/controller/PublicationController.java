package com.zanatciu.backend.domain.publication.controller;

import com.zanatciu.backend.domain.publication.dto.PublicationDto;
import com.zanatciu.backend.domain.publication.service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pubs")
public class PublicationController {

    private PublicationService publicationService;

    @Autowired
    public PublicationController(PublicationService publicationService){
        this.publicationService = publicationService;
    }

    @GetMapping
    public ResponseEntity<List<PublicationDto>> getAll(){
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublicationDto> getById(@PathVariable String id){
        return null;
    }

    @GetMapping("/owner")
    public ResponseEntity<List<PublicationDto>> getByOwnerId(@RequestParam String ownerId, @RequestParam String type){
        return null;
    }

    @GetMapping("/type")
    public ResponseEntity<List<PublicationDto>> getByType(@RequestParam String type, @RequestParam Integer max){
        return null;
    }

    @PostMapping
    public ResponseEntity<PublicationDto> post(@Valid @RequestBody PublicationDto publicationDto){
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<PublicationDto> update(@PathVariable String id){
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PublicationDto> delete(@PathVariable String id){
        return null;
    }
}
