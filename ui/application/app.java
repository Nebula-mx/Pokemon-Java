package pokemon.ui.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class app extends Application {
    private Stage stageWindow;
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/startView.fxml"));

        AnchorPane pane = (AnchorPane) loader.load();
        Scene scene = new Scene(pane);
        primaryStage.setTitle("test de coso jfx");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main() {
        launch();
    }
}
