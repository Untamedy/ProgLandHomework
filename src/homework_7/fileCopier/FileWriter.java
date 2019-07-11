package homework_7.fileCopier;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Logger;

/**
 *
 * @author YBolshakova
 */
public class FileWriter extends Thread{
     static final Logger logger = Logger.getLogger(FileWriter.class.getName());
    
    private CopierWithLoaderController copier;
    private File writeTo;
    
    public FileWriter(CopierWithLoaderController copier){
        this.copier = copier;
        init(); 
    }
    
    public void init(){        
       writeTo = new File(copier.getWriteTo(),"File_copy.txt"); 
    }
    
    public void writeToFile(){              
        try(FileOutputStream writer = new FileOutputStream(writeTo,false)) { 
           while(copier.isStop()){
               logger.info("Writer write to file");    
               synchronized(copier){
               writer.write(copier.getReadBytesForWrite());                
               copier.notify();
               }
        } 
            logger.info("Writer stop");
        } catch (IOException ex) {
            logger.severe(ex.getMessage());
        }
        
        
    }

    @Override
    public void run() {
        writeToFile();   
    }

}
