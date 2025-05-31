package com.pokemon.model.pokemon.instances;

import com.pokemon.model.pokemon.abstractTypesClasses.AbstractGrassPokemon;

public class Gloom extends AbstractGrassPokemon {
  
  public Gloom() {
    super("Gloom", "planta", new String[]{"Absorber", "Paralizador", "Ácido", "Hoja afilada"});
  }
  
  @Override
  public int firstMovement() {
      return 20;
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
      return 25;
  }

  @Override
  public void levelUp() {
      super.checkEvolution();
  }
}
