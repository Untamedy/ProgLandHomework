package javaOOP.homework_9.charCounter;

import java.util.Map;
import java.util.Set;

/**
 *
 * @author YBolshakova
 */
public class Main {

    public static void main(String[] args) {
        String path = "folderOne_copy\\Document.txt";

        Counter counter = new Counter(path);
        Map<Character, Integer> counterResult = counter.countCharacters();
        System.out.println(counterResult);

        Set<Character> keys = counterResult.keySet();
        for (Character k : keys) {
            System.out.println(k + "=" + counterResult.get(k) * 100.0 / counter.getCharacters().size() + "%");
        }

    }

}
