package homework_9.charCounter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author YBolshakova
 */
public class Counter {
    
    private String path;
    private List<Character> character;
    
    public Counter(){
        
    }
            
    public Counter(String path){
        this.path = path;
    }
    
    public void read(){
        File file = new File(path);
        character = new ArrayList<>();
        if(!file.isDirectory()){
            try(BufferedReader reader = new BufferedReader(new FileReader(file))){
               int symbol =  reader.read();
               while(symbol!=-1){
                   symbol = reader.read();
                   character.add((char)symbol);
               }
            }catch(IOException exception){
                
            }
        }        
    }
    
    public void count(){
        
    }

}
