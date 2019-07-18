package homework_10.art;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author YBolshakova
 */
public class WordDrawing {

    private AlphabetReader reader;

    public WordDrawing() {
    }

    public WordDrawing(AlphabetReader reader) {
        this.reader = reader;
    }
   

    public void draw(String word) {
        List<String> letters = convert(word);
        String[] toPrint = new String[16];
        boolean firstLetter = true;
        for (String s : letters) {
            String[] str = s.split("!");
            int i = 0;
            for (String string : str) {
                if (!firstLetter) {
                    toPrint[i] += string;
                    i++;
                } else {
                    toPrint[i] = "";
                    toPrint[i] += string;
                    i++;
                }
            }
           firstLetter = false;
        }
        for (String string : toPrint) {
             System.out.println(string);
        }
       
    }

    public List<String> convert(String word) {
        HashMap<String, String> alphabet = reader.mapOfLetters();
        List<String> artWord = new LinkedList<>();
        char[] character = word.toCharArray();
        for (char c : character) {
            String symbol = String.valueOf(Character.toUpperCase(c));
            symbol = symbol.trim();
            if (alphabet.containsKey(symbol)) {
                String artChar = alphabet.get(symbol);
                artWord.add(artChar);
            }
        }
        return artWord;
    }

   
}
