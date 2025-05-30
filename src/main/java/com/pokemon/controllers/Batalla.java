package com.pokemon.controllers;

import com.pokemon.model.playerData;
import com.pokemon.model.pokemon.abstractTypesClasses.AbstractPokemon;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Objects;

public class Batalla {

    @FXML
    private ImageView backgroundImage, playerSprite;
    @FXML
    private Button firstMovement, secondMovement, thirdMovement, fourthMovement;

    //Fondos aleatorios
    private final String[] backgrounds = {
            "/com/pokemon/media/pictures/BatallaView/fondoBatalla1.png",
            "/com/pokemon/media/pictures/BatallaView/fondoBatalla2.png",
            "/com/pokemon/media/pictures/BatallaView/fondoBatalla3.png"
    };

    @FXML
    public void initialize() {
        playerData currentPlayer = playerData.getInstance();
        AbstractPokemon userPokemon = currentPlayer.getUserPokemon();

        if (userPokemon != null) {
            // Asignar nombres de los movimientos a los botones
            firstMovement.setText(userPokemon.movements[0]);
            secondMovement.setText(userPokemon.movements[1]);
            thirdMovement.setText(userPokemon.movements[2]);
            fourthMovement.setText(userPokemon.movements[3]);

            // Cargar el sprite del Pokémon seleccionado
            String spritePath = "/com/pokemon/media/sprites/" + userPokemon.getName().toLowerCase() + ".png";
            try {
                playerSprite.setImage(new Image(Objects.requireNonNull(getClass().getResource(spritePath)).toExternalForm()));
            } catch (NullPointerException e) {
                System.out.println("No se encontró el sprite para " + userPokemon.getName());
            }
        } else {
            System.out.println("No se ha seleccionado un Pokémon.");
        }

        setRandomBackground();
    }

    // Método para establecer un fondo aleatorio
    private void setRandomBackground() {
        int randomIndex = (int) (Math.random() * backgrounds.length);
        String selectedBackground = backgrounds[randomIndex];

        try {
            Image image = new Image(Objects.requireNonNull(getClass().getResource(selectedBackground)).toExternalForm());
            backgroundImage.setImage(image);

            // ajuste del fondo para que ocupe toda la pantalla
            backgroundImage.sceneProperty().addListener((obs, oldScene, newScene) -> {
                if (newScene != null) {
                    backgroundImage.fitWidthProperty().bind(newScene.widthProperty());
                    backgroundImage.fitHeightProperty().bind(newScene.heightProperty());
                }
            });

        } catch (NullPointerException e) {
            System.out.println("No se encontró la imagen de fondo.");
        }
    }

    //poderes
    @FXML
    void handleFirstMove() {
        playerData.getInstance().getUserPokemon().doMovement(1);
    }

    @FXML
    void handleSecondMove() {
        playerData.getInstance().getUserPokemon().doMovement(2);
    }

    @FXML
    void handleThirdMove() {
        playerData.getInstance().getUserPokemon().doMovement(3);
    }

    @FXML
    void handleFourthMove() {
        playerData.getInstance().getUserPokemon().doMovement(4);
    }
}