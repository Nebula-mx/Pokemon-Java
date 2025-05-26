package com.pokemon.model.pokemon.abstractTypesClasses;

import com.pokemon.model.pokemon.abstractTypes.grass;

public abstract class AbstractGrassPokemon
    extends AbstractPokemon
    implements grass {

    public AbstractGrassPokemon(String name, String type, String[] movements) {
        super(name, type, movements);
    }
    @Override
    public int doMovement(int movementId) {
        return super.doMovement(movementId);
    }

    @Override
    public int getHurt(int damage) {
        return super.getHurt(damage);
    }

    @Override
    public void showInfo() {
        super.showInfo();
    }
}
