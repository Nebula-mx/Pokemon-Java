package com.example.pokemon;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;

public class Wartortle extends Application {

    private static final String RUTA_FOTOGRAMAS = "/sprites/agua/squirtle/spriteWartortle/wartortle";
    private static final int NUM_FOTOGRAMAS = 10;
    private static final int VELOCIDAD_MS = 100;

    @Override
    public void start(Stage primaryStage) {
        ImageView imageView = new ImageView();
        Timeline timeline = new Timeline();

        for (int i = 1; i <= NUM_FOTOGRAMAS; i++) {
            String rutaImagen = RUTA_FOTOGRAMAS + i + ".png";
            URL urlImagen = getClass().getResource(rutaImagen);

            if (urlImagen != null) {
                Image imagen = new Image(urlImagen.toExternalForm());
                KeyFrame keyFrame = new KeyFrame(Duration.millis(VELOCIDAD_MS * i), event -> {
                    imageView.setImage(imagen);
                });
                timeline.getKeyFrames().add(keyFrame);
            } else {
                System.out.println("Archivo no encontrado: " + rutaImagen);
            }
        }

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        StackPane root = new StackPane(imageView);
        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("Sprite de Bulbasaur");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
