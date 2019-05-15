package com.zanatciu.backend.domain.card.model;

import com.zanatciu.backend.domain.card.pojo.CreditCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    @Id
    private String id;
    private String username;
    @Indexed(unique = true)
    private CreditCard creditCard;
}
