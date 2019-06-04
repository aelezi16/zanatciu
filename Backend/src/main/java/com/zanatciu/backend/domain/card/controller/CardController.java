package com.zanatciu.backend.domain.card.controller;

import com.zanatciu.backend.domain.card.dto.CardDto;
import com.zanatciu.backend.domain.card.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/card")
public class CardController {

    private CardService cardService;

    @Autowired
    public CardController(CardService cardService){
        this.cardService = cardService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<CardDto> getById(@PathVariable String id)
    {
        CardDto dto = cardService.getById(id);
        return dto != null
                ? new ResponseEntity<>(dto, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<List<CardDto>> getByUsername(@PathVariable String username)
    {
        List<CardDto> list = cardService.getByUsername(username);

        return !list.isEmpty()
                ? new ResponseEntity<>(list, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<CardDto> post(@Valid @RequestBody CardDto cardDto){
        CardDto dto = cardService.save(cardDto);

        return dto != null
                ? new ResponseEntity<>(dto, HttpStatus.CREATED)
                : new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CardDto> put(@Valid @RequestBody CardDto cardDto, @PathVariable String id){
        CardDto dto = cardService.save(cardDto, id);

        return dto != null
                ? new ResponseEntity<>(dto, HttpStatus.ACCEPTED)
                : new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id){
        cardService.delete(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
