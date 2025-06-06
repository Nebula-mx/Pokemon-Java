package com.pokemon.model.pokemon.instances;
import com.pokemon.model.pokemon.abstractTypesClasses.AbstractWaterPokemon;

public class Poliwag extends AbstractWaterPokemon {
    public Poliwag() {
    super("Poliwag", "agua", new String[]{"Pistola Agua", "Burbuja", "Hipnosis", "Ataque Rápido"});
        setEvolution("Poliwhirl", 5);
    }

    private int id = 31;

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
        return -1;
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
