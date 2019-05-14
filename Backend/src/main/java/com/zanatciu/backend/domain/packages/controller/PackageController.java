package com.zanatciu.backend.domain.packages.controller;

import com.zanatciu.backend.domain.packages.dto.PackageDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/package")
public class PackageController {

    @GetMapping
    public ResponseEntity<List<PackageDto>> getAll(){
        return null;
    }

    @PostMapping
    public ResponseEntity<PackageDto> post(@Valid @RequestBody PackageDto packageDto){
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id){
        return null;
    }
}
