package joshua;

import java.io.*;

/**
 *This class reads and compares words from the database
 */
public class WordDatabaseReader {
    
    private String POS;
    private int pastParticiple;
    private int negative;
    private int toBe;
    private int verbIng;
    private int aux;
    private Word w;
    
    //looks for a word in the database and returns it if it exsists
    //if the word is not in the database it writes it in the text file Unknown words
    public Word returnWord(String word)throws FileNotFoundException, IOException{
    
        BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\rj\\Desktop\\Joshua\\Joshua\\src\\joshua\\WordDatabase.csv"));

        String currentLine = "";
        boolean match = false;
        try{
         while(!match){
                currentLine = in.readLine();
                int subStringEnd = currentLine.indexOf(',');
                String wordInData = currentLine.substring(0, subStringEnd);
                if (wordInData.equals(word)){
                    match = true;
                    currentLine = currentLine.substring(subStringEnd + 1);
                }else{
                    if (wordInData.equalsIgnoreCase(word)){
                        match = true;
                        currentLine = currentLine.substring(subStringEnd + 1);
                }
            }
         }
        
             this.POS = (currentLine.substring(0,1));
             this.pastParticiple = Integer.parseInt(currentLine.substring(2,3));
             this.negative = Integer.parseInt(currentLine.substring(4,5));
             this.toBe = Integer.parseInt(currentLine.substring(6,7));
             this.verbIng = Integer.parseInt(currentLine.substring(8,9));
             this.aux = Integer.parseInt(currentLine.substring(10,11));
            
             //creates a new word object from the data in the database
             this.w = new Word(word, POS, convertToBoolean(pastParticiple), convertToBoolean(negative), convertToBoolean(toBe),convertToBoolean(verbIng),
                     convertToBoolean(aux));
             
             //catches if the word is not found in the database
            }catch(NullPointerException e){
                    System.out.println("The word " + word + " is unknown to me!!!!");
                    //creates a new word with type unknown and all data false
                    this.w = new Word(word, "u", false, false, false, false, false);
                    try{
                        String filename= "UnknownWords.txt";
                        BufferedWriter fw = new BufferedWriter(new FileWriter(filename,true)); //the true will append the new data
                        fw.newLine();
                        fw.write(word);//appends the string to the file
                        fw.close();
                        }
                        catch(IOException ioe)
                        {
                            System.err.println("IOException: " + ioe.getMessage());
                        }

             }
        return w;
            
    }
   
    //converts a zero or one as an integer into false or true as a boolean value
    //this is used for the many booleans in the database that are entered as integers
    private boolean convertToBoolean(int num){    
        if(num == 1)
            return true;
        else{
            if(num == 0)
               return false;
            else{
                System.out.print("ERROR: convertToBoolean");
                return false;
            }
        }
    }   
}
