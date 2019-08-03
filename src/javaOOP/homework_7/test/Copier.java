package javaOOP.homework_7.test;

import javaOOP.homework_7.fileCopier.CopierWithLoaderController;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YBolshakova
 */
public class Copier {

    public static final Logger logger = Logger.getLogger(CopierWithLoaderController.class.getName());

    private volatile byte[] readBytes = null;
    private boolean change = false;
    private boolean stop = false;
    private volatile int loadsize = 0;
    private int fileSize = 0;

    public Copier() {
    }

    public boolean isChange() {
        return change;
    }

    public void setChange(boolean change) {
        this.change = change;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public synchronized byte[] getReadBytesForWrite() {
        logger.info("Writer assign value " + Thread.currentThread().getName());
        byte[] tmp = null;
        for (; !change;) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Copier.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        tmp = this.readBytes;
        this.readBytes = null;
        change = false;
        notifyAll();
        return tmp;
    }

    public synchronized void setReadBytes(byte[] readBytes) {
        for (; change;) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Copier.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.readBytes = readBytes;
        change = true;
        notifyAll();
    }

    public synchronized int getSize() {
        for (; loadsize == 0;) {
            if (!isStop()) {
                try {
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Copier.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                return loadsize;
            }
        }
        int newSize = loadsize;
        loadsize = 0;
        return newSize;
    }

    public void setLoadsize(int loadsize) {
        this.loadsize = loadsize;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

}
