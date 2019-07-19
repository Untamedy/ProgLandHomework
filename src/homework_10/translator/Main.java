package homework_10.translator;

import java.util.HashMap;


/**
 *
 * @author YBolshakova
 */
public class Main {
    public static void main(String[] args) {
        String from = "folderOne\\English.in.txt";
        String to = "folderOne\\Ukranian.out.txt";
        
        DictionaryCreator creater = new DictionaryCreator("folderOne\\dictionary.txt");
        HashMap<String, String> map =  creater.reader();       
        
        creater.addNewWord("supper", "супер");
        
        Translator t = new Translator(map, from, to);
        t.translate();
        
    }
}
