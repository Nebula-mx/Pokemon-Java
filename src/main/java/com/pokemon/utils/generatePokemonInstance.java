package com.pokemon.utils;

import com.pokemon.model.pokemon.abstractTypesClasses.AbstractPokemon;
import com.pokemon.model.pokemon.instances.Arcaine;
import com.pokemon.model.pokemon.instances.Bulbasaur;
import com.pokemon.model.pokemon.instances.Charmander;
import com.pokemon.model.pokemon.instances.Oddish;
import com.pokemon.model.pokemon.instances.Poliwag;
import com.pokemon.model.pokemon.instances.Squirtle;

import com.pokemon.model.pokemon.instances.Gloom;
import com.pokemon.model.pokemon.instances.Wartortle;
import com.pokemon.model.pokemon.instances.Poliwhirl;
import com.pokemon.model.pokemon.instances.Growlithe;
import com.pokemon.model.pokemon.instances.Charizard;
import com.pokemon.model.pokemon.instances.Ivysaur;
public class generatePokemonInstance {
    public static AbstractPokemon getInstance(String pokemonName) {
      AbstractPokemon instance = null;

      switch (pokemonName){
        case "Arcaine":
            instance = new Arcaine();
            break;
        case "Bulbasaur":
            instance = new Bulbasaur();
            break;
        case "Charmander":
            instance = new Charmander();
            break;
        case "Squirtle":
            instance = new Squirtle();
            break;
        case "Poliwag":
            instance = new Poliwag();
            break;
        case "Gloom":
            instance = new Gloom();
            break;
        case "Wartortle":
            instance = new Wartortle();
            break;
        case "Poliwhirl":
            instance = new Poliwhirl();
            break;
        case "Growlithe":
            instance = new Growlithe();
            break;
        case "Charizard":
            instance = new Charizard();
            break;
        case "Ivysaur":
            instance = new Ivysaur();
            break;
        default:
            break;
      }
    return instance;
  }
}