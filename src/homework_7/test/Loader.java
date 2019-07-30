package homework_7.test;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YBolshakova
 */
public class Loader extends Thread {

    static final Logger logger = Logger.getLogger(Loader.class.getName());

    private int percentage;
    private Copier copier;
    private long fileSize;
    private int isRead;

    public Loader(Copier copier) {
        this.copier = copier;
    }

    public int countLoadPercentage() {
        fileSize = copier.getFileSize();
        if (fileSize > 0) {
            isRead = copier.getSize();
            return percentage += (int) ((isRead * 100) / fileSize);
        }
        return percentage;
    }

    @Override
    public void run() {
        while (!copier.isStop()) {
            if (!(countLoadPercentage() > 100)) {
                logger.info("Current percentage of loading is " + countLoadPercentage());
            }
        }
        logger.info("Current percentage of loading is " + 100);
        logger.info("Load is finished");
    }

}
