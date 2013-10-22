/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package joshua;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author rj
 */
public class POSDeterminationAlgorithm {
    private int possibleNouns;
    private int possibleVerbs;
    private int possibleAdverbs;
    private int possibleAdjectives;
    private int possiblePrepositions;
    private int possiblePronouns;
    private int unknownWords;
    
    public POSDeterminationAlgorithm(){
    }
    
    public boolean isDeterminate(Word[] words){
        ArrayList<String> POS = createPOS(words);       
        //Test Print statement
        System.out.println(POS.toString());
        if(POS.toString().contains("/")){
             try{
                  String filename= "UnknownSentences.txt";
                  BufferedWriter fw = new BufferedWriter(new FileWriter(filename,true)); //the true will append the new data
                  fw.newLine();
                  for(Word word : words){
                      fw.write(word.getName() + " ");
                  }
                  fw.newLine();
                  fw.write(POS.toString());//appends the string to the file
                  fw.newLine();
                  fw.close();
                   }
                   catch(IOException ioe)
                    {
                      System.err.println("IOException: " + ioe.getMessage());
                     }
            return false;
        }else{
            return true;
        }
    }
        
    public Word[] resolvePOS(Word[] words){
        ArrayList<String> POS = createPOS(words);
        //the algorithm will run entirely through all statements until a 
        //determinate form is reached
        while(!(isDeterminate(words))){
            //The entire algorithm shall be written within this loop
        }
        
        //finalizes changes by attatching the correct Parts of Speech to the words
        int counter = 0;
        for(Word word : words){
            word.setPOS(POS.get(counter));
            counter ++;
        }
        return words;
    }
        
        /*i am going to outline the algorithm in comments here
         * 
         * unknown words could be handled in multiple ways
         * the best would be to try to determine them after the bulk
         * of this algorithm has run
         * the other would be to immediately stop the algorithm and have the
         * user provide the basic grammatical information about the word.
         * The second approach may be what to start with, but in the long run
         * it seems better to have the program attempt to figure out what words
         * it does not recognize are.
         * 
         * THIS PART CAN BE EXCLUDED FOR NOW SINCE ITS IMPLEMENTATION WOULD
         * RUN THE POS ALGORITHM MULTIPLE TIMES AND REALLY ISNT THE MAIN PART
         * OF THE ALGORITHM
         * first, compound sentences and clauses must be addressed
         * split compound sentences into two
         * remove clauses and evaluate with a different algorithm
         * 
         * 
         * THIS IS NECESSARY
         * adjectives should be assigned to the word in which they are attached
         * remember that multiple adjectives and even adverbs could be attached
         * to a single word. so loop through until all of these can be placed in
         * other words.
         * also, prepositions should work like this as well
         * 
         * next, if the sentence has no verb and only one possible verb
         * change that one to a verb
         * 
         * if the sentence has no noun and one possible noun, change that
         * to a noun, but be aware that pronouns could screw with this approach,
         * it may become even more complicated than this.
         * 
         * 
         */
    //counts all the current issues with the parts of speech in the current sentence
        private void countPOSIssues(ArrayList<String> sentenceStructure){
        
        for(String a : sentenceStructure){
            switch(a){
                case "noun/verb": 
                    possibleNouns++;
                    possibleVerbs++;
                    break;
                case "adverb/verb":
                    possibleVerbs++;
                    possibleAdverbs++;
                    break;
                case "adjective/pronoun":
                    possibleAdjectives++;
                    possiblePronouns++;
                    break;
                case "preposition/adverb":
                    possibleAdverbs++;
                    possiblePrepositions++;
                    break;
                case"adjective/verb":
                    possibleVerbs++;
                    possibleAdjectives++;
                    break;
                case "unknown":
                    unknownWords++;
            }
           
                      
                            
        }
        
    }
        //creates a list of parts of speech from the given list of words
        public ArrayList<String> createPOS(Word[] words){
            ArrayList<String> POS = new ArrayList<>();
            for(Word word : words){
                POS.add(word.stringPOS(word.getPOS()));
            }
            return POS;
        }

}
