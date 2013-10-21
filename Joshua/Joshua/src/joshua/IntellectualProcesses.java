package joshua;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
/**
 *This class does all the work of calling the sentence interpreting methods and classes
 * 
 */
public class IntellectualProcesses {
    
    public IntellectualProcesses(String userInput) throws FileNotFoundException, IOException, NullPointerException{
        InputHandler InputHandler = new InputHandler();
        InputHandler.handleInput(userInput);
    }
}