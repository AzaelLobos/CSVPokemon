package com.example.pokemongo.clases;

import com.example.pokemongo.interfaces.IPokemonRepository;
import com.example.pokemongo.persistence.entities.Pokemon;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

public class LeerFuncional {
    private final IPokemonRepository pokemonRepository;

    public LeerFuncional(IPokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    //Función que calcula el numero total de los pokemons existentes.
    public Optional<Integer> pokemonsTotal() {
        List<Pokemon> pokemons = pokemonRepository.findAllPokemons();
        return Optional.of((int)pokemons.size());
    }

    //Funcion que manda a todos los pokemons con una Stamina mayor a 250
    public List<Pokemon> pokemonsStamina250() {
        List<Pokemon> pokemons = pokemonRepository.findAllPokemons();
        return pokemons.stream()
                .filter(pokemon -> pokemon.getStamina()>250).toList();
    }

    //Funcion que muestra a todos los pokemons legendarios que hay
    public List<Pokemon> pokemonsLegendarios() {
        List<Pokemon> pokemons = pokemonRepository.findAllPokemons();
        return pokemons.stream()
                .filter(pokemon -> pokemon.getIsLegendary().equalsIgnoreCase("True")).toList();
    }

    //Funcion que muestra a los primeros 10 pokemons.
    public List<Pokemon> primerosDiez() {
        List<Pokemon> pokemons = pokemonRepository.findAllPokemons();
        return pokemons.stream()
                .limit(10).toList();
    }

    //Funcion que calcula el numero de todos los pokemons de tipo veneno, siendo que esten en tipo 1 o tipo 2
    public Optional<Integer> pokemonsVeneno() {
        List<Pokemon> pokemons = pokemonRepository.findAllPokemons();
        long tiposVeneno = pokemons.stream()
                .filter(pokemon -> "poison".equalsIgnoreCase(pokemon.getType1()) || "poison".equalsIgnoreCase(pokemon.getType2()))
                .count();

        return tiposVeneno > 0 ? Optional.of((int) tiposVeneno) : Optional.empty();
    }

    //Funcion que calcula la cantidad de todos los pokemons los cuales no son legendarios
    public Optional<Integer> pokemonsNoLegendarios() {
        List<Pokemon> pokemons = pokemonRepository.findAllPokemons();
        long noLegendarios = pokemons.stream()
                .filter(pokemon -> "False".equalsIgnoreCase(pokemon.getIsLegendary()))
                .count();

        return noLegendarios > 0 ? Optional.of((int) noLegendarios) : Optional.empty();
    }

    //Funcion que busca a un pokemon especifico.
    public Optional<Pokemon> pokemonPorNombre(String nombre){
        List<Pokemon> pokemons = pokemonRepository.findAllPokemons();
        return pokemons.stream()
                .filter(pokemon -> pokemon.getPokemon().equalsIgnoreCase(nombre)).findFirst();
    }

    //Funcion que calcula a toda la cantidad de pokemons los cuales tienen un ataque mayor a 250
    public Optional<Integer> pokemonsAtaqueMas250(){
        List<Pokemon> pokemons = pokemonRepository.findAllPokemons();
        long mayor250 = pokemons.stream()
                .filter(pokemon -> pokemon.getAttack() > 250)
                .count();

        return mayor250 > 0 ? Optional.of((int) mayor250) : Optional.empty();
    }

    //Funcion que promedio a el CP de todos los pokemons
    public Optional<Integer> promedioPC(){//falta
        List<Pokemon> pokemons = pokemonRepository.findAllPokemons();
        return Optional.of((int) pokemons.size());
    }

    //Funcion que busca a un pokemon con una cantidad especifica de estadisticas totales
    public List<Pokemon> pokemonEstaTotal(){
        List<Pokemon> pokemons = pokemonRepository.findAllPokemons();
        return pokemons.stream()
                .filter(pokemon -> pokemon.getTotalStats()==683).toList();
    }


    //Funcion que muestra a todos los pokemons los cuales incian con la letra A
    public List<Pokemon> pokemonsA(){
        List<Pokemon> pokemons = pokemonRepository.findAllPokemons();
        return pokemons.stream()
                .filter(pokemon -> pokemon.getPokemon().charAt(0)=='A').toList();
    }

    //Funcion la cual muestra a todos los pokemons los cuales tiene un CP mayor a 3000 y un ataque mayor a 250
    public List<Pokemon> pokemonsCPAtaque(){
        List<Pokemon> pokemons = pokemonRepository.findAllPokemons();
        return pokemons.stream()
                .filter(pokemon -> pokemon.getMaxCP()>3000)
                .filter(pokemon -> pokemon.getAttack()>250).toList();
    }

    //Funcion que muestra a todos los pokemons los cuales incian con una letra H y son legendarios
    public List<Pokemon> pokemonsHLegendarios(){
        List<Pokemon> pokemons = pokemonRepository.findAllPokemons();
        return pokemons.stream()
                .filter(pokemon -> pokemon.getPokemon().charAt(0)=='H')
                .filter(pokemon -> pokemon.getIsLegendary().equalsIgnoreCase("True")).toList();
    }

    //Funcion que muestra a todos los pokemons los cuales tienen una defensa mayor a su ataque
    public List<Pokemon> masDefensaQueAtaque(){
        List<Pokemon> pokemons = pokemonRepository.findAllPokemons();

        return pokemons.stream()
                .filter(pokemon -> pokemon.getDefense() > pokemon.getAttack())
                .collect(Collectors.toList());
    }

    //Funcion la cual dice cual es el pokemon el cual tiene la mayor defensa de todos
    public Optional<Pokemon> mayorDefensa(){
            Optional<Pokemon> pokemon;
            return pokemon = pokemonRepository.findAllPokemons()
                    .stream()
                    .sorted(Comparator.comparing(Pokemon::getDefense).reversed())
                    .findFirst();

    }

    //Funcion la cual muestra a todos los pokemons los cuales tienen el tipo fuego en tipo 1 y el tipo volador en el tipo 2
    public List<Pokemon> fuegoVolador(){
        List<Pokemon> pokemons = pokemonRepository.findAllPokemons();
        return pokemons.stream()
                .filter(pokemon -> pokemon.getType1().equalsIgnoreCase("Fire")
                        && pokemon.getType2().equalsIgnoreCase("Flying")).toList();
    }

    //Funcion el cual incica cual es el pokemon con el mayor ataque, pero la menor defensa
    public List<Pokemon> mayorAtaqueMenorDefensa(){
        List<Pokemon> pokemons = pokemonRepository.findAllPokemons();
        return pokemons.stream()
                .filter(pokemon -> pokemon.getAttack() > pokemon.getDefense())
                .max((pokemon1, pokemon2) -> Integer.compare(pokemon1.getAttack(), pokemon2.getAttack())).stream().toList();
    }

    //Funcion el cual devuelve a todos los pokemons que inicien con la letra C y tengan el tipo fuego en cualquiera de los tipos
    public List<Pokemon> pokemonsCFuego(){
        List<Pokemon> pokemons = pokemonRepository.findAllPokemons();
        return pokemons.stream()
                .filter(pokemon -> pokemon.getPokemon().charAt(0)=='C')
                .filter(pokemon -> pokemon.getType1().equalsIgnoreCase("Fire")
                        || pokemon.getType2().equalsIgnoreCase("Fire")).toList();
    }

    //Funcion que devuelve a todos los pokemons los cuales tienen el tipo normal pero no tienen un tipo 2
    public List<Pokemon> tipoNormal(){
        List<Pokemon> pokemons = pokemonRepository.findAllPokemons();
        return pokemons.stream()
                .filter(pokemon -> pokemon.getType1().equalsIgnoreCase("Normal")
                        && pokemon.getType2().equalsIgnoreCase("None")).toList();
    }

    //Funcion la cual devuelve al pokemon el cual tiene la menor estadistica total
    public List<Pokemon> menorEstadisticaTotal(){
        List<Pokemon> pokemons = pokemonRepository.findAllPokemons();
        return pokemons.stream()
                .min((pokemon1, pokemon2) -> Integer.compare(pokemon1.getTotalStats(), pokemon2.getTotalStats())).stream().toList();
    }

    //Funcion la cual me devuelve a los pokemons los cuales son legendarios, son tipo dragon y tienen un CP mayor a 4000
    public List<Pokemon> legendariosDragon(){
        List<Pokemon> pokemons = pokemonRepository.findAllPokemons();
        return pokemons.stream()
                .filter(pokemon -> pokemon.getIsLegendary().equalsIgnoreCase("True"))
                .filter(pokemon -> pokemon.getType1().equalsIgnoreCase("Dragon")
                        || pokemon.getType2().equalsIgnoreCase("Dragon"))
                .filter(pokemon -> pokemon.getMaxCP()>4000).toList();
    }

    //Funcion la cual devuelve al pokemon con el mayor HP de todos y no es legendario
    public List<Pokemon> pokemonHPNoLegendario(){
        List<Pokemon> pokemons = pokemonRepository.findAllPokemons();
        Optional<Integer> maxHP = pokemons.stream()
                .filter(pokemon -> !pokemon.getIsLegendary().equalsIgnoreCase("false"))
                .map(pokemon -> pokemon.getMaxHP())
                .max(Comparator.naturalOrder());
        List<Pokemon> pokemonsMaxHP = new ArrayList<>();
        maxHP.ifPresent(max -> {
            pokemonsMaxHP.addAll(
                    pokemons.stream()
                            .filter(pokemon -> !pokemon.getIsLegendary().equalsIgnoreCase("true") && pokemon.getMaxHP() == max)
                            .toList()
            );
        });
        return pokemonsMaxHP;
    }

    //Funcion que devuelve la cantidad de todos los tipos existentes de pokemons
    public Optional<Integer> cuantosTipos(){
        List<Pokemon> pokemons = pokemonRepository.findAllPokemons();

        Set<String> tipos = new HashSet<>();

        pokemons.forEach(pokemon -> {
            tipos.add(pokemon.getType1());
            if (pokemon.getType2() != null) {
                tipos.add(pokemon.getType2());
            }
        });

        return !tipos.isEmpty() ? Optional.of(tipos.size()) : Optional.empty();
    }

    //Funcion que devuelve la cantidad de pokemons los cuales tienen el tipo bicho, tienen una stamina mayor a 100 y no son legendarios
    public Optional<Integer> bicho100StaminaNoLegendario(){
        List<Pokemon> pokemons = pokemonRepository.findAllPokemons();
        return Optional.of((int) pokemons.stream()
                .filter(pokemon -> pokemon.getType1().equalsIgnoreCase("bug") || (pokemon.getType2() != null
                        && pokemon.getType2().equalsIgnoreCase("bug")))
                .filter(pokemon -> pokemon.getStamina() > 100)
                .count());
    }

    //Funcion la cual devuelve al pokemon el cual no es legendario, empieza con la letra G y tiene el mayor ataque
    public List<Pokemon> noLegendarioGMayorAtaque(){
        List<Pokemon> pokemons = pokemonRepository.findAllPokemons();
        return pokemons.stream()
                .filter(pokemon -> !pokemon.getIsLegendary().equalsIgnoreCase("true")
                        && pokemon.getPokemon().startsWith("G"))
                .max((pokemon1, pokemon2) -> Integer.compare(pokemon1.getAttack(), pokemon2.getAttack())).stream().toList();
    }

    public List<Pokemon> dosTipos(){//falta
        List<Pokemon> pokemons = pokemonRepository.findAllPokemons();
        return pokemons.stream()
                .filter(pokemon -> pokemon.getType2() != "none")
                .collect(Collectors.toList());
    }

    public List<Pokemon> unTipo(){//falta
        List<Pokemon> pokemons = pokemonRepository.findAllPokemons();
        return pokemons.stream()
                .filter(pokemon -> pokemon.getIsLegendary().equalsIgnoreCase("True"))
                .filter(pokemon -> pokemon.getType1().equalsIgnoreCase("Dragon")
                        || pokemon.getType2().equalsIgnoreCase("Dragon"))
                .filter(pokemon -> pokemon.getMaxCP()>4000).toList();
    }

    public List<Pokemon> primeros50Ultimos50(){//falta
        List<Pokemon> pokemons = pokemonRepository.findAllPokemons();
        return pokemons.subList(0, Math.min(pokemons.size(), 50));
    }

    //Funcion la cual devuelve a todos los pokemons los cuales tienen la misma cantidad de ataque y defensa
    public List<Pokemon> ataqueDefensaIguales(){
        List<Pokemon> pokemons = pokemonRepository.findAllPokemons();
        return pokemons.stream()
                .filter(pokemon -> pokemon.getAttack()==pokemon.getDefense()).toList();
    }

    public List<Pokemon> mayorDefensaMenorAtaqueHP(){//falta
        List<Pokemon> pokemons = pokemonRepository.findAllPokemons();
        return pokemons.stream()
                .filter(pokemon -> pokemon.getIsLegendary().equalsIgnoreCase("True"))
                .filter(pokemon -> pokemon.getType1().equalsIgnoreCase("Dragon")
                        || pokemon.getType2().equalsIgnoreCase("Dragon"))
                .filter(pokemon -> pokemon.getMaxCP()>4000).toList();
    }
}
