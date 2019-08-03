package javaPro.homework_1.task2;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

/**
 *
 * @author YBolshakova
 */
@FilePath(path = "folderOne\\Result.txt")
public class Saver {
    public static final Logger logger = Logger.getLogger(Saver.class.getName());
    
    private TextContainer textContainer;
    
    public Saver(){
        
    }
    
    public Saver(TextContainer textContainer){
       this.textContainer = textContainer;
    }
    
    
    
    @Writer
    
    public void saveToFile(String path) {
        File file = new File(path);
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            writer.write(textContainer.getText());            
        }catch(IOException ex){
          logger.warning(ex.getMessage());
        }
    }

}
