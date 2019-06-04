package com.zanatciu.backend.domain.packages.controller;

import com.zanatciu.backend.domain.packages.dto.PackageDto;
import com.zanatciu.backend.domain.packages.model.Package;
import com.zanatciu.backend.domain.packages.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/package")
public class PackageController {

    private PackageService packageService;

    @Autowired
    public PackageController(
            PackageService packageService
    ){
        this.packageService = packageService;
    }

    @GetMapping
    public ResponseEntity<List<PackageDto>> getAll(){
        List<PackageDto> list = packageService.getAll();
        return list != null
                ? new ResponseEntity<List<PackageDto>>(list, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<PackageDto> post(@Valid @RequestBody PackageDto packageDto){
        PackageDto dto = packageService.save(packageDto);

        return dto != null
                ? new ResponseEntity<PackageDto>(dto, HttpStatus.CREATED)
                : new ResponseEntity<PackageDto>(dto, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id){
        packageService.delete(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @RequestMapping("/subscribe")
    public ResponseEntity subscribe(@RequestParam String packageId, @RequestParam String userId){
        return packageService.subscribe(packageId, userId);
    }
}
