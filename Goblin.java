/**
 * Goblin Creature behavior
 */
public class Goblin extends MagicalCreature{
    /**
     * Constructor for Goblin that uses the parent constructor
     * @param name Name of creature
     * @param type type of create
     * @param color color of creature
     * @param age age of creature
     *
     */
    public Goblin(String name, String type, String color, int age) {
        super(name, type, color, age);
    }

    /**
     * Empty Constructor
     */
    public Goblin() {
        super("", "","",0);
    }

    /**
     * Overrides super constructor
     * @return uses super constructor then adds some more
     */
    public String toString() {
        return super.toString() + " I kill elves if they do not have shields";
    }
}
