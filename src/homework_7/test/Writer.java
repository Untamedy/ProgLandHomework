package homework_7.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Logger;

/**
 *
 * @author YBolshakova
 */
public class Writer extends Thread {

    static final Logger logger = Logger.getLogger(Writer.class.getName());

    private Object writerLock;
    private Object readerNotify;

    private Copier copier;
    private File writeTo;

    public Writer(Copier copier, Object writerLock, Object readerNotify) {
        this.copier = copier;
        this.readerNotify = readerNotify;
        this.writerLock = writerLock;
        init();
    }

    public void init() {
        writeTo = new File(copier.getWriteTo(), "File_copy.txt");
    }

    public void writeToFile() {
        try (FileOutputStream writer = new FileOutputStream(writeTo, false)) { 
                byte[] toWrite = copier.getReadBytesForWrite();
                writer.write(toWrite);                
                logger.info("Writer write to file");            
            
        } catch (IOException ex) {
            logger.severe(ex.getMessage());
        }

    }

    @Override
    public void run() {
        while(copier.isStop()){        
            writeToFile();
            synchronized (readerNotify) {
                logger.info("Writer notify reader " + Thread.currentThread().getName());
                readerNotify.notifyAll();
            }

        }

    }

}
