package com.zanatciu.backend.domain.card.service.impl;

import com.zanatciu.backend.config.converter.ModelMapper;
import com.zanatciu.backend.domain.card.dto.CardDto;
import com.zanatciu.backend.domain.card.model.Card;
import com.zanatciu.backend.domain.card.repo.CardRepo;
import com.zanatciu.backend.domain.card.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CardServiceImpl implements CardService {

    private CardRepo cardRepo;
    private ModelMapper<Card, CardDto> modelMapper;

    @Autowired
    public CardServiceImpl(
            CardRepo cardRepo,
            ModelMapper<Card, CardDto> modelMapper
    ) {
        this.cardRepo = cardRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public CardDto getById(String id) {
        Optional<Card> optionalCard = cardRepo.findById(id);

        return optionalCard.isPresent()
                ? optionalCard.map(modelMapper::modelToDto).get()
                : null;
    }

    @Override
    public List<CardDto> getByUsername(String username) {

        List<Card> cards = cardRepo.findCardsByUsername(username);

        return !cards.isEmpty()
                ? cards.stream().map(modelMapper::modelToDto).collect(Collectors.toList())
                : null;
    }

    @Override
    public CardDto save(CardDto cardDto) {
        Optional<Card> optionalCard = Optional.of(cardDto).map(modelMapper::dtoToModel);

        if (cardRepo.findById(cardDto.getId()).isPresent())
            return null;

        return Optional.of(cardRepo.save(optionalCard.get())).map(modelMapper::modelToDto).get();
    }

    @Override
    public CardDto save(CardDto cardDto, String id) {

        Optional<Card> card = cardRepo.findById(id);

        if (!card.isPresent())
            return null;

        Optional<Card> optionalCard = Optional.of(cardDto).map(modelMapper::dtoToModel);

        return card.map(
                (c) -> modelMapper.updateModel(optionalCard.get(), c)
        ).map(c -> cardRepo.save(c)).map(modelMapper::modelToDto).get();
    }

    @Override
    public void delete(String id) {
        Optional<Card> card = cardRepo.findById(id);

        if (!card.isPresent())
            return;

        cardRepo.delete(card.get());
    }
}
