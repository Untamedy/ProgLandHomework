package homework_7.test;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YBolshakova
 */
public class Main {
    private  Object readerLock = new Object();
    private  Object loadLock = new Object();
    private  Object writerLock = new Object();
 
        
    public static void main(String[] args) {

        String readFrom = "C:\\Users\\YBolshakova\\Documents\\gs-maven\\Homework\\folderOne_copy\\Document.txt";
        String writeTo = "folderOne\\";
        Main main = new Main();
                
        

        Copier copier = new Copier(readFrom, writeTo,main.readerLock,main.writerLock,main.loadLock);
       
        
        Reader reader = new Reader(copier, main.readerLock, main.loadLock);
         Thread loader = new Loader(copier,main.loadLock, main.writerLock);
         Thread writer = new Writer(copier, main.writerLock, main.readerLock);
         
         reader.start();
         loader.start();
         writer.start();
         
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        synchronized (main.readerLock) {
            main.readerLock.notifyAll();
        }


    }

}
