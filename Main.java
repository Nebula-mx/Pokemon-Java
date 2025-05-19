package pokemon;

//para ejecutar el programa usen el comando java -cp compiledFiles pokemon.Main

import pokemon.abstractTypesClasses.AbstractPokemon;
import pokemon.pokemons.Bulbasaur;
import pokemon.pokemons.Charmander;
import pokemon.pokemons.Squirtle;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        AbstractPokemon charmander = new Charmander();
        AbstractPokemon bulbasour = new Bulbasaur();
        AbstractPokemon squirtle = new Squirtle();

        Map<String, Function<Integer, Integer>> damageTargets = new HashMap<>();
        damageTargets.put("charmander", charmander::getHurt);
        damageTargets.put("bulbasour", bulbasour::getHurt);
        damageTargets.put("squirtle", squirtle::getHurt);

        charmander.showInfo();
        squirtle.showInfo();
        damageTargets.get("charmander").apply(squirtle.doMovement(1));
        charmander.showInfo();
        damageTargets.get("squirtle").apply(charmander.doMovement(3));
        squirtle.showInfo();
    }
}
