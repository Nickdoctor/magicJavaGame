/**
 * @author Nicolas Gugliemo
 * @vertion 1.0
 * @date 10/5/2022
 * This program is a simulation of a fighting game where 4 different types of creatures attack one another
 * and either die or live depending on the situation. The program starts with reading from a creature.txt
 * file and using each line on the txt file as a new creature object. Each creature has 4 characteristics,
 * a name, a type, a color, and an age. Each one of these traits are saved into their own creature object,
 * and saved onto a arraylist of type creature objects.
 *
 */

import java.io.FileNotFoundException; //Used for file errors
import java.util.*; //Used for general purpose

public class MagicalCreaturesGame { //This class will run the main method and user the helper file to play the game
    public static ArrayList<MagicalCreature> creaturesArray  = new ArrayList<>(); //Create new arrayList for program to use

    public static void main(String[] args) throws FileNotFoundException { //Main function that throws File not found

        MagicalCreaturesHelper MagicalCreaturesHelper = new MagicalCreaturesHelper(); //Create new helper object
        MagicalCreaturesHelper.fillData(creaturesArray); // Call the fill data method to fill up the creatures ArrayList
        MagicalCreaturesHelper.playGame(creaturesArray); // Call the play game method to use the ArrayList and run the game

    }

}