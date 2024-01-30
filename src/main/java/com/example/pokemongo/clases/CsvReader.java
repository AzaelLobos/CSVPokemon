package com.example.pokemongo.clases;

import com.example.pokemongo.interfaces.IPokemonRepository;
import com.example.pokemongo.persistence.entities.Pokemon;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import lombok.extern.log4j.Log4j2;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public class CsvReader implements IPokemonRepository {
    private static final String SEPARADOR = ",";
    private final String ruta;

    public CsvReader(String ruta) {
        this.ruta = ruta;
    }

    private Pokemon mapearPokemons(String[] campos){
        boolean f=false;
        boolean v=true;
        String convertir=campos[1].replace(",", "");
        String pokemon=campos[0];
        int maxCP=(int)Double.parseDouble(convertir);
        int maxHP=(campos[2]!="")?Integer.parseInt(campos[2]):null;
        int attack=(campos[3]!="")?Integer.parseInt(campos[3]):null;
        int defense=(campos[4]!="")?Integer.parseInt(campos[4]):null;
        int stamina=(campos[5]!="")?Integer.parseInt(campos[5]):null;
        int totalStats=(campos[6]!="")?Integer.parseInt(campos[6]):null;
        String isLegendary=campos[7];
        String type1=campos[8];
        String type2=campos[9];

        return new Pokemon(pokemon, maxCP, maxHP, attack, defense, stamina, totalStats, isLegendary, type1, type2);
    }
    @Override
    public List<Pokemon> findAllPokemons() {
        log.info("Obteniendo todos los Pokemons");
        Path path = Path.of(ruta);
        try (CSVReader reader = new CSVReader(new FileReader(path.toString()))) {
            List<String[]> lines = reader.readAll();
            return lines.stream()
                    .skip(1)
                    .map(this::mapearPokemons)
                    .collect(Collectors.toList());
        } catch (IOException | CsvException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
