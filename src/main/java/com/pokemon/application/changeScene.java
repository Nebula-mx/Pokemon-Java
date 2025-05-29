package com.pokemon.application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
public class changeScene {

    //este metodo se encarga de cambiar entre escenas, para ello desde el controlador de la vista origen
    //se obtienen 2 cosas escenciales, el sceneName y el stageWindow.
    //el sceneName viene como atributo del elemento fxml que lanzo el evento que requiere del cambio de escena
    //el como se obtiene ese valor se ve como ejemplo en el controlador de StartView.java
    public void goTo(String sceneName, Stage stageWindow) throws IOException {
        try {
            String scenePath = "/com/pokemon/" + sceneName;
            //es sumamente importante que el sceneName coincida con el nombre del archivo fxml que se desea cargar
            // incluyendo la entencion, por ejemplo startView.fxml.
            System.out.println(scenePath);
            Parent root = FXMLLoader.load(getClass().getResource(scenePath));
            Scene scene = new Scene(root);
            stageWindow.setScene(scene);
            stageWindow.show();
        } catch (IOException e){
            System.out.println(e);
        }
    }
}
