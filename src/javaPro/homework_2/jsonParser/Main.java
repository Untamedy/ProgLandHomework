package javaPro.homework_2.jsonParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YBolshakova
 */
public class Main {

    public static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    
    public static void main(String[] args) {
        
        String path= "C:\\Users\\YBolshakova\\Documents\\gs-maven\\Homework\\folderOne\\json.txt";
        
       Person p =  parsTo(path);
       
        System.out.println(p.toString());
        
        
    }
    
    public static Person parsTo(String path) {
        File file = new File(path);
       /* StringBuilder buffer = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {  
            String jsonString = "";
            while ((jsonString = reader.readLine()) != null) {
                buffer.append(jsonString);
            }            
        } catch (IOException ex) {
            LOGGER.warning(ex.getMessage());
        }*/
        
        Person somePerson = new Person();
        ObjectMapper mapper = new ObjectMapper();
        try {
            somePerson = mapper.readValue(file, Person.class);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return somePerson;
        
    }
    
}
