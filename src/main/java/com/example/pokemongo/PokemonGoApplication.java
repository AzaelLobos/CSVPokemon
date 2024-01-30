package com.example.pokemongo;

import com.example.pokemongo.clases.CsvReader;
import com.example.pokemongo.clases.LeerFuncional;
import com.example.pokemongo.interfaces.IPokemonRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PokemonGoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PokemonGoApplication.class, args);


    }

}
