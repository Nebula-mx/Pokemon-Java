package pokemon.abstractTypesClasses;

import pokemon.abstractTypes.grass;

public abstract class AbstractGrassPokemon
    extends AbstractPokemon
    implements grass {

    public AbstractGrassPokemon(String name) {
        super(
            name,
            "Hierva",
            new String[] {
                "Hoja afilada",
                "Latigazo",
                "Drenadoras",
                "Rayo solar",
            }
        );
        this.movements = super.movements;
    }

    @Override
    public int hojaAfilada() {
        return 10;
    }

    @Override
    public int latigazo() {
        return 15;
    }

    @Override
    public int drenadoras() {
        return 20;
    }

    @Override
    public int rayoSolar() {
        return 25;
    }

    @Override
    public int firstMovement() {
        return hojaAfilada();
    }

    @Override
    public int seccondMovement() {
        return latigazo();
    }

    @Override
    public int thirdMovement() {
        return drenadoras();
    }

    @Override
    public int fourthMovement() {
        return rayoSolar();
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
