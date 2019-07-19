package homework_10.translator;

import static homework_8.base.Faculty.LOGGER;
import homework_8.base.GroupOfStudent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YBolshakova
 */
public class DictionaryCreator {

    public static final Logger LOGGER = Logger.getLogger(DictionaryCreator.class.getName());

    private TreeMap<String, String> dictionary;
    private String pathFrom;

    public DictionaryCreator() {

    }

    public DictionaryCreator(String pathFrom) {
        this.pathFrom = pathFrom;
    }
    
    public TreeMap<String,String> readDictionary(){           
         dictionary = new TreeMap<>();                 
        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(pathFrom))) {
            dictionary = (TreeMap<String, String>) reader.readObject();  
        } catch (IOException | ClassNotFoundException ex) {
           LOGGER.severe(ex.getMessage());
        }
        return dictionary;
    } 
        
    
    public void addNewWord(String word, String translate) {
        word = word.trim().toLowerCase();
        translate = translate.trim().toLowerCase();
        if(dictionary.putIfAbsent(word, translate)!=null){
           writeToFile(word, translate); 
        }
        
    }

    public void writeToFile(String word, String translate) {
        Map<String, String> newDictionary = new TreeMap<>(dictionary);
        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(pathFrom))) {
            writer.writeObject(newDictionary);
        } catch (IOException ex) {
        }
    }

}
