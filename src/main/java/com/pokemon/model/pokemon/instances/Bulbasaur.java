package com.pokemon.model.pokemon.instances;

import com.pokemon.model.pokemon.abstractTypesClasses.AbstractGrassPokemon;

public class Bulbasaur extends AbstractGrassPokemon {
    private int id = 10;
    public Bulbasaur() {
        super("Bulbasaur", "planta", new String[]{"Latigazo", "Drenadoras", "Hoja Afilada", "Placaje"});
        setEvolution("Ivysaur", 5);
    }
    @Override
    public int firstMovement() {
        return 10;
    }

    @Override
    public int secondMovement() {
        return 15;
    }

    @Override
    public int thirdMovement() {
        return 20;
    }

    @Override
    public int fourthMovement() {
        return 25;
    }

    @Override
    public void levelUp() {
        super.checkEvolution();
    }
}
