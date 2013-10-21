package joshua;

/**
 *This class contains the object word
 * Word is all of the information that is stored in a word in a sentence
 * All the methods to edit and access a word object are in this class
 */
public class Word {
    private boolean pastParticiple;
    private String POS;
    private boolean negative;
    private boolean toBe;
    private boolean verbIng;
    private boolean aux;

    //Assigns all of the variables and creates a word object
    public Word(String wordString, String POS, boolean pastParticiple, boolean negative,  boolean toBe,  boolean verbIng,  boolean aux){
        
            string = wordString;
            this.POS = POS;
            this.pastParticiple = pastParticiple;
            this.negative = negative;
            this.toBe = toBe;
            this.verbIng = verbIng;
            this.aux = aux;  
    }
    
    //creates and then returns a word
    public Word returnWord(String wordString, String POS, boolean pastParticiple, boolean negative, boolean toBe, boolean verbIng, boolean aux){
        
        Word word = new Word(wordString, POS, pastParticiple, negative, toBe, verbIng,
                    aux);
        return word;
    }
    
    //returns the human spelling of the word as a string
    public String getName(){
        return string;
    }
    
    //returns the part of speech as a string
    public String getPOS(){
        return POS;
    }
   
    //returns if the word is a past participle
    public boolean getPastParticiple(){
        return pastParticiple;
    }
    
    //sets if the word is a past participle or not
    public void setPastParticiple(int num){
        if(num == 1)
            pastParticiple = true;
        else{
            if(num == 0)
               pastParticiple = false;
            else{
                System.out.print("ERROR: SETPASTPARTICIPLE");
            }
        }
    

    }
    
    //sets if the word is negative or not
    public void setNegative(int num){
        if(num == 1)
            negative = true;
        else{
            if(num == 0)
               negative = false;
            else{
                System.out.print("ERROR: SETNEGATIVE");
            }
        }
    }
   
    //sets the word's part of speech
    public void setPOS(String pos){
      this.POS = pos;
    }
    
    //returns if the word is a negative or not
    public boolean getNegative(){
        return negative;
    } 
    
    //returns if the word is a to be verb or not
    public boolean getToBe(){
        return toBe;
    }
    
    //sets if the word is a to be verb or not
    public void setToBe(int num){
        if(num == 1)
            toBe = true;
        else{
            if(num == 0)
               toBe = false;
            else{
                System.out.print("ERROR: SETTOBE");
            }
        }
    }
   
    //returns if the verb ends with ing or not
    public boolean getVerbIng(){
        return verbIng;
    }
    
    //sets if the verb ends with ing or not
    public void setVerbIng(int num){
        if(num == 1)
            verbIng = true;
        else{
            if(num == 0)
               verbIng = false;
            else{
                System.out.print("ERROR: SETVERBING");
            }
        }
    }
   
    //returns if the part of speech is auxillary
    public boolean aux(){
        return aux;
    }
   
    //sets if the part of speech is auxillary
    public void setAux(int num){
        if(num == 1)
            aux = true;
        else{
            if(num == 0)
               aux = false;
            else{
                System.out.print("ERROR: SETAUX");
            }
        }
    }
   
    //converts the part of speech into a readable and understandable string
    public String stringPOS(String character){
        switch(character){
            case "J": POS = "adjective";
                break;
            case "a": POS = "adverb/verb";
                break;
            case "I": POS = "interjection";
                break;
            case "n": POS = "noun/verb";
                break;
            case "V": POS = "verb";
                break;
            case "o": POS = "adjective/pronoun";
                break;
            case "Q": POS = "possessive pronoun";
                break;
            case "X": POS = "not";
                break;
            case "p": POS = "preposition/adverb";
                break;
            case "j": POS = "adjective/verb";
                break;
            case "B": POS = "article";
                break;
            case "N": POS = "noun";
                break;
            case "P": POS = "prepostion";
                break;
            case "q": POS = "possessive pronoun/pronoun";
                break;
            case "A": POS = "adverb";
                break;
            case "C": POS = "conjunction";
                break;
            case "d": POS = "noun/adjective";
                break;
            case "O": POS = "pronoun";
                break;
            case "u": POS = "unknown";
                break;
        }
        return POS;
    }
    
    public String string;
}

    
    

