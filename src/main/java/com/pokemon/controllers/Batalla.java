package com.pokemon.controllers;

import com.pokemon.model.playerData;
import com.pokemon.utils.spritesLoader;
import com.pokemon.utils.getPokemonSpritesRoute;
import com.pokemon.utils.generatePokemonInstance;
import com.pokemon.model.pokemon.abstractTypesClasses.AbstractPokemon;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.util.List;
import java.util.Objects;

public class Batalla {
    private playerData currentPlayer;
    private AbstractPokemon userPokemon;
    private AbstractPokemon oponentPokemon;
    private spritesLoader SpriteLoader = new spritesLoader();

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
    private Text opponentName;

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
                
                System.out.println("Has hecho " + damage + " de daño al oponente.");
            } else {
                System.out.println("¡Fallaste! Pierdes tu turno.");
            }

            if (oponentPokemon.getHealth() <= 0) {
                System.out.println("¡Has ganado la batalla!");
                currentPlayer.setIsUserAlife(false);
                return;
            }

            currentOwner = (damage == -1) ? PLAYER_TURN : CPU_TURN;
            nextTurn();
        }
    }

    private void nextTurn() {
        if (currentPlayer.getIsUserAlife() == false) {
            System.out.println("El jugador no está vivo, no puede realizar movimientos.");
            return;
        } else if (oponentPokemon.getHealth() <= 0) {
            System.out.println("El oponente ya ha sido derrotado.");
            return;
        }
        if (currentOwner == CPU_TURN) {
            // Simular movimiento del CPU
            int cpuMove = (int) (Math.random() * 4); // movimiento aleatorio
            int damage = oponentPokemon.doMovement(cpuMove);

            if (damage != -1) {
                oponentPokemon.doDamage(userPokemon, cpuMove);
                System.out.println("El CPU usó el movimiento " + cpuMove + " y causó " + damage + " de daño.");
            } else {
                System.out.println("El CPU falló su movimiento.");
            }

            if (userPokemon.getHealth() <= 0) {
                System.out.println("Has perdido la batalla.");
                currentPlayer.setIsUserAlife(false);
                return;
            }

            currentOwner = (damage == -1) ? CPU_TURN : PLAYER_TURN;
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
