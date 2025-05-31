package com.pokemon.model.pokemon.instances;

import com.pokemon.model.pokemon.abstractTypesClasses.AbstractFirePokemon;

public class Growlithe extends AbstractFirePokemon {
    public Growlithe() {
    super("Growlithe", "fuego", new String[]{"Lanzallamas", "Colmillo Ígneo", "Aullido", "Placaje"});
    }

    private int id = 21;

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
        return 20;
    }

    @Override
    public void levelUp() {
        super.checkEvolution();
    }
}
