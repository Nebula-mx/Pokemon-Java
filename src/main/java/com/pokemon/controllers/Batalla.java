package com.pokemon.controllers;

import com.pokemon.model.playerData;
import com.pokemon.utils.spritesLoader;
import com.pokemon.utils.getPokemonSpritesRoute;
import com.pokemon.utils.generatePokemonInstance;
import com.pokemon.model.pokemon.abstractTypesClasses.AbstractPokemon;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;
import java.util.Objects;

public class Batalla {
    private playerData currentPlayer;
    private AbstractPokemon userPokemon;
    private AbstractPokemon oponentPokemon;
    private spritesLoader SpriteLoader = new spritesLoader();
    private boolean gameRunning = true;

    private static final int PLAYER_TURN = 0;
    private static final int CPU_TURN = 1;
    private int currentOwner = PLAYER_TURN;

    private String[] pokemonNames = {
        "Arcaine", "Bulbasaur", "Charmander", "Squirtle",
        "Poliwag", "Gloom", "Wartortle", "Poliwhirl",
        "Growlithe", "Charizard", "Ivysaur", "Oddish"
    };

    @FXML
    private ImageView backgroundImage;

    @FXML
    private Button firstMovement, secondMovement, thirdMovement, fourthMovement;

    private final String[] backgrounds = {
        "/com/pokemon/media/pictures/BatallaView/fondoBatalla1.png",
        "/com/pokemon/media/pictures/BatallaView/fondoBatalla2.png",
        "/com/pokemon/media/pictures/BatallaView/fondoBatalla3.png"
    };

    @FXML
    private Text opponentName, battleLog, playerHealth, opponentHealth;

    @FXML
    private ImageView opponentSprite;

    @FXML
    private HBox playerDataContainer;

    @FXML
    private Text playerName;

    @FXML
    private ImageView playerSprite;

    @FXML
    private HBox pokemonsContainer;

    @FXML
    public void initialize() {
        currentPlayer = playerData.getInstance();
        userPokemon = currentPlayer.getUserPokemon();

        if (userPokemon != null) {
            firstMovement.setText(userPokemon.movements[0]);
            secondMovement.setText(userPokemon.movements[1]);
            thirdMovement.setText(userPokemon.movements[2]);
            fourthMovement.setText(userPokemon.movements[3]);

            String[] spritePathData = getPokemonSpritesRoute.getRoute(userPokemon.getName());
            Image spriteImage = SpriteLoader.getSprites(
                spritePathData[0], spritePathData[1], spritePathData[2],
                Integer.parseInt(spritePathData[3])
            ).get(0);

            try {
                playerSprite.setImage(spriteImage);
            } catch (NullPointerException e) {
                System.out.println("No se encontró el sprite para " + userPokemon.getName());
            }

        } else {
            System.out.println("No se ha seleccionado un Pokémon.");
        }

        setRandomBackground();
        loadOpponent();
        playerName.setText(currentPlayer.getUserName());
        playerHealth.setText("Vida: " + userPokemon.getHealth());
        opponentName.setText(oponentPokemon.getName());
        opponentHealth.setText("Vida: " + oponentPokemon.getHealth());
        battleLog.setText("¡La batalla ha comenzado!");

    }

    private void setRandomBackground() {
        int randomIndex = (int) (Math.random() * backgrounds.length);
        String selectedBackground = backgrounds[randomIndex];

        try {
            Image image = new Image(Objects.requireNonNull(getClass().getResource(selectedBackground)).toExternalForm());
            backgroundImage.setImage(image);

            backgroundImage.sceneProperty().addListener((obs, oldScene, newScene) -> {
                if (newScene != null) {
                    backgroundImage.fitWidthProperty().bind(newScene.widthProperty());
                    backgroundImage.fitHeightProperty().bind(newScene.heightProperty());
                }
            });

        } catch (NullPointerException e) {
            System.out.println("No se encontró la imagen de fondo.");
        }
    }

    private void loadOpponent() {
        String oponentName = pokemonNames[getRandomPokemonIndex()];
        // Este método genera un oponente aleatorio (por ahora usa el mismo tipo de Pokémon)
        oponentPokemon = generatePokemonInstance.getInstance(oponentName); // aquí deberías usar una factory si tienes una

        String[] spritePathData = getPokemonSpritesRoute.getRoute(oponentPokemon.getName());
        Image spriteImage = SpriteLoader.getSprites(
            spritePathData[0], spritePathData[1], spritePathData[2],
            Integer.parseInt(spritePathData[3])
        ).get(0);

        opponentSprite.setImage(spriteImage);
        opponentName.setText(oponentPokemon.getName());
    }

    private int getRandomPokemonIndex() {
        return (int) (Math.random() * pokemonNames.length);
    }

