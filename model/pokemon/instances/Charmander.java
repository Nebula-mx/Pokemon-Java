package pokemon.model.pokemon.instances;

import pokemon.model.pokemon.abstractTypesClasses.AbstractFirePokemon;
import pokemon.model.pokemon.abstractTypesClasses.Ataque;
import java.io.Serializable;

public class Charmander extends AbstractFirePokemon implements Serializable {
    private static final long serialVersionUID = 3L;

    public Charmander() {
        super("Charmander", "FUEGO", new String[]{"Lanzallamas", "Arañazo", "Garra Dragón", "Ascuas"});
        setEvolution("Charmeleon", 5);
        
        aprenderAtaque(new Ataque("Lanzallamas", 90, "FUEGO"));
        aprenderAtaque(new Ataque("Arañazo", 40, "NORMAL"));
        aprenderAtaque(new Ataque("Garra Dragón", 60, "DRAGÓN"));
        aprenderAtaque(new Ataque("Ascuas", 40, "FUEGO"));
    }

    @Override
    public int firstMovement() {
        return getAtaques().get(0).getPotencia();
    }

    @Override
    public int seccondMovement() {
        return getAtaques().get(1).getPotencia();
    }

    @Override
    public int thirdMovement() {
        return getAtaques().get(2).getPotencia();
    }

    @Override
    public int fourthMovement() {
        return getAtaques().get(3).getPotencia();
    }

    @Override
    public void levelUp() {
        super.levelUp();
        if (getLevel() == 5 && !hasEvolved) {
            System.out.println("¡Charmander brilla intensamente!");
        }
    }
}
