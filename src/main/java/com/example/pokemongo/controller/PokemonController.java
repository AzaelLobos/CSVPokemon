package com.example.pokemongo.controller;

import com.example.pokemongo.clases.CsvReader;
import com.example.pokemongo.clases.LeerFuncional;
import com.example.pokemongo.interfaces.IPokemonRepository;
import com.example.pokemongo.persistence.entities.Pokemon;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pokemon")
public class PokemonController {

    IPokemonRepository csvReader = new CsvReader("src/main/java/com/example/pokemongo/archive/PokemonGO.csv");
    LeerFuncional leerFuncional = new LeerFuncional(csvReader);

    @GetMapping("/pokemonsTotal")
    public ResponseEntity<Integer> pokemonsTotal() {
        return leerFuncional.pokemonsTotal()
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @GetMapping("/pokemonsStamina250")
    public ResponseEntity<List<Pokemon>> pokemonsStamina250() {
        return Optional
                .of(leerFuncional.pokemonsStamina250())
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @GetMapping("/pokemonsLegendarios")
    public ResponseEntity<List<Pokemon>> pokemonsLegendarios() {
        return Optional
                .of(leerFuncional.pokemonsLegendarios())
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @GetMapping
    public ResponseEntity<List<Pokemon>> primerosDiez() {
        return Optional
                .of(leerFuncional.primerosDiez())
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @GetMapping("/pokemonsVeneno")
    public ResponseEntity<Integer> pokemonsVeneno() {
        return leerFuncional.pokemonsVeneno()
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @GetMapping("/pokemonsNoLegendarios")
    public ResponseEntity<Integer> pokemonsNoLegendarios() {
        return leerFuncional.pokemonsNoLegendarios()
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @GetMapping("/pokemonPorNombre/{nombre}")
    public ResponseEntity<Pokemon> pokemonPorNombre(@PathVariable String nombre) {
        return leerFuncional.pokemonPorNombre(nombre)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @GetMapping("/pokemonsAtaqueMas250")
    public ResponseEntity<Integer> pokemonsAtaqueMas250() {
        return leerFuncional.pokemonsAtaqueMas250()
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @GetMapping("/promedioPC")
    public ResponseEntity<Integer> promedioPC() {
        return leerFuncional.promedioPC()
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @GetMapping("/pokemonEstaTotal")
    public ResponseEntity<List<Pokemon>> pokemonEstaTotal() {
        return Optional
                .of(leerFuncional.pokemonEstaTotal())
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @GetMapping("/pokemonsA")
    public ResponseEntity<List<Pokemon>> pokemonsA() {
        return Optional
                .of(leerFuncional.pokemonsA())
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @GetMapping("/pokemonsCPAtaque")
    public ResponseEntity<List<Pokemon>> pokemonsCPAtaque() {
        return Optional
                .of(leerFuncional.pokemonsCPAtaque())
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @GetMapping("/pokemonsHLegendarios")
    public ResponseEntity<List<Pokemon>> pokemonsHLegendarios() {
        return Optional
                .of(leerFuncional.pokemonsHLegendarios())
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @GetMapping("/masDefensaQueAtaque")
    public ResponseEntity<List<Pokemon>> masDefensaQueAtaque() {
        return Optional
                .of(leerFuncional.masDefensaQueAtaque())
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @GetMapping("/mayorDefensa")
    public ResponseEntity<Pokemon> mayorDefensa() {
        return leerFuncional.mayorDefensa()
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @GetMapping("/fuegoVolador")
    public ResponseEntity<List<Pokemon>> fuegoVolador() {
        return Optional
                .of(leerFuncional.fuegoVolador())
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @GetMapping("/mayorAtaqueMenorDefensa")
    public ResponseEntity<List<Pokemon>> mayorAtaqueMenorDefensa() {
        return Optional
                .of(leerFuncional.mayorAtaqueMenorDefensa())
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @GetMapping("/pokemonsCFuego")
    public ResponseEntity<List<Pokemon>> pokemonsCFuego() {
        return Optional
                .of(leerFuncional.pokemonsCFuego())
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @GetMapping("/tipoNormal")
    public ResponseEntity<List<Pokemon>> tipoNormal() {
        return Optional
                .of(leerFuncional.tipoNormal())
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @GetMapping("/menorEstadisticaTotal")
    public ResponseEntity<List<Pokemon>> menorEstadisticaTotal() {
        return Optional
                .of(leerFuncional.menorEstadisticaTotal())
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @GetMapping("/legendariosDragon")
    public ResponseEntity<List<Pokemon>> legendariosDragon() {
        return Optional
                .of(leerFuncional.legendariosDragon())
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @GetMapping("/pokemonHPNoLegendario")
    public ResponseEntity<List<Pokemon>> pokemonHPNoLegendario() {
        return Optional
                .of(leerFuncional.pokemonHPNoLegendario())
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @GetMapping("/cuantosTipos")
    public ResponseEntity<Integer> cuantosTipos() {
        return leerFuncional.cuantosTipos()
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @GetMapping("/bicho100StaminaNoLegendario")
    public ResponseEntity<Integer> bicho100StaminaNoLegendario() {
        return leerFuncional.bicho100StaminaNoLegendario()
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @GetMapping("/noLegendarioGMayorAtaque")
    public ResponseEntity<List<Pokemon>> noLegendarioGMayorAtaque() {
        return Optional
                .of(leerFuncional.noLegendarioGMayorAtaque())
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @GetMapping("/dosTipos")
    public ResponseEntity<List<Pokemon>> dosTipos() {
        return Optional
                .of(leerFuncional.dosTipos())
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @GetMapping("/unTipo")
    public ResponseEntity<List<Pokemon>> unTipo() {
        return Optional
                .of(leerFuncional.unTipo())
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @GetMapping("/primeros50Ultimos50")
    public ResponseEntity<List<Pokemon>> primeros50Ultimos50() {
        return Optional
                .of(leerFuncional.primeros50Ultimos50())
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @GetMapping("/ataqueDefensaIguales")
    public ResponseEntity<List<Pokemon>> ataqueDefensaIguales() {
        return Optional
                .of(leerFuncional.ataqueDefensaIguales())
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @GetMapping("/mayorDefensaMenorAtaqueHP")
    public ResponseEntity<List<Pokemon>> mayorDefensaMenorAtaqueHP() {
        return Optional
                .of(leerFuncional.mayorDefensaMenorAtaqueHP())
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }
}
