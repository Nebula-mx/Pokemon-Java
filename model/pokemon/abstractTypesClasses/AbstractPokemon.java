package pokemon.model.pokemon.abstractTypesClasses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPokemon implements Serializable {
    private static final long serialVersionUID = 1L;  // ¡Número mágico para el guardado!

    private String name;
    private int level;
    private int health;
    public String[] movements;
    public String type;
    
    // Campos para evoluciones
    private String nextEvolution;
    private int evolutionLevel;
    private boolean hasEvolved;

    public AbstractPokemon(String name, String type, String[] movements) {
        this.name = name;
        this.level = 1;
        this.health = 100;
        this.movements = movements;
        this.type = type;
        this.hasEvolved = false;
    }

    // --- Métodos existentes ---
    public void levelUp() {
        this.level++;
        this.health += 20;
        System.out.println(this.name + " ha subido al nivel " + this.level);
        checkEvolution();
    }

    public abstract int firstMovement();
    public abstract int seccondMovement();
    public abstract int thirdMovement();
    public abstract int fourthMovement();

    public int doMovement(int movementId) {
        if (movementId < 1 || movementId > 4) {
            System.out.println("Movimiento no válido");
            return -1;
        }
        
        int result = -1;
        switch(movementId) {
            case 1: result = firstMovement(); break;
            case 2: result = seccondMovement(); break;
            case 3: result = thirdMovement(); break;
            case 4: result = fourthMovement(); break;
        }
        
        System.out.println(
            this.name + " atacó con " + this.movements[movementId-1] + 
            " e hizo " + result + " de daño"
        );
        return result;
    }

    public int getHurt(int damage) {
        this.health -= damage;
        System.out.println(this.name + " ha recibido " + damage + " puntos de daño");
        return this.health;
    }

    public void showInfo() {
        System.out.println(
            this.name + ": Vida actual: " + this.health + ", Nivel: " + this.level
        );
        if (nextEvolution != null && !hasEvolved) {
            System.out.println("Evoluciona a " + nextEvolution + " en nivel " + evolutionLevel);
        }
    }

    public int getHealth() {
        return this.health;
    }

    // --- Evoluciones ---
    public void setEvolution(String nextEvolution, int requiredLevel) {
        this.nextEvolution = nextEvolution;
        this.evolutionLevel = requiredLevel;
    }

    private void checkEvolution() {
        if (!hasEvolved && nextEvolution != null && level >= evolutionLevel) {
            evolve();
        }
    }

    private void evolve() {
        System.out.println("¡" + this.name + " está evolucionando a " + nextEvolution + "!");
        this.name = nextEvolution;
        this.health += 50;
        this.hasEvolved = true;
        this.nextEvolution = null;
        System.out.println("¡" + this.name + " ha evolucionado!");
        showInfo();
    }

    // --- Métodos extras ---
    public boolean canEvolve() {
        return nextEvolution != null && level >= evolutionLevel && !hasEvolved;
    }

    public String getNextEvolution() {
        return nextEvolution;
    }
}
