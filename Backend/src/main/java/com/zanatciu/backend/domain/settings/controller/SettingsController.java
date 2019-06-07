package com.zanatciu.backend.domain.settings.controller;

import com.zanatciu.backend.domain.settings.dto.SettingsDto;
import com.zanatciu.backend.domain.settings.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/settings")
public class SettingsController {

    private SettingsService settingsService;

    @Autowired
    public SettingsController(SettingsService settingsService) {
        this.settingsService = settingsService;
    }

    @PutMapping("/{username}")
    public ResponseEntity<SettingsDto> updatePerOwner(@PathVariable String username, @RequestBody SettingsDto settingsDto) {

        SettingsDto dto = settingsService.update(settingsDto, username);
        return dto != null
                ? new ResponseEntity<>(dto, HttpStatus.ACCEPTED)
                : new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

    }
}
