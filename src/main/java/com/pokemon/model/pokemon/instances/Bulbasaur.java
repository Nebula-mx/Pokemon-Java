package com.pokemon.model.pokemon.instances;


import com.pokemon.model.pokemon.abstractTypes.grass;
import com.pokemon.model.pokemon.abstractTypesClasses.AbstractGrassPokemon;

public class Bulbasaur extends AbstractGrassPokemon implements grass {
    private static final long serialVersionUID = 2L;  // Diferente para cada Pokémon

    public Bulbasaur() {
        super("Bulbasaur", "HIERBA", new String[]{"Latigazo", "Drenadoras", "Hoja Afilada", "Placaje"});
        setEvolution("Ivysaur", 5);  // Evoluciona a nivel 5

    }

    @Override
    public int hojaAfilada() {
        return 10;
    }

    @Override
    public int latigazo() {
        return 15;
    }

    @Override
    public int drenadoras() {
        return 20;
    }

    @Override
    public int rayoSolar() {
        return 25;
    }

    @Override
    public int firstMovement() {
        return hojaAfilada();
    }

    @Override
    public int seccondMovement() {
        return latigazo();
    }

    @Override
    public int thirdMovement() {
        return drenadoras();
    }

    @Override
    public int fourthMovement() {
        return rayoSolar();
    }

    @Override
    public void levelUp() {
        super.checkEvolution();
    }
}
