package homework_7.fileCopier;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YBolshakova
 */
public class LoaderController extends Thread {

    static final Logger logger = Logger.getLogger(LoaderController.class.getName());

    private int percentage;
    private CopierWithLoaderController copier;
    private long fileSize= 250;

    public LoaderController(CopierWithLoaderController copier) {
        this.copier = copier;
        countSize(copier.getReadFrom());
    }

    public void countLoadPercentage() {        
        int isRead = copier.getReadBytes().length;        
        if(fileSize>0){
            synchronized(copier){
                percentage = (int) ((isRead * 100) / fileSize);
                System.out.println("Current percentage of loading is " + percentage);
                copier.notify();   
            }
                   
        }
    }

    public void countSize(String path) {
        File file = new File(path);
        if(!file.isDirectory()){
           fileSize = file.length();  
        }
       
    }

    @Override
    public void run() {
        while(!copier.isStop()){          
                countLoadPercentage();              
                logger.info("Counter started");
            
        }
        

    }

}
