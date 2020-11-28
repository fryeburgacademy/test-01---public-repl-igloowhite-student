
/**
 * The SecretWord class handles all of the functionality behind the secret word
 * and management of searching, replacing, and displaying details about it.
 *
 * @author Dave Sartory
 * @version 11/25/2020
 */
import java.util.ArrayList;

public class SecretWord
{
    private String secretWord;          // the chosen secret word
    private String[] correctLetters;    // the secret word in an array by letter
    private String[] completedWord;     // the word in progress
    private ArrayList<String> guesses;  // all letters guessed so far by user
    private int incorrectCount = 0;     // counter of incorrect guesses
    
    
    /**
     * Retrieves a secret word of the requested length from the dictionary
     * and loads it into a variable and an array with one letter per index.
     * 
     * @param int The requested number of letters for the secret word.
     */
    public SecretWord(int numberOfLetters){
        
        guesses = new ArrayList<String>();
        secretWord = Dictionary.getWord(numberOfLetters);
        Logger.log("Secret word is \"" + secretWord + "\"");
        correctLetters = new String[secretWord.length()];
        completedWord = new String[secretWord.length()];
        
        // break the word into letter array for managing guesses
        for(int i = 0; i < secretWord.length(); i++){
            correctLetters[i] = secretWord.substring(i,i+1);
        }
    }
    
    /**
     * Checks if the word has been completely solved.
     * 
     * @return true if word is solved, false otherwise
     */
    public boolean isComplete(){
        for(String letter : completedWord){
            if(letter == null){
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Displays the word in its current partially guessed state, with "_" where unguessed
     * letters are located.
     */
    public void displayWord(){
        String out = new String("  ");
        for(String s : completedWord){
            
            if(s == null){
                out += "_ ";
            } else {
                out += s + " ";
            }
        }
        System.out.println(out);
    }
    
    /**
     * Scans the secret word array, adds letters appropriately into it if the guess is correct,
     * adds the guessed letter to list, increments incorrectCount if no letters are found, and
     * ignores repeated letter guesses.
     * 
     * @param String the guessed letter
     */
    public void letterSearch(String guess){
        
        if(!guesses.contains(guess)){
            int correctCount = 0;
            for(int i = 0; i < correctLetters.length; i++){
                if(guess.equals(correctLetters[i])){
                    completedWord[i] = guess;
                    correctCount++;
                }
            }
            guesses.add(guess);
            
            // mark incorrect letters
            if(correctCount == 0){
                incorrectCount++;
            }
        }
    }
    
    public int getIncorrectCount(){
        return incorrectCount;
    }
    
    public int getNumberOfGuesses(){
        return guesses.size();
    }
    
    public String getAllGuesses(){
        String out = "";
        for(String g : guesses){
            out += g;
        }
        return out;
    }
    
}
