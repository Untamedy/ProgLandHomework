package javaOOP.homework_7.test;



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
        Copier copier = new Copier();       
        
        Reader reader = new Reader(readFrom,copier);       
        Writer writer = new Writer(writeTo,copier);
        Loader loader = new Loader(copier);
         
         reader.start();        
         writer.start();   
         loader.start();

    }

}
