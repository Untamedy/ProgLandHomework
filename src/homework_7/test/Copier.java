package homework_7.test;

import homework_7.fileCopier.CopierWithLoaderController;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YBolshakova
 */
public class Copier {

    public static final Logger logger = Logger.getLogger(CopierWithLoaderController.class.getName());

    private String readFrom;
    private String writeTo;
    private byte[] readBytes = null;
    private Integer size = 0;
    private boolean stop = true;
    public Object readerLock;
    public Object writerLock;
    public Object loaderLock;
    int readSize = 0;

    public Copier() {

    }

    public Copier(String readFrom, String writeTo, Object readerLock, Object writerLock, Object loaderLock) {
        this.readerLock = readerLock;
        this.writerLock = writerLock;
        this.loaderLock = loaderLock;
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

    public int getReadSize() {
        return readSize;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public byte[] getReadBytes() {
        return readBytes;
    }

    /* public List<Thread> init() {
        List<Thread> list = new ArrayList<>();
        list.add(new Reader(this, readerLock, loaderLock));
        list.add(new Loader(this, loaderLock, writerLock));
        list.add(new Writer(this, writerLock, readerLock));
        return list;
    }*/

 /* public void copy() {
        List<Thread> list = init();
        list.forEach((t) -> {
            t.start();
        });

    }*/
    public byte[] getReadBytesForWrite() {
        byte[] tmp = null;
        for (; readBytes == null;) {
            synchronized (writerLock) {
                try {
                    logger.info("Writer wait " + Thread.currentThread().getName());

                    writerLock.wait();

                    logger.info("Writer wakeUp " + Thread.currentThread().getName());
                } catch (InterruptedException ex) {
                    logger.severe(ex.getMessage());
                }
            }
        }
        logger.info("Writer assign value " + Thread.currentThread().getName());
        tmp = this.readBytes;
        this.readBytes = null;
        return tmp;
    }

    public void setReadBytes(byte[] readBytes) {
        if (this.readBytes != null) {
            synchronized (readerLock) {
                try {
                    readerLock.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Copier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        this.readBytes = readBytes;
    }

    public int getReadSizeforLoad() {
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
        readSize = size;
        size = 0;
        return readSize;
    }
}
