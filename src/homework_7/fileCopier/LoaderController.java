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
    private long fileSize;
    private int isRead;

    public LoaderController(CopierWithLoaderController copier) {
        this.copier = copier;
        countSize(copier.getReadFrom());
    }

    public void countLoadPercentage() {
        isRead += copier.getReadBytes().length;
        synchronized (copier.writerLock) {
                copier.writerLock.notify();
            }
        if (fileSize > 0) {
            percentage = (int) ((isRead * 100) / fileSize);
            logger.info("Current percentage of loading is " + percentage);
            copier.setChenged(false);
            
        }

    }

    public void countSize(String path) {
        File file = new File(path);
        if (!file.isDirectory()) {
            fileSize = file.length();
        }

    }

    @Override
    public void run() {
        logger.info("Counter started");
        while (copier.isStop()) {            
                countLoadPercentage();               
        }

    }

}
