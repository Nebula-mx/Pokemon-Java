package com.pokemon.model.pokemon.instances;
import com.pokemon.model.pokemon.abstractTypesClasses.AbstractGrassPokemon;

public class Oddish extends AbstractGrassPokemon {
  
  public Oddish() {
    super("Oddish", "planta", new String[]{"Absorber", "Paralizador", "Ácido", "Hoja afilada"});
    setEvolution("Gloom", 5);
  }
  
  @Override
  public int firstMovement() {
      return 15;
  }

  @Override
  public int secondMovement() {
      return 15;
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
