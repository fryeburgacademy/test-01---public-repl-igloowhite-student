
/**
 * The dictionary class is a helper class that can provide a random word
 *
 * @author Sartory
 * @version 11/25/2020
 */
import java.util.ArrayList;

public class Dictionary{
    
    private static String[] words = {"abstract","primitive","object",
            "array","annoy","ignore","prefer","attention","instead","problem",
            "calm","investigate","protect","comfortable","invite","proud",
            "consequences","important","question","curious","jealous",
            "reminds","curve","leader","repeat","decide","list","report",
            "directions","listen","rhyme","discover","lovely","respect",
            "disappointed","measuring","searching","embarrassed","miserable",
            "special","enormous","mumble","spotless","exhausted","negative",
            "squirm","explore","nervous","stomped","fair","nibbled","suddenly",
            "fascinating","note","suggestion","feast","notice","surprise",
            "focus","observing","uncomfortable","frustrated","opposite",
            "warning","gigantic","ordinary","wonder","grumpy","positive",
            "worried","huge","precious"};
            
    public static int shortest = 255;
    public static int longest = 0;
    
    static{
        for(String w : words){
            shortest = Math.min(w.length(),shortest);
            longest = Math.max(w.length(),longest);
        }
    }

    private Dictionary()
    {
        // creating a private constructor prevents people trying
        // to instantiate your static class
    }

    /**
     * Get a random word from the dictionary.
     * 
     * @param int number of letters requested.
     * @return word from dictionary
     */
    public static String getWord(int numLetters){
        
        ArrayList<String> matchWords = new ArrayList<String>();

        // get all words of numLetters length
        for(String word : words){
            if(word.length() == numLetters){
                matchWords.add(word);
            }
        }

        int rand = (int)(Math.random() * matchWords.size());
        return matchWords.get(rand);
       
    }

}
