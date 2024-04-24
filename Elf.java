/**
 * Elf creature behavior
 *
 */
public class Elf extends MagicalCreature {
    public boolean shield; //Elf has shielded or doesn't
    /**
     * Constructor for Elf that uses the parent constructor, sets shield to false
     * @param name Name of creature
     * @param type type of create
     * @param color color of creature
     * @param age age of creature
     *
     */
    public Elf(String name, String type, String color, int age) {
        super(name, type, color, age);
        this.shield = false;
    }
    /**
     * Empty constructor for Elf that uses the parent constructor, sets shield is false
     *
     */
    public Elf() {
        super ("", "", "", 0);
        this.shield =false;
    }

    /**
     * Overrides super toString
     * @return Super toString plus more depending on if the elf has a shield
     */
    public String toString() {
        if (shield) {
            return super.toString() + " I eat leaves, I have a shield";
        } else {
            return super.toString() + "I eat leaves, I have no shield";
        }
    }

    /**
     * Sets Shield
     * @param shield Sets Shield
     */
    public void setShield(boolean shield) {
        this.shield = shield;
    }

    /**
     * Gets shields value
     * @return shields value
     */
    public boolean getShield() {
        return shield;
    }

    /**
     * If the elf does not have a shield, dies, otherwise, is saved and alive
     */
    public void die() {
        if (shield) {
            System.out.println("I have a shield, I can not die! ");
            isAlive = true;
        } else {
            super.die();
        }
    }
}
