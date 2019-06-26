package homework_4;

import java.io.File;

/**
 *
 * @author YBolshakova
 */
public class Main {

    public static void main(String[] args) {
        FileHandler f = new FileHandler();
        
       String readFromDir = "C:\\Users\\YBolshakova\\Documents\\gs-maven\\Homework\\Other\\folderOne";
        String writeToDir = "C:\\Users\\YBolshakova\\Documents\\gs-maven\\Homework\\Other\\folderTwo";
        String fileType = ".txt";
        
        File one = new File("C:\\Users\\YBolshakova\\Documents\\gs-maven\\Homework\\Other\\folderTwo\\newFile_1.txt");
        File two = new File("C:\\Users\\YBolshakova\\Documents\\gs-maven\\Homework\\Other\\folderTwo\\newFile_2.txt");
        File appendFile = new File(readFromDir+"\\append.txt");
       f.copyFiles(readFromDir, writeToDir, fileType); 
       File [] files = f.getFiles(writeToDir, fileType);    
      
       
       f.appendFiles(one, two, appendFile);
        
       
        
        
    }

}
