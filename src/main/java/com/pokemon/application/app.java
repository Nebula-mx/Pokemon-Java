package com.pokemon.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class
app extends Application {
    @Override
    //este metodo solo se encarga de hacer que aparezca la ventana del juego con una resolucion de 1295 x 969, si, esta chistosa la resolucion xd
    //tambien se le da el titulo a la ventana y se carga la vista, no es necesario cambiar nada aqui.
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/pokemon/startView.fxml")); //define la ruta de la vista principal

        Scene scene = new Scene(root, 1295, 969); //define la ventana y el contenido
        primaryStage.setTitle("Pokemon java edition"); //le da titulo a la ventana
        primaryStage.setScene(scene); // pone la escena e inicia la ventana.
        primaryStage.show();
    }

    public static void main() {
        launch();
    }
}
