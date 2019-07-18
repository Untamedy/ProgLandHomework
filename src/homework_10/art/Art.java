package homework_10.art;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author YBolshakova
 */
public class Art {
    
    private HashMap<Character, String []> alphabet;  
    
    public Art(){
        
    }
    public Art(HashMap<Character, String []> alphabet){
        this.alphabet=alphabet;
    
    }
    
    public void draw(){
        
    }
    
        
    public List<String []> convert(String word){
        List<String []> artWord = new LinkedList<>();
        char [] character = word.toCharArray();
        for (char c : character) {
            if(alphabet.containsKey(c)){
                String [] artChar = alphabet.get(c);
                artWord.add(artChar);              
            }
            
        }
        return artWord;
        
    }   
  
    

}
