/**
 * Genie behavior class
 */
public class Genie extends MagicalCreature{
    public boolean wand; //Has wand or not
    /**
     * Constructor for Genie that uses the parent constructor, lets wand to false
     * @param name Name of creature
     * @param type type of create
     * @param color color of creature
     * @param age age of creature
     *
     */
    public Genie(String name, String type, String color, int age) {
        super(name, type, color, age);
        this.wand =false;
    }

    /**
     * Default constructor, sets wand to false
     */
    public Genie() {
        super("","","",0);
        this.wand=false;
    }

    /**
     * Overrides super tostring
     * @return Super tostring plus more depending on if it has a wand or not
     */
    public String toString() {
        if (wand) {
            return super.toString() + " I eat leaves, I have a wand";
        } else {
            return super.toString() + "I eat leaves, I have no wand";
        }
    }

    /**
     * Gets wand value
     * @return Wand value
     */
    public boolean getWand() {
        return wand;
    }

    /**
     * Sets wand value
     * @param wand Takes new wand value
     */
    public void setWand(boolean wand) {
        this.wand = wand;
    }

    /**
     * Kills method for genie, if it has a wand, kill, if not no killing
     * @param other Takes in other creature, uses to kill creature
     */

    public void kill(MagicalCreature other) {
        if (this == other) {
            System.out.println("I can not kill myself");
        } else {
            if (wand) {
                other.die();
            } else {
                System.out.println("I cannot kill without my wand ");
            }
        }
    }

}
