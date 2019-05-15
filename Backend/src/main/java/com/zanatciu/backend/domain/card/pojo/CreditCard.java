package com.zanatciu.backend.domain.card.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditCard {
    @NotBlank
    private String name;
    @NotBlank
    private String card;
    @NotBlank
    private String CVS;
    @NotBlank
    private Integer month;
    @NotBlank
    private Integer year;
}
