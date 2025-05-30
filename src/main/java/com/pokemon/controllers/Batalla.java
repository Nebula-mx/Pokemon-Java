package com.pokemon.controllers;

import com.pokemon.model.playerData;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;

import java.util.Random;

public class Batalla {

  @FXML
  private ImageView backgroundImage; // Referencia al fondo de batalla

  // Rutas de los fondos dentro de resources
  private final String[] backgrounds = {
          "/com/pokemon/media/pictures/BatallaView/fondoBatalla1.png",
          "/com/pokemon/media/pictures/BatallaView/fondoBatalla2.png",
          "/com/pokemon/media/pictures/BatallaView/fondoBatalla3.png"
  };

  @FXML
  public void initialize() {

    playerData currentPlayer = playerData.getInstance();
    System.out.println(currentPlayer.getUserPokemon().getName());

    setRandomBackground();
  }

  //fondos aleatorios
  private void setRandomBackground() {
    Random random = new Random();
    String selectedBackground = backgrounds[random.nextInt(backgrounds.length)];

    try {
      Image image = new Image(getClass().getResource(selectedBackground).toExternalForm());
      backgroundImage.setImage(image);

      //ajustar el fondo para que ocupe toda la pantalla
      backgroundImage.sceneProperty().addListener((obs, oldScene, newScene) -> {
        if (newScene != null) {
          backgroundImage.fitWidthProperty().bind(newScene.widthProperty());
          backgroundImage.fitHeightProperty().bind(newScene.heightProperty());
        }
      });

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}