package pokemon.abstractTypesClasses;

import pokemon.abstractTypes.fire;

public abstract class AbstractFirePokemon
    extends AbstractPokemon
    implements fire {

    public AbstractFirePokemon(String name) {
        super(
            name,
            "Fuego",
            new String[] { "Ascuas", "Lanza llamas", "Giro fuego", "Inferno" }
        );
        this.movements = super.movements;
    }

    @Override
    public int Ascuas() {
        return 10;
    }

    @Override
    public int lanzallamas() {
        return 15;
    }

    @Override
    public int giroFuego() {
        return 20;
    }

    @Override
    public int infierno() {
        return 30;
    }

    @Override
    public int firstMovement() {
        return Ascuas();
    }

    @Override
    public int seccondMovement() {
        return lanzallamas();
    }

    @Override
    public int thirdMovement() {
        return giroFuego();
    }

    @Override
    public int fourthMovement() {
        return infierno();
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
