/**
 * Magical Creature class is used as the parent class for the 4 child creates.
 *
 */
public class MagicalCreature {

    public String name; //name of creature
    public String type; // type of creature
    public String color; //color of creature
    public int age; //age of creature
    public boolean isAlive; // true or false if the creature is alive

    /**
     * The constructor for a basic creature with no type (Super Constructor)
     * @param name name of creature
     * @param type type of creature
     * @param color color of creature
     * @param age age of creature
     */
    public MagicalCreature (String name, String type, String color, int age) {
    this.name =name;
    this.type = type;
    this.color =color;
    this.age = age;
    this.isAlive =true;
    }

    /**
     * This is an empty constructor for a constructor with no type
     */
    public MagicalCreature() {
         String name ="";
         String type ="";
         String color="";
         int age = 0;
         boolean isAlive = true;
    }

    /**
     * Gets name of object
     * @return String of objects name
     */
    public String getName() {
        return this.name;
    }
    /**
     * Gets type of object
     * @return String of objects type
     */
    public String getType() {
        return this.type;
    }

    /**
     * Gets color of object
     * @return String of objects color
     */
    public String getColor() {
        return this.color;
    }
    /**
     * Gets age of object
     * @return Int of objects age
     */
    public int getAge() {
        return this.age;
    }
    /**
     * Gets boolean of object's alive status
     * @return Boolean of objects alive status
     */
    public boolean isAlive() {
        return isAlive;
    }

    /**
     * Sets name of object
     * @param name Takes new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets type of object
     * @param type Takes new type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Sets color of object
     * @param color Takes new color
     */
    public void setColor(String color) {
        this.color = color;
    }
    /**
     * Sets age of object
     * @param age Takes new age
     */
    public void setAge(int age) {
        this.age = age;
    }
    /**
     * Sets isAlive of object
     * @param alive Takes new alive status
     */
    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    /**
     * Super method of creature , default is no killing
     * @param b takes in creature, this was done to prevent an error
     */
    public void kill(MagicalCreature b) {
        System.out.println("I do not have the license to kill ");
    }

    /**
     * Default die method, kills object
     */
    public void die() {
        isAlive =false;
    }

    /**
     * To string method
     * @return A message describing the creature
     */
    public String toString () {
        return "My name is " + this.name +" I am a "+this.color+" " +
                this.type+" I am "+this.age+" years old ";
    }
}
