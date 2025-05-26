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
    private Stage stageWindow;
    @Override
    public void start(Stage primaryStage) throws IOException {
        this.stageWindow = primaryStage;

        Parent root = FXMLLoader.load(
                getClass().getResource("/com/pokemon/startView.fxml")
        );

        Scene scene = new Scene(root);
        primaryStage.setTitle("test de coso jfx");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main() {
        launch();
    }
}
