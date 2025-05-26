package com.pokemon.controllers;

import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import static java.lang.System.out;

public class StartView {

    private void playStartAudio(){
        try {
            String fileURL = "src/main/resources/com/pokemon/media/audio/pokemonGoldTheme.wav";

            AudioInputStream aus = AudioSystem.getAudioInputStream(new File(fileURL).getAbsoluteFile());

            Clip clip = AudioSystem.getClip();
            clip.open(aus);
            clip.start();

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void initialize(){
        playStartAudio();
    }
    @FXML
    private AnchorPane startPage;

    public void goToSelectMenu() {
        out.println("Sexooo");
    }
    @FXML
    void gotoSelect(MouseEvent event) {goToSelectMenu();}
    @FXML
    void gotoSelect_key(KeyEvent event) {
        out.println(event.getEventType().getName());
        goToSelectMenu();
    }

}