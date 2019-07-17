package homework_9.charCounter;

/**
 *
 * @author YBolshakova
 */
public class Main {
    
    public static void main(String[] args) {
        String path = "C:\\Users\\YBolshakova\\Documents\\gs-maven\\Homework\\folderOne_copy\\Document.txt";
        
        Counter counter = new Counter(path);
        System.out.println(counter.countCharacters());
    }

}
