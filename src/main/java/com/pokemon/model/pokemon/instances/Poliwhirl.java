package com.pokemon.model.pokemon.instances;
import com.pokemon.model.pokemon.abstractTypesClasses.AbstractWaterPokemon;

public class Poliwhirl extends AbstractWaterPokemon {
    public Poliwhirl() {
    super("Poliwhirl", "agua", new String[]{"Pistola Agua", "Burbuja", "Hipnosis", "Ataque Rápido"});
    }

    private int id = 31;

    @Override
    public int firstMovement() {
        return 20;
    }

    @Override
    public int secondMovement() {
        return 25;
    }

    @Override
    public int thirdMovement() {
        return -1;
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
