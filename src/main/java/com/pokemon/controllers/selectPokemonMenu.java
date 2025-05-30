package com.pokemon.controllers;

import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

import com.pokemon.application.changeScene;
import com.pokemon.model.playerData;
import com.pokemon.model.pokemon.instances.Arcaine;
import com.pokemon.model.pokemon.instances.Bulbasaur;
import com.pokemon.model.pokemon.instances.Charmander;
import com.pokemon.model.pokemon.instances.Oddish;
import com.pokemon.model.pokemon.instances.Poliwag;
import com.pokemon.model.pokemon.instances.Squirtle;
import com.pokemon.utils.spritesLoader;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class selectPokemonMenu {
    private final spritesLoader SpriteLoader = new spritesLoader();
    private Clip clip;
    @FXML
    private VBox container;
    private Timeline currentAnimation;
    @FXML
    private VBox contenedorArcaine;

    @FXML
    private VBox contenedorBulbasaur;

    @FXML
    private VBox contenedorCharmander;

    @FXML
    private VBox contenedorOddish;

    @FXML
    private VBox contenedorPoliwag;

    @FXML
    private VBox contenedorSquirtle;
    @FXML
    private ImageView bulbasaurImage;

    @FXML
    private ImageView charmanderImage;

    @FXML
    private ImageView oddishImage;

    @FXML
    private ImageView poliwagImage;

    @FXML
    private ImageView squirtleImage;

    @FXML
    private ImageView arcaineImage;

    private void playStartAudio(){
        try {
            String fileURL = "src/main/resources/com/pokemon/media/audio/hurryAlong.wav";

            AudioInputStream aus = AudioSystem.getAudioInputStream(new File(fileURL).getAbsoluteFile());

            clip = AudioSystem.getClip();
            clip.open(aus);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void initialize(){
        playStartAudio();

        contenedorArcaine.getProperties().put("pokemonName", "Arcaine");
        contenedorBulbasaur.getProperties().put("pokemonName", "Bulbasaur");
        contenedorCharmander.getProperties().put("pokemonName", "Charmander");
        contenedorOddish.getProperties().put("pokemonName", "Oddish");
        contenedorPoliwag.getProperties().put("pokemonName", "Poliwag");
        contenedorSquirtle.getProperties().put("pokemonName", "Squirtle");
        
        contenedorArcaine.getProperties().put("goToPage", "Batalla.fxml");
        contenedorBulbasaur.getProperties().put("goToPage", "Batalla.fxml");
        contenedorCharmander.getProperties().put("goToPage", "Batalla.fxml");
        contenedorOddish.getProperties().put("goToPage", "Batalla.fxml");
        contenedorPoliwag.getProperties().put("goToPage", "Batalla.fxml");
        contenedorSquirtle.getProperties().put("goToPage", "Batalla.fxml");

        URL imageUrl = getClass().getResource("/com/pokemon/media/pictures/selectPokemonMenu/selectMenuBg.jpg");
        container.setStyle(
                "-fx-background-image: url('" + imageUrl + "');" +
                        "-fx-background-repeat: no-repeat;" +
                        "-fx-background-position: center center;" +
                        "-fx-background-size: cover;"
        );

        bulbasaurImage.setImage(SpriteLoader.getSrites("Bulbasaur", "Bulbasaur", "planta", 3).get(0));
        charmanderImage.setImage(SpriteLoader.getSrites("Charmander", "Charmander", "fuego", 3).get(0));
        oddishImage.setImage(SpriteLoader.getSrites("Oddish", "Oddish", "planta", 3).get(0));
        poliwagImage.setImage(SpriteLoader.getSrites("Poliwag", "Poliwag", "agua", 3).get(0));
        squirtleImage.setImage(SpriteLoader.getSrites("Squirtle", "Squirtle", "agua", 3).get(0));
        arcaineImage.setImage(SpriteLoader.getSrites("Arcaine", "Arcaine", "fuego", 3).get(0));
    }

    private void animateElement(ImageView imagen, String nombre, String especifico, String tipo, int frames) {
        if (currentAnimation != null) currentAnimation.stop();
        currentAnimation = SpriteLoader.createAnimation(imagen, nombre, especifico, tipo, frames);
        currentAnimation.play();
    }
    
    @FXML
    void onSeleccionarArcaine(MouseEvent event) {
        animateElement(arcaineImage, "Arcaine", "Arcaine", "fuego", 4);
    }

    @FXML
    void onSeleccionarBulbasaur(MouseEvent event) {
        animateElement(bulbasaurImage, "Bulbasaur", "Bulbasaur", "planta", 3);
    }

    @FXML
    void onSeleccionarCharmander(MouseEvent event) {
        animateElement(charmanderImage, "Charmander", "Charmander", "fuego", 4);
    }

    @FXML
    void onSeleccionarOddish(MouseEvent event) {
        animateElement(oddishImage, "Oddish", "Oddish", "planta", 5);
    }

    @FXML
    void onSeleccionarPoliwag(MouseEvent event) {
        animateElement(poliwagImage, "Poliwag", "Poliwag", "agua", 4);
    }

    @FXML
    void onSeleccionarSquirtle(MouseEvent event) {
        animateElement(squirtleImage, "Squirtle", "Squirtle", "agua", 4);
    }
    @FXML
    void selectPokemon(MouseEvent event) {
        playerData currentUser = playerData.getInstance();
        Node node = (Node) event.getSource();
        String selectedPokemon = (String) node.getProperties().get("pokemonName");
        System.out.println(selectedPokemon);
        switch (selectedPokemon) {
            case "Bulbasaur":
                currentUser.setUserPokemon(new Bulbasaur());
                break;
            case "Charmander":
                currentUser.setUserPokemon(new Charmander());
                break;
            case "Squirtle":
                currentUser.setUserPokemon(new Squirtle());
                break;
            case "Oddish":
                currentUser.setUserPokemon(new Oddish());
                break;
            case "Poliwag":
                currentUser.setUserPokemon(new Poliwag());
                break;
            case "Arcaine":
                currentUser.setUserPokemon(new Arcaine());
                break;
            default:
                break;
        }

        clip.close();
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
    void stopAnimation(MouseEvent event) {
        currentAnimation.stop();

    }
}
