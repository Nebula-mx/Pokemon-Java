package com.pokemon.controllers;

import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import com.pokemon.utils.spritesLoader;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

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
        System.out.println(getClass().getResource("/com/pokemon/media/pictures/selectPokemonMenu/selectMenuBg.jpg"));
        playStartAudio();

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
    void stopAnimation(MouseEvent event) {
        currentAnimation.stop();

    }
}
