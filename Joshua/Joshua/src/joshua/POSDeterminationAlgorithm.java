/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package joshua;

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
    
    public Word[] determine(Word[] words){
        ArrayList<String> POS = new ArrayList<>();
        for(Word word : words){
            POS.add(word.stringPOS(word.getPOS()));
        }
        countPOSIssues(POS);
        
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
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //Test Print statement
        System.out.println(POS.toString());
        
        
        //this is just so I can run the program to test
        //in the future this will hopefully return the sentence structure that
        //lacks undetermined parts of speech
        return words;
    }
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

}
