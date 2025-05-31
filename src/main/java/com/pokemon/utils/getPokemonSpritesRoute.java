package com.pokemon.utils;


public class getPokemonSpritesRoute {
    public static String[] getRoute(String pokemonName) {
      String nombre = ""; 
      String nombreEspecifico = "";; 
      String tipo = ""; 
      String[] finalData = {"", "", "", ""};
      int frames = 0;

      switch (pokemonName){
        case "Arcaine":
            nombre = "Arcanine";
            nombreEspecifico = "Arcanine";
            tipo = "fuego";
            frames = 4;
            break;
        case "Bulbasaur":
            nombre = "Bulbasaur";
            nombreEspecifico = "Bulbasaur";
            tipo = "planta";
            frames = 3;
            break;
        case "Charmander":
            nombre = "Charmander";
            nombreEspecifico = "Charmander";
            tipo = "fuego";
            frames = 4;
            break;
        case "Squirtle":
            nombre = "Squirtle";
            nombreEspecifico = "Squirtle";
            tipo = "agua";
            frames = 4;
            break;
        case "Poliwag":
            nombre = "Poliwag";
            nombreEspecifico = "Poliwag";
            tipo = "agua";
            frames = 4;
            break;
        case "Wartortle":
            nombre = "Squirtle";
            nombreEspecifico = "Wartortle";
            tipo = "agua";
            frames = 4;
            break;
        case "Poliwhirl":
            nombre = "Poliwag";
            nombreEspecifico = "Poliwhirl";
            tipo = "agua";
            frames = 4;
            break;
        case "Growlithe":
            nombre = "Arcanine";
            nombreEspecifico = "Growlithe";
            tipo = "fuego";
            frames = 4;
            break;
        case "Charizard":
            nombre = "Charmander";
            nombreEspecifico = "Charizard";
            tipo = "fuego";
            frames = 4;
            break;
        case "Ivysaur":
            nombre = "Bulbasaur";
            nombreEspecifico = "Ivysaur";
            tipo = "planta";
            frames = 4;
            break;
        default:
            break;
      }

    finalData[0] = nombre;
    finalData[1] = nombreEspecifico;
    finalData[2] = tipo;
    finalData[3] = String.valueOf(frames);
    return finalData;
  }
}