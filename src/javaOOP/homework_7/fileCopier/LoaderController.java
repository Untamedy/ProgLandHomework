package javaOOP.homework_7.fileCopier;

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
        isRead += copier.getSize();
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
        while (percentage < 100) {
            try {
                countLoadPercentage();
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(LoaderController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
