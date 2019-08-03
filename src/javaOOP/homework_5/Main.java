package javaOOP.homework_5;

import java.io.File;

/**
 *
 * @author YBolshakova
 */
public class Main {

    public static void main(String[] args) {
        FileHandler f = new FileHandler();

        String readFromDir = "folderOne\\";
        String writeToDir = "folderTwo\\";
        String fileType = ".txt";

        File one = new File(writeToDir,"newFile_1.txt");
        File two = new File(writeToDir,"newFile_2.txt");        
        File appendFile = new File(writeToDir, "append.txt");
        
        f.copyFiles(readFromDir, writeToDir, fileType);
        
        f.joinFiles(one, two, appendFile);   
    }

}
