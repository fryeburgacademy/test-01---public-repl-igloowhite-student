/**
 * The Guess-the-Word game is like hangman without the graphics.  The program should choose a
 * word from the Dictionary and begin a game.
 *
 * @author Dave Sartory
 * @version 11/25/2020
 */

import java.util.Scanner;
import java.util.ArrayList;

public class GuessTheWord{
    
    private boolean debugMode = false;  // true will show any messages logged and
                                        // disable the screen clear between guesses
    private Scanner input;              // our scanner for reading user input        
    private SecretWord secretWord;          // the chosen secret word
    
    /**
     * Constructor method that runs the program.
     */
    public GuessTheWord(){
        
        Logger.setMode(debugMode);
        input = new Scanner(System.in);
        
        
        System.out.print("How many letters (between " + Dictionary.shortest +
            " and " + Dictionary.longest + ") should the word have? ");
            
        int numLetters = input.nextInt();
        
        secretWord = new SecretWord(numLetters);
        
        while(!secretWord.isComplete()){
            displayScreen();
            String guess = input.next();
            secretWord.letterSearch(guess);
        }
        
        endScreen();
        
    }
    
    /**
     * Clears the screen if debug mode is currently off (false).
     */
    public void clearScreen(){
        if(!Logger.debugModeOn()){
            System.out.print("\u000C");
        }
    }
    
    /**
     * Displays the final game end screen.
     */
    public void endScreen(){
        displayScreen();
        System.out.println("You did it!");
    }
    
    
    
    /**
     * The main display method.  Essentially this is each "turn" displayed.
     */
    public void displayScreen(){
      
        clearScreen();
        printHud();
        secretWord.displayWord();
        System.out.print("\nGuess a letter: ");
        
    }
    
    /**
     * Prints the top of screen "heads up display" with current game stats.
     */
    public void printHud(){
            
        String gc = String.format("%2d",secretWord.getNumberOfGuesses());
        String missed = String.format("%2d", secretWord.getIncorrectCount());
        
        String hud =    "********************************************\n" + " Guesses: " + gc + 
                        "                   Mistakes: " + missed + 
                        "\n Guessed Letters: ";
        
        hud += secretWord.getAllGuesses();  // list guesses
        hud += "\n********************************************\n";
        
        System.out.println(hud);
    
    }
    

    
    
    
    /**
     * This is a way to make the main method create one of THIS object, in this case
     * a GuessTheWord game, which starts the program.  By instantiating a "new GuessTheWord()"
     * object, the constructor is called, which in turn runs the program.
     */
    public static void main(String[] args){
        new GuessTheWord();
    }
}
