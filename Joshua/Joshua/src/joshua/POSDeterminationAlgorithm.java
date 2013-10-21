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
        
        //Test Print statement
        System.out.println(POS.toString());
        
        
        //this is just so I can run the program to test
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
