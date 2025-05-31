package com.pokemon.model.pokemon.instances;
import com.pokemon.model.pokemon.abstractTypesClasses.AbstractWaterPokemon;

public class Squirtle extends AbstractWaterPokemon{
    private int id = 30;
    public Squirtle() {
        super("Squirtle", "agua", new String[]{"Pistola Agua", "Burbuja", "Cabezazo", "Refugio"});
        setEvolution("Wartortle", 5);
    }

    @Override
    public int firstMovement() {
          return 15;
    }

    @Override
    public int secondMovement() {
        return 20;
    }

    @Override
    public int thirdMovement() {
         return 10;
    }

    @Override
    public int fourthMovement() {
        return 15;
    }

    @Override
    public void levelUp() {
        super.checkEvolution();
    }
}
