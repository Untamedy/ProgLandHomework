package homework_7.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YBolshakova
 */
public class Writer extends Thread {

    static final Logger logger = Logger.getLogger(Writer.class.getName());

    private Copier copier;
    private File writeTo;
    String path;

    public Writer(String path, Copier copier) {
        this.copier = copier;
        this.path = path;
        init();
    }

    public void init() {
        writeTo = new File(path, "File_copy.txt");
    }

    public void writeToFile() {
        try (FileOutputStream writer = new FileOutputStream(writeTo, true)) {
            byte[] toWrite = copier.getReadBytesForWrite();
            if (toWrite != null) {
                writer.write(toWrite);
                writer.flush();
            }

        } catch (IOException ex) {
            logger.severe(ex.getMessage());
        }

    }

    @Override
    public void run() {
        while (!copier.isStop()) {            
            writeToFile();        
        }
        logger.info("Writer is stoped");

    }

}
