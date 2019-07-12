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
    private byte[] readBytes;
    private boolean stop = true;
    private boolean chenged = false;
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

    public boolean isChenged() {
        return chenged;
    }

    public void setChenged(boolean chenged) {
        this.chenged = chenged;
    }
    
    

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public List<Thread> init() {
        readBytes = new byte[0];
        List<Thread> list = new ArrayList<>();
        list.add(new FileReader(this));
        list.add(new LoaderController(this));
        list.add(new FileWriter(this));
        return list;
    }

    public void copy() {
        List<Thread> list = init();
        list.forEach((t) -> {
            t.start();
            logger.info(t.getName() + "is  started");
        });

    }

    public byte[] getReadBytesForWrite() {
        for (; this.readBytes.length == 0;) {
            try {
                logger.info("Writer wait " + Thread.currentThread().getName());
                synchronized (writerLock) {
                    writerLock.wait();
                }

            } catch (InterruptedException ex) {
                logger.severe(ex.getMessage());
            }
        }
        byte[] tmp = this.readBytes;
        readBytes = new byte[0];
        return tmp;
    }

    public void setReadBytes(byte[] readBytes) {
        for (; this.readBytes.length != 0;) {
            try {
                logger.info("Reader wait " + Thread.currentThread().getName());
                synchronized (readerLock) {
                    readerLock.wait();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(CopierWithLoaderController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.readBytes = readBytes;
        setChenged(true);

    }

    public byte[] getReadBytes() {
        for (;!isChenged();) {
            try {
                logger.info("Writer wait " + Thread.currentThread().getName());
                synchronized (loaderLock) {
                    loaderLock.wait();
                }
            } catch (InterruptedException ex) {
                logger.severe(ex.getMessage());
            }
        }
        byte[] tmp = this.readBytes;        
        return tmp;
    }

}
