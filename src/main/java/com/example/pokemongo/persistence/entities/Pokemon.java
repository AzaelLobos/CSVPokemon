package com.example.pokemongo.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pokemon {
    private String pokemon;
    private int maxCP;
    private int maxHP;
    private int attack;
    private int defense;
    private int stamina;
    private int totalStats;
    private String isLegendary;
    private String type1;
    private String type2;
}
