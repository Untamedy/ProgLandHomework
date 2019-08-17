package javaPro.homework_2.jsonParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
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
        
       String path= "folderOne\\json.txt";
       String newpath= "folderOne\\newJson.json";
       
       ObjectMapper mapper = new ObjectMapper();
       Person p =  parsFromJson(mapper, path);       
       System.out.println(p.toString());
       parsToJson(mapper, p, newpath);
        
        
    }
    
    public static Person parsFromJson(ObjectMapper mapper, String path) {
        File file = new File(path);  
        Person somePerson = new Person();       
        try {
            somePerson = mapper.readValue(file, Person.class);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }      
        return somePerson;        
    }  
    
    public static void parsToJson(ObjectMapper mapper, Person person, String path){
        File file = new File(path);        
        try {
            mapper.writeValue(file, person);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
