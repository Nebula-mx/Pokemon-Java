package com.pokemon.model.pokemon.instances;

import com.pokemon.model.pokemon.abstractTypesClasses.AbstractWaterPokemon;

public class Poliwag extends AbstractWaterPokemon {
    public Poliwag() {
    super("Poliwag", "agua", new String[]{"Pistola Agua", "Burbuja", "Hipnosis", "Ataque Rápido"});
        setEvolution("Growlithe", 5);
    }

    private int id = 31;

    @Override
    public int firstMovement() {
        return 40;
    }

    @Override
    public int seccondMovement() {
        return 20;
    }

    @Override
    public int thirdMovement() {
        return -1;
    }

    @Override
    public int fourthMovement() {
        return 40;
    }

    @Override
    public void levelUp() {
        super.checkEvolution();
    }

}
