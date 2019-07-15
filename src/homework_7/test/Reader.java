package homework_7.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Logger;

/**
 *
 * @author YBolshakova
 */
public class Reader extends Thread {

    static final Logger logger = Logger.getLogger(Reader.class.getName());

    private Object readerLock;
    private Object loaderNotify;

    private Copier copier;
    private File readFrom;

    public Reader(Copier copier, Object readerLock, Object loaderNotify) {
        this.copier = copier;
        this.loaderNotify = loaderNotify;
        this.readerLock = readerLock;
        init();
    }

    public void read() {
        try (FileInputStream reader = new FileInputStream(readFrom)) {

            byte[] buffer = new byte[100];
            while (reader.read(buffer) != -1) {
                logger.info("Reader read from file");
                copier.setSize(buffer.length);
                copier.setReadBytes(buffer);
                synchronized (loaderNotify) {
                logger.info("Reader notify loader " + Thread.currentThread().getName());
                loaderNotify.notifyAll();
            }
            }
            copier.setStop(false);
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
        while (copier.isStop()) {
            read();
            synchronized (loaderNotify) {
                logger.info("Reader notify loader " + Thread.currentThread().getName());
                loaderNotify.notifyAll();
            }

        }

    }

}
