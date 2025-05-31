package com.pokemon.model.pokemon.instances;
import com.pokemon.model.pokemon.abstractTypesClasses.AbstractFirePokemon;

public class Charmander extends AbstractFirePokemon  {
    private int id = 20;
    public Charmander() {
        super("Charmander", "fuego", new String[]{"Lanzallamas", "Arañazo", "Garra Dragón", "Ascuas"});
        setEvolution("Charizard", 5);
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
        return 30;
    }

    @Override
    public void levelUp() {
        super.checkEvolution();
    }
}
