module com.pokemon {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.graphics;

    opens com.pokemon.application to javafx.fxml;
    opens com.pokemon.controllers to javafx.fxml;
    exports com.pokemon.application;
    exports com.pokemon.utils;
}
