package com.pokemon.model.pokemon.instances;
import com.pokemon.model.pokemon.abstractTypesClasses.AbstractWaterPokemon;

public class Wartortle extends AbstractWaterPokemon{
    private int id = 30;
    public Wartortle() {
        super("Wartortle", "agua", new String[]{"Pistola Agua", "Burbuja", "Cabezazo", "Refugio"});
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
        return 20;
    }

    @Override
    public int fourthMovement() {
        return 20;
    }

    @Override
    public void levelUp() {
        super.checkEvolution();
    }
}
