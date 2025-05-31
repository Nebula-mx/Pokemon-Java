package com.pokemon.model.pokemon.instances;
import com.pokemon.model.pokemon.abstractTypesClasses.AbstractGrassPokemon;

public class Ivysaur extends AbstractGrassPokemon {
    private int id = 10;
    public Ivysaur() {
        super("Ivysaur", "planta", new String[]{"Latigazo", "Drenadoras", "Hoja Afilada", "Placaje"});
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
       return 25;
    }

    @Override
    public int fourthMovement() {
        return 30;
    }

    @Override
    public void levelUp() {
        super.checkEvolution();
    }
}
