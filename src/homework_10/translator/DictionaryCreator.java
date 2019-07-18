package homework_10.translator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author YBolshakova
 */
public class DictionaryCreator {
    public static final Logger LOGGER = Logger.getLogger(DictionaryCreator.class.getName());

    private HashMap<String, String> dictionary;
    private String pathFrom;
    
    public DictionaryCreator(){
        
    }  
    
    public DictionaryCreator(String pathFrom){
        this.pathFrom = pathFrom;
    }
    
   public HashMap<String, String> reader() {
       dictionary = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(pathFrom))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("-");
                words[0] = words[0].trim();
                words[1] = words[1].trim();
                dictionary.put(words[0].toLowerCase(), words[1].toLowerCase());               
            }

        } catch (Exception ex) {
            LOGGER.info(ex.getMessage());
        }
        return dictionary;
    }   
   
   public void addNewWord(String word, String translate){
       word = word.trim().toLowerCase();
       translate = translate.trim().toLowerCase();       
       dictionary.putIfAbsent(word, translate); 
       writeToFile(word, translate);
   }

public void writeToFile(String word, String translate){
    try(BufferedWriter writer = new BufferedWriter(new FileWriter(pathFrom,true))){
    writer.write("\n"+word + "-" + translate);        
    }   catch (IOException ex) {
            Logger.getLogger(DictionaryCreator.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
   
}
