package pokemon.abstractTypesClasses;

public abstract class AbstractPokemon {

    private String name;
    private int level;
    private int health;
    public String[] movements;
    public String type;

    public AbstractPokemon(String name, String type, String[] movements) {
        this.name = name;
        this.level = 1;
        this.health = 100;
        this.movements = movements;
    }

    public void levelUp() {
        this.level++;
        this.health += 20;
        System.out.println(this.name + "ha subido al nivel" + this.level);
    }

    public abstract int firstMovement();

    public abstract int seccondMovement();

    public abstract int thirdMovement();

    public abstract int fourthMovement();

    public int doMovement(int movementId) {
        if (movementId == 1) {
            int result = firstMovement();
            System.out.println(
                this.name +
                " atacó con " +
                this.movements[movementId] +
                " e hizo " +
                result +
                " de daño"
            );
            return result;
        } else if (movementId == 2) {
            int result = seccondMovement();
            System.out.println(
                this.name +
                " atacó con " +
                this.movements[movementId] +
                " e hizo " +
                result +
                " de daño"
            );
            return result;
        } else if (movementId == 3) {
            int result = thirdMovement();
            System.out.println(
                this.name +
                " atacó con " +
                this.movements[movementId] +
                " e hizo " +
                result +
                " de daño"
            );
            return result;
        } else if (movementId == 4) {
            int result = fourthMovement();
            System.out.println(
                this.name +
                " atacó con " +
                this.movements[movementId] +
                " e hizo " +
                result +
                " de daño"
            );
            return result;
        } else {
            System.out.println("Movimiento no valido");
        }
        return -1;
    }

    public int getHurt(int damage) {
        this.health -= damage;
        System.out.println(
            this.name + " ha recibido " + damage + " puntos de daño"
        );
        return this.health;
    }

    public void showInfo() {
        System.out.println(
            this.name +
            ": Vida actual: " +
            this.health +
            ", Nivel: " +
            this.level
        );
    }

    public int getHealth() {
        return this.health;
    }
}
