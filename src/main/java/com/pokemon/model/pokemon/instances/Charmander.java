package com.pokemon.model.pokemon.instances;
import com.pokemon.model.pokemon.abstractTypes.fire;
import com.pokemon.model.pokemon.abstractTypesClasses.AbstractFirePokemon;

public class Charmander extends AbstractFirePokemon implements fire {
    private int id = 20;
    public Charmander() {
        super("Charmander", "fuego", new String[]{"Lanzallamas", "Arañazo", "Garra Dragón", "Ascuas"});
        setEvolution("Charizard", 5);
    }


    @Override
    public int Ascuas() {
        return 10;
    }

    @Override
    public int lanzallamas() {
        return 15;
    }

    @Override
    public int giroFuego() {
        return 20;
    }

    @Override
    public int infierno() {
        return 30;
    }

    @Override
    public int firstMovement() {
        return Ascuas();
    }

    @Override
    public int seccondMovement() {
        return lanzallamas();
    }

    @Override
    public int thirdMovement() {
        return giroFuego();
    }

    @Override
    public int fourthMovement() {
        return infierno();
    }

    @Override
    public void levelUp() {
        super.checkEvolution();
    }
}
