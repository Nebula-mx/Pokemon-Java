package com.pokemon.utils;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class spritesLoader {
    private static final int VELOCIDAD_MS = 100;

    public List<Image> getSrites(String nombre, String nombreEspecifico, String tipo, int frames){
        List<Image> sprites = new ArrayList<>();
        String RUTA_FOTOGRAMAS = "/com/pokemon/media/pictures/sprites/" + tipo + "/" + nombre + "/sprite" + nombreEspecifico + "/" + nombreEspecifico;

        for (int i = 1; i <= frames; i++) {
            String rutaImagen = RUTA_FOTOGRAMAS + i + ".png";
            URL urlImagen = getClass().getResource(rutaImagen);

            if (urlImagen != null) {
                Image imagen = new Image(urlImagen.toExternalForm());
                sprites.add(imagen);
            } else {
                System.out.println("Archivo no encontrado: " + rutaImagen);
            }
        }

        return sprites;
    }
    public Timeline createAnimation(String nombre, String nombreEspecifico, String tipo, int frames) {
        List<Image> sprites = new ArrayList<>();
        // Usa los valores
        String RUTA_FOTOGRAMAS = "/com/pokemon/media/pictures/sprites/" + tipo + "/" + nombre + "/sprite" + nombreEspecifico + "/" + nombreEspecifico;

        ImageView imageView = new ImageView();
        Timeline timeline = new Timeline();

        for (int i = 1; i <= frames; i++) {
            String rutaImagen = RUTA_FOTOGRAMAS + i + ".png";
            URL urlImagen = getClass().getResource(rutaImagen);

            if (urlImagen != null) {
                Image imagen = new Image(urlImagen.toExternalForm());
                KeyFrame keyFrame = new KeyFrame(Duration.millis(VELOCIDAD_MS * (i + 1)), e -> imageView.setImage(imagen));
                timeline.getKeyFrames().add(keyFrame);
            } else {
                System.out.println("Archivo no encontrado: " + rutaImagen);
            }
        }

        timeline.setCycleCount(Timeline.INDEFINITE);
        return timeline;
    }
}