    private void handleMovements(int movementId) {
    if (!currentPlayer.getIsUserAlife()) return;

    if (currentOwner == PLAYER_TURN) {
        int damage = userPokemon.doMovement(movementId);
        if (damage != -1) {
            userPokemon.doDamage(oponentPokemon, movementId);
            battleLog.setText("Has usado " + userPokemon.movements[movementId] + " contra " + oponentPokemon.getName());
            System.out.println("Has hecho " + damage + " de daño al oponente.");

            // 🔹 Forzar actualización de la vida del enemigo en la interfaz
            Platform.runLater(() -> opponentHealth.setText("Vida: " + oponentPokemon.getHealth()));

            if (oponentPokemon.getHealth() <= 0) {
                battleLog.setText("¡Has derrotado a " + oponentPokemon.getName() + "! Nuevo enemigo aparece...");
                loadNewOpponent();
                userPokemon.setHealth(100);
                oponentPokemon.setHealth(100);

                // 🔹 Actualizar las barras de vida con la nueva batalla
                Platform.runLater(() -> {
                    playerHealth.setText("Vida: " + userPokemon.getHealth());
                    opponentHealth.setText("Vida: " + oponentPokemon.getHealth());
                });

                return;
            }

            currentOwner = (damage == -1) ? PLAYER_TURN : CPU_TURN;
            nextTurn();
        }
    }
}

private void loadNewOpponent() {
    String newOpponentName = pokemonNames[getRandomPokemonIndex()]; // Obtener un nuevo Pokémon aleatorio
    oponentPokemon = generatePokemonInstance.getInstance(newOpponentName);

    String[] spritePathData = getPokemonSpritesRoute.getRoute(oponentPokemon.getName());
    Image spriteImage = SpriteLoader.getSprites(
        spritePathData[0], spritePathData[1], spritePathData[2],
        Integer.parseInt(spritePathData[3])
    ).get(0);

    opponentSprite.setImage(spriteImage);
    opponentName.setText(oponentPokemon.getName());
}

   private void nextTurn() {
    if (!currentPlayer.getIsUserAlife()) return;

    // 🔹 Si el enemigo ha sido derrotado, registrar victoria
    if (oponentPokemon.getHealth() <= 0) {
        currentPlayer.incrementWinCount(); // 🔹 Aumentar contador de victorias

        if (currentPlayer.getWinCount() >= 2) { // 🔹 Si el jugador ha ganado 2 batallas, terminar el juego
            battleLog.setText("¡Felicidades! Has ganado el torneo Pokémon.");
            System.out.println("Juego terminado.");
            Platform.runLater(() -> {
                try {
                    Stage stage = (Stage) battleLog.getScene().getWindow();
                    stage.close(); // 🔹 Cierra la ventana de la batalla
                } catch (Exception e) {
                    System.out.println("Error al cerrar la ventana.");
                }
            });
            return;
        }

        battleLog.setText("¡Has derrotado a " + oponentPokemon.getName() + "! Un nuevo enemigo aparece...");
        loadNewOpponent(); // Generar nuevo Pokémon
        userPokemon.setHealth(100);
        oponentPokemon.setHealth(100);

        // 🔹 Asegurar que las barras de vida se refresquen
        Platform.runLater(() -> {
            playerHealth.setText("Vida: " + userPokemon.getHealth());
            opponentHealth.setText("Vida: " + oponentPokemon.getHealth());
            opponentName.setText(oponentPokemon.getName());
        });

        currentOwner = PLAYER_TURN; // 🔹 Reiniciar turno al jugador
        return;
    }

    if (currentOwner == CPU_TURN) {
        int cpuMove = (int) (Math.random() * 4);
        if (cpuMove >= oponentPokemon.movements.length) cpuMove = 0;

        int damage = oponentPokemon.doMovement(cpuMove);

        if (damage != -1) {
            oponentPokemon.doDamage(userPokemon, cpuMove);
            battleLog.setText("El enemigo usó " + oponentPokemon.movements[cpuMove] + " contra ti");

            Platform.runLater(() -> playerHealth.setText("Vida: " + userPokemon.getHealth()));

            if (userPokemon.getHealth() <= 0) {
                battleLog.setText("Has perdido la batalla.");
                currentPlayer.setIsUserAlife(false);
                return;
            }
        } else {
            System.out.println("El CPU falló su movimiento.");
        }

        currentOwner = PLAYER_TURN;
    }
}

    // Botones de movimientos
    @FXML
    void handleFirstMove() {
        handleMovements(0);
    }

    @FXML
    void handleSecondMove() {
        handleMovements(1);
    }

    @FXML
    void handleThirdMove() {
        handleMovements(2);
    }

    @FXML
    void handleFourthMove() {
        handleMovements(3);
    }
}
