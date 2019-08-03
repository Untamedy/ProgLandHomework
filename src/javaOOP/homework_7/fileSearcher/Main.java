package javaOOP.homework_7.fileSearcher;



/**
 *
 * @author YBolshakova
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
       FileSearcher fileSearcher = new FileSearcher(4);
       fileSearcher.serchFileByName("C:\\Users\\YBolshakova\\Documents\\gs-maven\\Homework\\", "image.webp"); 
       Thread.sleep(10000);
       fileSearcher.stop();
    }

}
