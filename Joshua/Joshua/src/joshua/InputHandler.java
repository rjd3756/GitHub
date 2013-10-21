/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package joshua;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author rj
 */
public class InputHandler {
    
    public void handleInput(String input) throws FileNotFoundException, IOException{
        
        WordDatabaseReader wdr = new WordDatabaseReader();
        
        //Puts all of the sentences of the input in an array of sentences
        ArrayList<String> sentences = splitIntoSentences(input);  
        
        //Takes each sentence and splits it into an array of words
        for(String sentence : sentences){
            
            ArrayList<String> aSentence = splitIntoWords(sentence);
            Word[] wordsInSentence = new Word[aSentence.size()];
            int counter = 0;
            
            for(String aWord: aSentence){
               Word word = wdr.returnWord(aWord);
               wordsInSentence[counter] = word;
               counter ++;
            }
            
            POSDeterminationAlgorithm a = new POSDeterminationAlgorithm();
            wordsInSentence = a.determine(wordsInSentence);
         
        }
    }
    
    private ArrayList<String> splitIntoSentences(String text){
        ArrayList<String> splitText = new ArrayList<>();
        
        //deals with any sentence
        try{
            while(text.indexOf(".") > 0){
               //There is an issue with fixing abbreviations
               // text = fixAbbreviation(text);
                if(text.indexOf(".") == text.length() - 1){
                    text = text.substring(0, text.length() - 1);
                    splitText.add(text);
                    break;
                }else{
                     splitText.add(text.substring(0, text.indexOf(".")));
                     text = text.substring(text.indexOf(".") + 2, text.length());
                }
        }
    }catch(  NullPointerException | StringIndexOutOfBoundsException e){
        System.out.println("error");
    }
     return splitText;  
    }
    
    //Method takes a sentence as a string and returns it as an Array List of words
    private ArrayList<String> splitIntoWords(String sentence){
        
        ArrayList<String> words = new ArrayList<>();
        if (sentence.indexOf(" ") == -1){
            words.add(sentence);
        }else{
                while(sentence.indexOf(" ") != -1){
        
                int subStringEnd = sentence.indexOf(" ");
                words.add(sentence.substring(0, subStringEnd));
                sentence = sentence.substring(subStringEnd + 1);
            }
                words.add(sentence);
        }
         return words;
        
    }
    
    /*Recursive method that removes periods in abbreviations without removing 
     * periods that represent the end of a sentence 
     */
    private String fixAbbreviation(String text){
        
        int firstPeriod = text.indexOf(".");
        
        //Test to make sure there is a period in the sentence
        if(firstPeriod == -1){
           return text;
          }
        
        //Tests for another period from the index of the first to the end
        int secondPeriod = text.indexOf(".", firstPeriod + 1);
        
        //Looks for periods spaced around a character
        if(secondPeriod - 2 == firstPeriod){
            
           //Removes the first period from the String
           text = text.substring(0,firstPeriod) + text.substring(firstPeriod + 1, text.length());
           
           /*if the next character is a space and the character after that is
            *capitalized, then add a period because the abbreviation must have
            * come at the end of a sentence
            */
           if(text.substring(secondPeriod, secondPeriod + 1).equals(" ") && (text.substring(secondPeriod + 2, secondPeriod + 3).equals(text.substring(secondPeriod + 1, secondPeriod + 2).toUpperCase()))){
              text = text.substring(0,secondPeriod) + "." + text.substring(secondPeriod + 1, text.length());
             }
              //recursive return statement
              return fixAbbreviation(text);
          }
        /*if the next character is a space and the character after that is
         *capitalized, then remove that period because the abbreviation is 
         * within a sentence
         */
         if((text.substring(firstPeriod + 1, firstPeriod + 2).equals(" ")) &&(!(text.substring(firstPeriod + 2, firstPeriod + 3).equals(text.substring(firstPeriod + 2, firstPeriod + 3).toUpperCase())))){
             text = text.substring(0,firstPeriod) + text.substring(firstPeriod + 1, text.length());
           }
         
         return text;
    }
}
