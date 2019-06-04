package com.zanatciu.backend.domain.publication.controller;

import com.zanatciu.backend.domain.publication.dto.PublicationDto;
import com.zanatciu.backend.domain.publication.service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
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
        List<PublicationDto> list = publicationService.getAll();

        return !list.isEmpty()
                ? new ResponseEntity<>(list, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublicationDto> getById(@PathVariable String id){
        PublicationDto dto = publicationService.getById(id);

        return dto != null
                ? new ResponseEntity<>(dto, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/username")
    public ResponseEntity<List<PublicationDto>> getPubsByUsername(@RequestParam String username, @RequestParam String type){
        List<PublicationDto> list = publicationService.getByUsername(username, type);

        return !list.isEmpty()
                ? new ResponseEntity<>(list, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/type")
    public ResponseEntity<List<PublicationDto>> getByType(@RequestParam String type, @RequestParam Integer max){
        List<PublicationDto> list = publicationService.getByType(type);

        return !list.isEmpty()
                ? new ResponseEntity<>(list, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<PublicationDto> post(@Valid @RequestBody PublicationDto publicationDto){

        PublicationDto dto = publicationService.save(publicationDto);

        return dto != null
                ? new ResponseEntity<>(dto, HttpStatus.CREATED)
                : new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

    }

    @PutMapping("/{id}")
    public ResponseEntity<PublicationDto> update(@Valid @RequestBody PublicationDto publicationDto, @PathVariable String id){
        PublicationDto dto = publicationService.save(publicationDto, id);

        return dto != null
                ? new ResponseEntity<>(dto, HttpStatus.ACCEPTED)
                : new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id){

        publicationService.delete(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);

    }
}
