package com.pokemon.controllers;

import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.Event;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class selectPokemonMenu {
    private final spritesLoader SpriteLoader = new spritesLoader();
    private Clip clip;
    private int selectId = 0;
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

        contenedorCharmander.getProperties().put("selectId", "0");
        contenedorSquirtle.getProperties().put("selectId", "1");
        contenedorBulbasaur.getProperties().put("selectId", "2");
        contenedorArcaine.getProperties().put("selectId", "3");
        contenedorPoliwag.getProperties().put("selectId", "4");
        contenedorOddish.getProperties().put("selectId", "5");
        
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

        bulbasaurImage.setImage(SpriteLoader.getSprites("Bulbasaur", "Bulbasaur", "planta", 3).get(0));
        charmanderImage.setImage(SpriteLoader.getSprites("Charmander", "Charmander", "fuego", 3).get(0));
        oddishImage.setImage(SpriteLoader.getSprites("Oddish", "Oddish", "planta", 3).get(0));
        poliwagImage.setImage(SpriteLoader.getSprites("Poliwag", "Poliwag", "agua", 3).get(0));
        squirtleImage.setImage(SpriteLoader.getSprites("Squirtle", "Squirtle", "agua", 3).get(0));
        arcaineImage.setImage(SpriteLoader.getSprites("Arcaine", "Arcaine", "fuego", 3).get(0));

        startAnimation("Charmander");
    }

    private void animateElement(ImageView imagen, String nombre, String especifico, String tipo, int frames) {
        if (currentAnimation != null) currentAnimation.stop();
        currentAnimation = SpriteLoader.createAnimation(imagen, nombre, especifico, tipo, frames);
        currentAnimation.play();
    }
    
    @FXML
    void onSeleccionarArcaine(Event event) {
        startAnimation("Arcaine");
    }

    @FXML
    void onSeleccionarBulbasaur(Event event) {
        startAnimation("Bulbasaur");
    }

    @FXML
    void onSeleccionarCharmander(Event event) {
        startAnimation("Charmander");
    }

    @FXML
    void onSeleccionarOddish(Event event) {
        startAnimation("Oddish");
    }

    @FXML
    void onSeleccionarPoliwag(Event event) {
        startAnimation("Poliwag");
    }

    @FXML
    void onSeleccionarSquirtle(Event event) {
        startAnimation("Squirtle");
    }
    @FXML
    void selectPokemon(Event event) {
        Node node = (Node) event.getSource();
        playerData currentUser = playerData.getInstance();
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
    void startAnimation(String pokemonName) {
        if (currentAnimation != null) {
            currentAnimation.stop();
        }
        switch (pokemonName) {
            case "Bulbasaur":
                animateElement(bulbasaurImage, "Bulbasaur", "Bulbasaur", "planta", 3);
                break;
            case "Charmander":
                animateElement(charmanderImage, "charmander", "charmander", "fuego", 4);
                break;
            case "Squirtle":
                animateElement(squirtleImage, "Squirtle", "Squirtle", "agua", 4);
                break;
            case "Oddish":
                animateElement(oddishImage, "Oddish", "Oddish", "planta", 5);
                break;
            case "Poliwag":
                animateElement(poliwagImage, "Poliwag", "Poliwag", "agua", 4);
                break;
            case "Arcaine":
                animateElement(arcaineImage, "Arcaine", "Arcaine", "fuego", 4);
                break;
            default:
                break;
        }
    }
    @FXML
    void keySelectPokemon(KeyEvent event) {
        String keyCode = event.getCode().toString();
        Node node = (Node) event.getSource();
        List<Node> childs = ((Pane) node).getChildren();

        if(selectId < 0 || selectId >= childs.size()) {
            selectId = 0;
        }
        
        System.out.println(keyCode);
        if(keyCode.equals("LEFT")) {
            selectId--;
            if(selectId < 0){
                selectId = 0;
            }
            startAnimation(childs.get(selectId).getProperties().get("pokemonName").toString());
            System.out.println(childs.get(selectId).getProperties().get("pokemonName"));
        } else if(keyCode.equals("RIGHT")){
            if(selectId < 5){
                selectId++;
            } else{
                selectId = 5;
            }
            System.out.println(childs.get(selectId).getProperties().get("pokemonName"));
            startAnimation(childs.get(selectId).getProperties().get("pokemonName").toString());
        } else if(keyCode.equals("ENTER")) {
            node = childs.get(selectId);
            playerData currentUser = playerData.getInstance();
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
    }
}
