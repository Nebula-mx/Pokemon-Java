package com.pokemon.model.pokemon.instances;
import com.pokemon.model.pokemon.abstractTypesClasses.AbstractFirePokemon;

public class Charizard extends AbstractFirePokemon  {
    private int id = 20;
    public Charizard() {
        super("Charizard", "fuego", new String[]{"Lanzallamas", "Arañazo", "Garra Dragón", "Ascuas"});
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
        return 35;
    }

    @Override
    public void levelUp() {
        super.checkEvolution();
    }
}
