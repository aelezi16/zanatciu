package com.zanatciu.backend.domain.card.service;

import com.zanatciu.backend.domain.card.dto.CardDto;

import java.util.List;

public interface CardService {
    CardDto getById(String id);

    List<CardDto> getByUsername(String username);

    CardDto save(CardDto cardDto);

    CardDto save(CardDto cardDto, String id);

    void delete(String id);
}
