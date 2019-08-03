package javaOOP.homework_7.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Logger;

/**
 *
 * @author YBolshakova
 */
public class Reader extends Thread {

    static final Logger logger = Logger.getLogger(Reader.class.getName());
    private String readFrom;
    private Copier copier;

    public Reader(String readFrom, Copier copier) {
        this.readFrom = readFrom;
        this.copier = copier;        
    }

    public void read() {
        try (FileInputStream reader = new FileInputStream(readFrom)) {
           int filesize  = reader.available();
           copier.setFileSize(filesize);
            byte[] bytes = new byte[100];
            while ((reader.read(bytes)) != -1) {
                logger.info("Reader read");
                copier.setReadBytes(bytes); 
                copier.setLoadsize(bytes.length);
                bytes = new byte[100];
            }
             copier.setReadBytes(bytes);   
             copier.setLoadsize(bytes.length);
            copier.setStop(true);
        } catch (IOException ex) {
            logger.warning(ex.getMessage());
        }
    }

    @Override
    public void run() {
        while (!copier.isStop()) {            
             read();             
        }
        logger.info("Reader is stoped");
       

    }

}
