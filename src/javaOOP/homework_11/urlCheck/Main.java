package javaOOP.homework_11.urlCheck;



/**
 *
 * @author YBolshakova
 */
public class Main {
    public static void main(String[] args) {
       URLChecker urlchecker = new URLChecker("folderOne\\url_list.txt");
        urlchecker.check();
    }

}
