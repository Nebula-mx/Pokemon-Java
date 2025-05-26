package com.pokemon.model.pokemon;

import com.pokemon.model.pokemon.abstractTypesClasses.AbstractPokemon;

import java.util.Random;

public class Batalla {
    public static void iniciar(AbstractPokemon jugador, AbstractPokemon rival) {
        System.out.println("¡Combate iniciado!");

        while (jugador.getHealth() > 0 && rival.getHealth() > 0) {
            // Turno jugador
            System.out.println("\n--- Tu turno ---");
            jugador.doDamage(rival, 1);
            if (rival.getHealth() <= 0) {
                System.out.println("¡Ganaste!");
                break;
            }

            // Turno rival (CPU)
            System.out.println("\n--- Turno rival ---");
            Random random = new Random();
            int numero = random.nextInt(4) + 1;
            rival.doDamage(jugador, numero);
        }
    }
}
