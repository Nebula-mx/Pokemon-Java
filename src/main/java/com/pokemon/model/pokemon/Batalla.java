package com.pokemon.model.pokemon;

import com.pokemon.utils.spritesLoader;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import java.util.List;
import java.util.Random;

public class Batalla {
    private ImageView playerSprite;
    private ImageView cpuSprite;
    private Timeline idleAnimationPlayer;
    private Timeline idleAnimationCPU;
    private spritesLoader spriteLoader;

    // Lista de Pokémon enemigos posibles
    private final String[] enemyPokemonNames = {
        "Bulbasaur", "Charmander", "Squirtle", "Oddish", "Poliwag", "Arcaine"
    };

    public Batalla(spritesLoader spriteLoader, String playerName, String type) {
        this.spriteLoader = spriteLoader;

        //Pokémon del jugador
        List<Image> playerImages = spriteLoader.getSprites(playerName, "idle", type, 1);
        if (!playerImages.isEmpty()) {
            this.playerSprite = new ImageView(playerImages.get(0));
        } else {
            System.out.println("Error: No se pudo cargar el sprite del jugador.");
        }

        //Pokémon enemigo aleatorio
        String randomEnemy = generateRandomEnemy();
        List<Image> cpuImages = spriteLoader.getSprites(randomEnemy, "idle", type, 1);
        if (!cpuImages.isEmpty()) {
            this.cpuSprite = new ImageView(cpuImages.get(0));
        } else {
            System.out.println("Error: No se pudo cargar el sprite del enemigo.");
        }

        startIdleAnimations();
    }

    //generar un Pokémon enemigo aleatorio
    private String generateRandomEnemy() {
        Random random = new Random();
        int index = random.nextInt(enemyPokemonNames.length);
        return enemyPokemonNames[index];
    }

    private void startIdleAnimations() {
        Platform.runLater(() -> {
            idleAnimationPlayer = new Timeline(
                    new KeyFrame(Duration.millis(500), e -> playerSprite.setScaleX(1.05)),
                    new KeyFrame(Duration.millis(1000), e -> playerSprite.setScaleX(1))
            );
            idleAnimationPlayer.setCycleCount(Timeline.INDEFINITE);
            idleAnimationPlayer.play();

            idleAnimationCPU = new Timeline(
                    new KeyFrame(Duration.millis(500), e -> cpuSprite.setScaleY(1.05)),
                    new KeyFrame(Duration.millis(1000), e -> cpuSprite.setScaleY(1))
            );
            idleAnimationCPU.setCycleCount(Timeline.INDEFINITE);
            idleAnimationCPU.play();
        });
    }

    public void playAttackAnimation(boolean isPlayer) {
        Platform.runLater(() -> {
            ImageView attacker = isPlayer ? playerSprite : cpuSprite;
            TranslateTransition attackAnim = new TranslateTransition(Duration.millis(300), attacker);
            attackAnim.setByX(20);
            attackAnim.setCycleCount(2);
            attackAnim.setAutoReverse(true);
            attackAnim.play();
        });
    }

    public void playDamageAnimation(boolean isPlayer) {
        Platform.runLater(() -> {
            ImageView defender = isPlayer ? playerSprite : cpuSprite;
            Timeline damageAnim = new Timeline(
                    new KeyFrame(Duration.millis(100), e -> defender.setOpacity(0.5)),
                    new KeyFrame(Duration.millis(200), e -> defender.setOpacity(1))
            );
            damageAnim.setCycleCount(3);
            damageAnim.play();
        });
    }

    public void playEvolutionAnimation(String evolvedName, String type) {
        Platform.runLater(() -> {
            List<Image> evolvedImages = spriteLoader.getSprites(evolvedName, "idle", type, 1);
            if (!evolvedImages.isEmpty()) {
                playerSprite.setImage(evolvedImages.get(0));
            }

            Timeline evolutionAnim = new Timeline(
                    new KeyFrame(Duration.millis(200), e -> playerSprite.setScaleX(1.2)),
                    new KeyFrame(Duration.millis(400), e -> playerSprite.setScaleX(1)),
                    new KeyFrame(Duration.millis(600), e -> playerSprite.setScaleY(1.2)),
                    new KeyFrame(Duration.millis(800), e -> playerSprite.setScaleY(1))
            );
            evolutionAnim.setCycleCount(3);
            evolutionAnim.play();
        });
    }

    public ImageView getPlayerSprite() {
        return playerSprite;
    }

    public ImageView getCpuSprite() {
        return cpuSprite;
    }
}