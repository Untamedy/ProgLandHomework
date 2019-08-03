package javaOOP.homework_6.copier;

/**
 *
 * @author YBolshakova
 */
public class Main {

    public static void main(String[] args) {
        String readFromDir = "folderOne\\";
        String writeToDir = "C:\\Users\\YBolshakova\\Documents\\gs-maven\\Homework\\";

        FileCopier.multithreadCopier(readFromDir, writeToDir, 2);
    }

}
