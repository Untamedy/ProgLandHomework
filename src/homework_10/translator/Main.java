package homework_10.translator;

import java.util.HashMap;
import java.util.TreeMap;


/**
 *
 * @author YBolshakova
 */
public class Main {
    public static void main(String[] args) {
        String from = "folderOne\\English.in.txt";
        String to = "folderOne\\Ukranian.out.txt";
        
        DictionaryCreator creater = new DictionaryCreator("folderOne\\dictionary.txt");
        TreeMap<String, String> map =  creater.readDictionary();       
        
        creater.addNewWord("supper", "супер");
        
        Translator t = new Translator(map, from, to);
        t.translate();
        
    }
}
