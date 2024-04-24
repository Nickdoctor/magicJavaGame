/**
 * Dragon creature behavior
 *
 */
public class Dragon extends MagicalCreature{
    /**
     * Constructor for dragon that uses the parent constructor
     * @param name Name of creature
     * @param type type of create
     * @param color color of creature
     * @param age age of creature
     *
     */
    public Dragon(String name, String type, String color, int age) {
        super(name, type, color, age);
    }

    /**
     * Empty constructor for dragon that uses the parent constructor
     */
    public Dragon() {
        super("","","",0);
    }

    /**
     * Overrides the parent tostring
     * @return String that uses the super string, then adds more
     *
     */
    public String toString() {
        return  super.toString() + "I breathe fire ";
    }

    /**
     * Kill method that kills the other creature if the dragon is older than 40
     * @param other Takes in the other creature to either kill or leave alone
     *
     */
    public void kill (MagicalCreature other) {
        if (this == other) {
            System.out.println("I can not kill myself");
        } else {
            if (age >=40) {
                other.die();
            } else {
                System.out.println("I am too young to kill !");
            }

        }

    }

    /**
     * Dragons can not die
     */
    public void die() {
        System.out.println("I am a dragon - nobody gets to kill me" );
    }
}
