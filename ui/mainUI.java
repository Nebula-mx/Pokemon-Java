package pokemon.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class mainUI extends Application {
    @Override
    public void start(Stage primaryStage) {

        Label label = new Label("¡Hola JavaFX!");

        StackPane root = new StackPane();
        root.getChildren().add(label);

        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("Mi Primera Aplicación JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main() {
        launch();
    }
}
