package homework_10.translator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;



/**
 *
 * @author YBolshakova
 */
public class Translator {
    
    private HashMap<String,String> dictionary;
    private String pathFrom;
    private String pathTo;
    
    public Translator(){
        
    }
    
    public Translator(HashMap<String, String> dictionary, String pathFrom, String pathTo){
        this.dictionary=dictionary;
        this.pathFrom = pathFrom;
        this.pathTo = pathTo;
    }
    
    public void translate(){      
        
        try(BufferedReader reader = new BufferedReader(new FileReader(pathFrom));BufferedWriter writer = new BufferedWriter(new FileWriter(pathTo))){
          String line = "";
            while((line = reader.readLine())!=null){
                String [] words = line.split("\\s+|,\\s*|\\.\\s*|:\\s*");
                for(String s: words){
                    s = s.trim().toLowerCase();
                    writer.write(" " + translateWord(s)+ " ");                    
                }                
            }                       
        }catch(IOException ex){   
            System.out.println(ex.getMessage());
        }
    }
    
    public String translateWord(String word){               
            String translate = dictionary.get(word);
            return translate!=null? translate:word;        
       
    }
    
}
