package pokemon.model.pokemon.instances;

import pokemon.model.pokemon.abstractTypesClasses.AbstractWaterPokemon;
import pokemon.model.pokemon.abstractTypesClasses.Ataque;
import java.io.Serializable;

public class Squirtle extends AbstractWaterPokemon implements Serializable {
    private static final long serialVersionUID = 1L;  // Identificador único para el guardado

    public Squirtle() {
        super("Squirtle", "AGUA", new String[]{"Pistola Agua", "Burbuja", "Cabezazo", "Refugio"});
        setEvolution("Wartortle", 5);  // Evoluciona a nivel 5
        
        // Ataques iniciales
        aprenderAtaque(new Ataque("Pistola Agua", 50, "AGUA"));
        aprenderAtaque(new Ataque("Burbuja", 40, "AGUA"));
    }

    // --- Implementación de movimientos (requeridos por la clase abstracta) ---
    @Override
    public int firstMovement() {
        return getAtaques().get(0).getPotencia();  // Pistola Agua
    }

    @Override
    public int seccondMovement() {
        return getAtaques().get(1).getPotencia();  // Burbuja
    }

    @Override
    public int thirdMovement() {
        return 30;  // Daño base para Cabezazo (puedes cambiarlo)
    }

    @Override
    public int fourthMovement() {
        return 0;   // Daño base para Refugio (protección)
    }

    @Override
    public void levelUp() {
        super.levelUp();  // Sube de nivel y verifica evolución
        if (getLevel() == 5) {
            System.out.println("¡Squirtle brilla con una luz azulada!");
        }
    }
}
