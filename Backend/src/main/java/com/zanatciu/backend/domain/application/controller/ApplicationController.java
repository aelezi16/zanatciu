package com.zanatciu.backend.domain.application.controller;


import com.zanatciu.backend.domain.application.dto.ApplicationDto;
import com.zanatciu.backend.domain.application.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return null;
    }

    @GetMapping("/pub")
    public ResponseEntity<List<ApplicationDto>> getPerPublication(@RequestParam String pubId){
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApplicationDto> getById(@PathVariable String id){
        return null;
    }

    @PostMapping
    public ResponseEntity<ApplicationDto> post(@Valid @RequestBody ApplicationDto applicationDto){
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApplicationDto> update(@PathVariable String id){
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApplicationDto> delete(@PathVariable String id){
        return null;
    }

}

