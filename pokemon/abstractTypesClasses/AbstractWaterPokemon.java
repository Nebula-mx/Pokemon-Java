package pokemon.abstractTypesClasses;

import pokemon.abstractTypes.water;

public abstract class AbstractWaterPokemon
    extends AbstractPokemon
    implements water {

    public AbstractWaterPokemon(String name) {
        super(
            name,
            "Agua",
            new String[] {
                "Pistola de agua",
                "Hidro bomba",
                "Rayo burbuja",
                "Surf",
            }
        );
        this.movements = super.movements;
    }

    @Override
    public int pistolaAgua() {
        return 1;
    }

    @Override
    public int hidrobomba() {
        return 2;
    }

    @Override
    public int rayoBurbuja() {
        return 3;
    }

    @Override
    public int surf() {
        return 4;
    }

    @Override
    public int firstMovement() {
        return pistolaAgua();
    }

    @Override
    public int seccondMovement() {
        return hidrobomba();
    }

    @Override
    public int thirdMovement() {
        return rayoBurbuja();
    }

    @Override
    public int fourthMovement() {
        return surf();
    }

    @Override
    public int doMovement(int movementId) {
        return super.doMovement(movementId);
    }

    @Override
    public int getHurt(int damage) {
        return super.getHurt(damage);
    }

    @Override
    public void showInfo() {
        super.showInfo();
    }
}
