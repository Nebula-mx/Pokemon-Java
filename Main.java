package pokemon;

//para ejecutar el programa usen el comando java -cp compiledFiles pokemon.Main

import pokemon.model.pokemon.instances.Bulbasaur;
import pokemon.model.pokemon.instances.Charmander;
import pokemon.model.pokemon.instances.Squirtle;
import pokemon.ui.application.app;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        app.main();
        Charmander charmander = new Charmander();
        Bulbasaur bulbasour = new Bulbasaur();
        Squirtle squirtle = new Squirtle();

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
