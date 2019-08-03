package javaOOP.homework_10.art;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author YBolshakova
 */
public class AlphabetReader {

    private String path;
    private String alphabet;  

    public AlphabetReader() {

    }

    public AlphabetReader(String path, String alphabet) {
        this.path = path;
        this.alphabet = alphabet;
    }

    public HashMap<String, String> mapOfLetters() {
        String[] art = readArtAlphabet();
        String[] letters = letters(alphabet);
        HashMap<String, String> alpHashMap = new HashMap<>();
        for (int i = 0; i < letters.length; i++) {
            alpHashMap.put(letters[i], art[i]);
        }
        return alpHashMap;
    }

    public String[] readArtAlphabet() {
        StringBuffer s = new StringBuffer();
        String[] artLetters = new String[26];
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = "";
            int i = 0;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    s.append(line).append("!");
                } else {
                    artLetters[i] = s.toString();
                    i++;
                    s = new StringBuffer();
                }
            }
            artLetters[i] = s.toString();
        } catch (IOException ex) {
        }
        return artLetters;
    }

    public String[] letters(String alphabet) {
        String[] letters = alphabet.split(",");
        return letters;
    }

}
