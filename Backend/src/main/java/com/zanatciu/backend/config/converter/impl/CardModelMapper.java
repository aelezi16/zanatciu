package com.zanatciu.backend.config.converter.impl;

import com.zanatciu.backend.config.converter.ModelMapper;
import com.zanatciu.backend.domain.card.dto.CardDto;
import com.zanatciu.backend.domain.card.model.Card;
import org.springframework.stereotype.Component;

@Component
public class CardModelMapper implements ModelMapper<Card, CardDto> {

    @Override
    public CardDto modelToDto(Card card) {
        CardDto dto = new CardDto();

        dto.setCreditCard(card.getCreditCard());
        dto.setId(card.getId());
        dto.setUsername(dto.getUsername());

        return dto;
    }

    @Override
    public Card dtoToModel(CardDto cardDto) {
        Card model = new Card();

        model.setId(cardDto.getId());
        model.setCreditCard(cardDto.getCreditCard());
        model.setUsername(cardDto.getUsername());

        return model;
    }

    @Override
    public Card updateModel(Card model1, Card model2) {
        if (model1.getId() != null)
            model2.setId(model1.getId());
        if (model1.getUsername() != null)
            model2.setUsername(model1.getUsername());
        if (model1.getCreditCard() != null)
            model2.setCreditCard(model1.getCreditCard());

        return model2;
    }
}
