package homework_7.fileCopier;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Logger;

/**
 *
 * @author YBolshakova
 */
public class FileReader extends Thread {

    static final Logger logger = Logger.getLogger(FileReader.class.getName());

    private CopierWithLoaderController copier;
    private File readFrom;

    public FileReader(CopierWithLoaderController copier) {
        this.copier = copier;
        init();
    }

    public void read() {
        try (FileInputStream reader = new FileInputStream(readFrom)) {           
            byte[] buffer = new byte[100];
            while ((reader.read(buffer)) != -1) {
                logger.info("Reader read from file");                
               //copier.setSize(buffer.length); 
                copier.setReadBytes(buffer);                               
                buffer = new byte[100];
            }
            copier.setStop(true);           
            logger.info("Reader is stoped");
        } catch (IOException e) {
            logger.warning(e.getMessage());
        }
    }

    public void init() {
        readFrom = new File(copier.getReadFrom());
    }

    @Override
    public void run() {
        read();

    }

}
