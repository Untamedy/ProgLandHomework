package homework_7.fileCopier;



/**
 *
 * @author YBolshakova
 */
public class Main {
    public static void main(String[] args) {
        
        String readFrom = "C:\\Users\\YBolshakova\\Documents\\gs-maven\\Homework\\folderOne_copy\\Document.txt";
        String writeTo = "folderOne\\";
        
        CopierWithLoaderController copier = new CopierWithLoaderController(readFrom, writeTo);
        copier.copy();       
    }

}
