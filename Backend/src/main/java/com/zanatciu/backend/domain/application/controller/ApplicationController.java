package com.zanatciu.backend.domain.application.controller;


import com.zanatciu.backend.domain.application.dto.ApplicationDto;
import com.zanatciu.backend.domain.application.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    private ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService){
        this.applicationService = applicationService;
    }

    @GetMapping
    public ResponseEntity<List<ApplicationDto>> getAll(){
        List<ApplicationDto> list = applicationService.getAll();
        return !list.isEmpty()
                ? new ResponseEntity<>(list, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/pub")
    public ResponseEntity<List<ApplicationDto>> getPerPublication(@RequestParam String pubId){
        List<ApplicationDto> list = applicationService.getPerPublication(pubId);
        return !list.isEmpty()
                ? new ResponseEntity<>(list, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApplicationDto> getById(@PathVariable String id){
        ApplicationDto dto = applicationService.getById(id);
        return dto != null
                ? new ResponseEntity<>(dto, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<ApplicationDto> post(@Valid @RequestBody ApplicationDto applicationDto){
        ApplicationDto dto = applicationService.save(applicationDto);
        return dto != null
                ? new ResponseEntity<>(dto, HttpStatus.CREATED)
                : new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApplicationDto> update(@Valid @RequestBody ApplicationDto applicationDto, @PathVariable String id){
        ApplicationDto dto = applicationService.save(applicationDto, id);
        return dto != null
                ? new ResponseEntity<>(dto, HttpStatus.ACCEPTED)
                : new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/eval/{applicationId}")
    public ResponseEntity evaluate(@PathVariable  String applicationId,@RequestParam String verdict){


        return new ResponseEntity(HttpStatus.OK);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id){
        applicationService.delete(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

}

