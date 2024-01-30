package com.example.pokemongo.interfaces;

import com.example.pokemongo.persistence.entities.Pokemon;

import java.util.List;

public interface IPokemonRepository {

    List<Pokemon>findAllPokemons();
}
