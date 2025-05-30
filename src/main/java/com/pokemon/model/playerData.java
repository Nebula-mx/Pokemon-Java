package com.pokemon.model;

import com.pokemon.model.pokemon.abstractTypesClasses.AbstractPokemon;

public class playerData {
  private String userName;
  private Boolean isUserAlife = true;
  private static playerData instance;
  private AbstractPokemon userPokemon;

  private playerData(){}
  public static playerData getInstance(){
    if(instance == null){
      instance = new playerData();
    }
    return instance;
  }


  public Boolean getIsUserAlife() {
    return isUserAlife;
  }
  public void setIsUserAlife(Boolean isUserAlife) {
    this.isUserAlife = isUserAlife;
  }
  public String getUserName() {
    return userName;
  }
  public void setUserName(String userName) {
    this.userName = userName;
  }
  public AbstractPokemon getUserPokemon() {
    return userPokemon;
  }
  public void setUserPokemon(AbstractPokemon userPokemon) {
    this.userPokemon = userPokemon;
  }

  
}