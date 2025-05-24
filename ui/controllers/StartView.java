package pokemon.ui.controllers;

import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import static java.lang.System.out;

public class StartView {

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