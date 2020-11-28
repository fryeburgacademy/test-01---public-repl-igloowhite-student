
/**
 * The logger class provides a quick way of toggling printed log messages on and off
 * by setting debugMode to true/false.
 *
 * @author Sartory
 * @version 11/25/2020
 */
public class Logger
{
    private static boolean debug;
    private static int counter = 1;
    
    // a private constructor prevents people from instantiating a Logger
    private Logger(){}
    
    public static void setMode(boolean mode){
        debug = mode;
    }
    
    public static boolean debugModeOn(){
        return debug;
    }

    public static void log(String s){
        if(debug){
            System.out.println("-- LOG" + counter + ": " + s);
        }
    }
}
