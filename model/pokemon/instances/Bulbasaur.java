package pokemon.model.pokemon.instances;

import pokemon.model.pokemon.abstractTypesClasses.AbstractGrassPokemon;
import pokemon.model.pokemon.abstractTypesClasses.Ataque;
import java.io.Serializable;

public class Bulbasaur extends AbstractGrassPokemon implements Serializable {
    private static final long serialVersionUID = 2L;  // Diferente para cada Pokémon

    public Bulbasaur() {
        super("Bulbasaur", "HIERBA", new String[]{"Latigazo", "Drenadoras", "Hoja Afilada", "Placaje"});
        setEvolution("Ivysaur", 5);  // Evoluciona a nivel 5
        
        // Ataques iniciales
        aprenderAtaque(new Ataque("Latigazo", 45, "HIERBA"));
        aprenderAtaque(new Ataque("Drenadoras", 20, "HIERBA"));  // Recupera vida
    }

    // --- Implementación de movimientos ---
    @Override
    public int firstMovement() {
        return getAtaques().get(0).getPotencia();  // Latigazo
    }

    @Override
    public int seccondMovement() {
        int danio = getAtaques().get(1).getPotencia();  // Drenadoras
        this.health += danio / 2;  // Recupera la mitad del daño
        return danio;
    }

    @Override
    public int thirdMovement() {
        return 50;  // Hoja Afilada (daño alto)
    }

    @Override
    public int fourthMovement() {
        return 35;  // Placaje
    }

    @Override
    public void levelUp() {
        super.levelUp();
        if (getLevel() == 5) {
            System.out.println("¡Bulbasaur está emanando energía floral!");
        }
    }
}
