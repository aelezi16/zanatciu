package com.zanatciu.backend.domain.card.dto;

import com.zanatciu.backend.domain.card.pojo.CreditCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardDto {
  private String id;
  private String username;
  private CreditCard creditCard;
}
