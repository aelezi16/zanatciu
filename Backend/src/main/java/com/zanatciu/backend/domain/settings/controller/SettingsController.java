package com.zanatciu.backend.domain.settings.controller;

import com.zanatciu.backend.domain.settings.dto.SettingsDto;
import com.zanatciu.backend.domain.settings.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/settings")
public class SettingsController {

    private SettingsService settingsService;

    @Autowired
    public SettingsController(SettingsService settingsService){
        this.settingsService = settingsService;
    }

    @GetMapping("/{ownerId}")
    public ResponseEntity<SettingsDto> getByOwner(@PathVariable String ownerId){
        return null;
    }

    @PutMapping("/{ownerId}")
    public ResponseEntity<SettingsDto> updatePerOwner(@PathVariable String ownerId){
        return null;
    }
}
