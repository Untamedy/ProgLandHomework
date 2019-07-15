package homework_7.test;

import java.io.File;
import java.util.logging.Logger;

/**
 *
 * @author YBolshakova
 */
public class Loader extends Thread {

    static final Logger logger = Logger.getLogger(Loader.class.getName());

    private Object loaderLock;
    private Object writerNotify;

    private int percentage;
    private Copier copier;
    private long fileSize;
    private int isRead;

    public Loader(Copier copier, Object loaderLock, Object writerNotify) {
        this.copier = copier;
        this.writerNotify = writerNotify;
        this.loaderLock = loaderLock;
    }

    public void countLoadPercentage() {       
            isRead += copier.getReadSizeforLoad();
            if (fileSize > 0) {
                percentage = (int) ((isRead * 100) / fileSize);
                logger.info("Current percentage of loading is " + percentage);
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
        while (copier.isStop()){ 
            countLoadPercentage();
            synchronized (writerNotify) {
                logger.info("Loader notify writer " + Thread.currentThread().getName());
                writerNotify.notifyAll();
            }
        
        }
    }

}
