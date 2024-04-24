import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class MagicalCreaturesHelper {
public int  userMoves =0; //Keeps track of how many moves the user wants to run
public int creaturesAlive=0; //Keeps track of how many creatures are alive after certain situations (Are they alive or dead)
    public boolean stalemate =false;

    /**
     * fillData's purpose is to update the ArrayList we made in main with the creature.txt contents.
     * This happens by first making a scanner to read the file, scan line by line, use a line at a time to create
     * an array of the line we are on that has 4 strings, each one a characteristic we are looking to set for each creature.
     * It removes the ","s between the strings, sets an Integer to what is in array[3] which will be the age(We need an int value here,
     * that's why we cast from string to Integer). It then checks to see what type of creature is needed to be created in order to save it onto
     * the arrayList. Creatures alive is updated over and over to keep track of how many creatures were created.
     * @param creaturesArray Passes the arrayList from main that is used to keep track of the types of creatures in the game.
     * @throws FileNotFoundException If the file is not found in path, throw error.
     *
     */
    public void fillData(ArrayList<MagicalCreature> creaturesArray) throws FileNotFoundException {
        File creatureFile = new File ("C:\\Users\\nicol\\OneDrive\\Desktop\\creatures.txt");

        Scanner input = new Scanner(creatureFile); //new file scanner
        String[] arrayOfLine = new String[3]; //new array of type string which is made to save the lines contents to use to save onto arrayList
       try { //Checks if file is empty
           if (creatureFile.length() == 0) {
               System.out.println("File is empty ...");
               throw new FileNotFoundException();
           }
       } catch (FileNotFoundException e) {
           System.out.println("ERROR: EMPTY FILE");
           System.exit(0);
       }
        while (input.hasNextLine()) { //while file has lines

            String line = input.nextLine(); // single string used to save onto array
            arrayOfLine = line.split(","); //removes ","s
            Integer three = Integer.valueOf(arrayOfLine[3]); //changes the string to type Integer to save the age as Integer

            switch (arrayOfLine[1]) { //switch to check what type of object needs to be created and added to arrayList
                case "Dragon" -> creaturesArray.add(new Dragon(arrayOfLine[0], arrayOfLine[1], arrayOfLine[2], three));
                case "Elf" -> creaturesArray.add(new Elf(arrayOfLine[0], arrayOfLine[1], arrayOfLine[2], three));
                case "Goblin" -> creaturesArray.add(new Goblin(arrayOfLine[0], arrayOfLine[1], arrayOfLine[2], three));
                case "Genie" -> creaturesArray.add(new Genie(arrayOfLine[0], arrayOfLine[1], arrayOfLine[2], three));
                default -> {
                    System.out.println("ERROR POSSIBLE, A CREATURE HAS BEEN MADE NON FOUND IN DATA BASE OF TRAITS.... "); //Should only be creatures we want
                    creaturesArray.add(new MagicalCreature(arrayOfLine[0], arrayOfLine[1], arrayOfLine[2], three));
                }
            }
            creaturesAlive++;
        }
    }

    /**
     * Play game will ask the user how many moves they want the game to run for, check if the moves are greater than 1,
     * then call war method.
     * @param creaturesArray Passes the arrayList from main that is used to keep track of the types of creatures in the game.
     * Here it is used to pass to the war method
     */
    public void playGame (ArrayList<MagicalCreature> creaturesArray) {

        Scanner user = new Scanner(System.in); //Asks user how many moves

        do { //Makes sure user moves is more than 1
            System.out.print("How many moves ? ");
            userMoves = user.nextInt();

            if (userMoves < 1) {
            System.out.println("Please enter a number greater than 0 ");
            }
        } while (userMoves<1);

       war(creaturesArray,user); //Call war method and pass arrayList and the scanner
    }

    /**
     * This method plays the game by running 2 random creatures against each other, asking if the user
     * want to have wands and shields, and removes dead creatures.
     * @param creaturesArray Passes the arrayList from main that is used to keep track of the types of creatures in the game.
     * @param user Takes in the user scanner so a new one is not needed.
     */
    public void war (ArrayList<MagicalCreature> creaturesArray, Scanner user ) {

        while (userMoves!= 0) { // Keeps going till the moves from the user is 0

            Random r = new Random(); //Creates random object, rand ints, and ints to hold the user choice for wand and shield.
            int rand1 =0;
            int rand2 =0;
            int wand =0;
            int shield =0;

            rand1 =r.nextInt(creaturesArray.size()); //Makes 2 random numbers between 0-size of the creature arrayList
            rand2 =r.nextInt(creaturesArray.size());

            while (rand2 ==rand1) { //Makes sure the same creatures are not picked
                rand2 =r.nextInt(creaturesArray.size()-1);
            }
            MagicalCreature a = creaturesArray.get(rand1); //Makes 2 temp creature objects to use for this loop
            MagicalCreature b = creaturesArray.get(rand2);

            System.out.println("Killer = " + a.getType() + " " + a.getName()); // Shows user who got picked to be killer and victim
            System.out.println("Victim = " + b.getType() + " " + b.getName());

            if (a instanceof Genie) { //If the A object is a genie, ask user if he gets a wand

                System.out.print("Give your genie a wand? (1=Yes 2=No)");
                wand = user.nextInt();
                if (wand == 1) {
                    ((Genie) a).setWand(true);
                } else {
                    ((Genie) a).setWand(false);
                }

            }

            if (b instanceof Elf){ //If the B object is an Elf, ask user if he gets a shield

                System.out.print("Give your elf a shield? (1=Yes 2=No) ");
                shield = user.nextInt();
                if (shield == 1) {
                    ((Elf) b).setShield(true);
                } else {
                    ((Elf) b).setShield(false);
                }
            }

            a.kill(b); // A kills B if possible

            if (!b.isAlive){ //If B dies, it is removed from the list and lower the count of alive creatures
                System.out.println("Removing the Dead");
                creaturesArray.remove(rand2);
                creaturesAlive--;
            }
            userMoves--; //A move is done, so one is removed from the count
            displayCreatures(creaturesArray); //Display the creatures and who are alive, sending the list as a parm
            for (MagicalCreature e: creaturesArray) { //Checks if all creatures are dragons, if they are the game ends because dragons can't die.
                if (!e.type.equalsIgnoreCase("Dragon")) {
                    stalemate =false;
                    break;
                } else {
                    stalemate =true;
                }
            }
            if (stalemate) {
                System.out.println("All creatures are dragons, therefore the game must end ");
                userMoves =0;
            }
        }

    }
    /**
     * This method displays the array list and shows which creatures are alive. A simple for each loop is used.
     * @param creaturesArray Passes the arrayList from main that is used to keep track of the types of creatures in the game.
     *
     */
    public void displayCreatures (ArrayList<MagicalCreature> creaturesArray) {
        int count =0; //Count used for the for each loop to show where in the list the creature is
        System.out.println("----------------------------------------");
        System.out.println("Creatures still Alive after this round: " + creaturesAlive);
        System.out.println("----------------------------------------");
        for (MagicalCreature e: creaturesArray) {
            System.out.print(count + " : ");
            System.out.println(e.toString());
            count++;
        }
        System.out.println();

    }

}
