package homework_6.observer;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 *
 * @author YBolshakova
 */
public class Observer {

    private int startFileCount;

    Logger logger = Logger.getLogger(Observer.class.getName());
    
    public void init(){
        
    }
    
    public void start(){
        
    }
    
    public void stop(){
        
    }

    public void checkDirect(String path) {
        Set<File> curentFilesSet = getFiles(path);

    }

    public Set<File> getFiles(String path) {
        File directory = new File(path);
        Set<File> setOfFiles = new HashSet<>();
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            setOfFiles.addAll(Arrays.asList(files));
        }
        return setOfFiles;
    }
    
}
