package homework_7.fileCopier;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YBolshakova
 */
public class CopierWithLoaderController {

    public static final Logger logger = Logger.getLogger(CopierWithLoaderController.class.getName());

    private String readFrom;
    private String writeTo;
    private byte[] readBytes = null;
    private volatile Integer size = 0;
    private boolean stop = false;
    public Object readerLock = new Object();
    public Object writerLock = new Object();
    public Object loaderLock = new Object();

    public CopierWithLoaderController() {

    }

    public CopierWithLoaderController(String readFrom, String writeTo) {
        this.readFrom = readFrom;
        this.writeTo = writeTo;
    }

    public String getReadFrom() {
        return readFrom;
    }

    public String getWriteTo() {
        return writeTo;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Thread> init() {
        List<Thread> list = new ArrayList<>();
        list.add(new FileReader(this));
        //list.add(new LoaderController(this));
        list.add(new FileWriter(this));
        return list;
    }

    public void copy() {
        List<Thread> list = init();
        list.forEach((t) -> {
            t.start();
        });

    }

    public byte[] getReadBytesForWrite() {

        for (; readBytes == null;) {
            try {
                logger.info("Writer wait " + Thread.currentThread().getName());
                synchronized (writerLock) {
                    writerLock.wait();
                }

                logger.info("Writer wakeUp " + Thread.currentThread().getName());
            } catch (InterruptedException ex) {
                logger.severe(ex.getMessage());
            }
        }
        logger.info("Writer assign value " + Thread.currentThread().getName());
        byte[] tmp = this.readBytes;
        this.readBytes = null;
        synchronized (readerLock) {
            logger.info("Writer notify reader " + Thread.currentThread().getName());
            readerLock.notify();
        }

        return tmp;
    }

    public void setReadBytes(byte[] readBytes) {
        for (; this.readBytes != null;) {
            try {
                logger.info("Reader wait " + Thread.currentThread().getName());
                synchronized (readerLock) {
                    readerLock.wait();
                }
                logger.info("Reader wakeUp " + Thread.currentThread().getName());
            } catch (InterruptedException ex) {
                Logger.getLogger(CopierWithLoaderController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        logger.info("Reader assign value " + Thread.currentThread().getName());
        this.readBytes = readBytes;
        synchronized (writerLock) {
            logger.info("Loader notify writer " + Thread.currentThread().getName());
            writerLock.notify();
        }

    }

    public int getReadSize() {

        for (; size == 0;) {
            try {
                logger.info("Loader wait " + Thread.currentThread().getName());
                synchronized (loaderLock) {
                    loaderLock.wait();
                }

                logger.info("Loader wakeUp " + Thread.currentThread().getName());
            } catch (InterruptedException ex) {
                logger.severe(ex.getMessage());
            }
        }
        logger.info("Loader assign value " + Thread.currentThread().getName());
        int readSize = size;
        size = 0;
        return readSize;
    }
}
