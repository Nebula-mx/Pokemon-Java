package com.pokemon.controllers;

import com.pokemon.application.app;

import com.pokemon.application.changeScene;
import com.pokemon.utils.spritesLoader;

import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class StartView {
    private Clip clip;

    @FXML
    private AnchorPane startPage;
    @FXML
    private ImageView backgroundImage;

    private void playStartAudio(){
        try {
            String fileURL = "src/main/resources/com/pokemon/media/audio/pokemonGoldTheme.wav";

            AudioInputStream aus = AudioSystem.getAudioInputStream(new File(fileURL).getAbsoluteFile());

            clip = AudioSystem.getClip();
            clip.open(aus);
            clip.start();

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void initialize(){
        Platform.runLater(() -> startPage.requestFocus());
        startPage.getProperties().put("goToPage", "selectPokemonMenu.fxml");
        spritesLoader loader = new spritesLoader();
        Timeline sprites = loader.createAnimation(backgroundImage, "background", "Bg", "mainMenu", 62);
        sprites.play();


        //la linea de arriba, usa el elmento startPage del documento fxml y le pone la propiedad goToPage
        //y a esa propiedad le pone el nombre de la vista a la que va a ir, en este caso selectPokemonMenu.fxml.

        //el metodo goToSelectMenu es el encargado de preparar los datos que el modulo changeScene necesita
        //el codigo de goToSelectMenu se puede copiar y pegar en los controladores de las vistas que lo nececiten

        //o si alguien es lo suficientemente bondadoso, lo podria poner en una clase aparte y reciclarlo :)
        playStartAudio();
    }
    public void goToSelectMenu(Event event){
        clip.close();
        Node node = (Node) event.getSource();
        String sceneName = (String) node.getProperties().get("goToPage");
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            changeScene changer = new changeScene();
            changer.goTo(sceneName, stage);
        } catch (IOException e){
            System.out.println(e);
        }
    }
    @FXML
    void gotoSelect(Event event) {goToSelectMenu(event);}

}