package com.pokemon.controllers;

import com.pokemon.model.playerData;

import javafx.fxml.FXML;

public class Batalla {
  @FXML
  public void initialize(){
    playerData currentPlayer = playerData.getInstance();

    System.out.println(currentPlayer.getUserPokemon().getName());
  }

}
