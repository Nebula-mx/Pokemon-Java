package com.pokemon.model.pokemon.instances;

import com.pokemon.model.pokemon.abstractTypes.water;
import com.pokemon.model.pokemon.abstractTypesClasses.AbstractWaterPokemon;

public class Squirtle extends AbstractWaterPokemon implements water{

    public Squirtle() {
        super("Squirtle", "AGUA", new String[]{"Pistola Agua", "Burbuja", "Cabezazo", "Refugio"});
        setEvolution("Wartortle", 5);  // Evoluciona a nivel 5
    }

    @Override
    public int pistolaAgua() {
        return 1;
    }

    @Override
    public int hidrobomba() {
        return 2;
    }

    @Override
    public int rayoBurbuja() {
        return 3;
    }

    @Override
    public int surf() {
        return 4;
    }

    @Override
    public int firstMovement() {
        return pistolaAgua();
    }

    @Override
    public int seccondMovement() {
        return hidrobomba();
    }

    @Override
    public int thirdMovement() {
        return rayoBurbuja();
    }

    @Override
    public int fourthMovement() {
        return surf();
    }

    @Override
    public void levelUp() {
        super.checkEvolution();
    }
}
