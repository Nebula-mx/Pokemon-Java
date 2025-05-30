package com.pokemon.model.pokemon.instances;

import com.pokemon.model.pokemon.abstractTypesClasses.AbstractFirePokemon;

public class Arcaine extends AbstractFirePokemon {
    public Arcaine() {
    super("Arcaine", "fuego", new String[]{"Lanzallamas", "Colmillo Ígneo", "Aullido", "Placaje"});
        setEvolution("Growlithe", 5);
    }

    private int id = 21;

    @Override
    public int firstMovement() {
        return 90;
    }

    @Override
    public int seccondMovement() {
        return 65;
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
