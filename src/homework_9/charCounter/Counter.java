package homework_9.charCounter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author YBolshakova
 */
public class Counter {

    private String path;
    private List<Character> characters;
    private Map<Character, Integer> result;

    public Counter() {

    }

    public Counter(String path) {
        this.path = path;
    }

    public Map<Character, Integer> countCharacters() {
        read();
        Map<Character, Integer> mapOfresults = count();
        return sortByValues(mapOfresults);
    }

    public void read() {
        characters = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            int symbol;
            while ((symbol = reader.read()) != -1) {
                if (Character.isAlphabetic(symbol)) {
                    char ch = (char) symbol;
                    characters.add(Character.toLowerCase(ch));
                }
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public Map<Character, Integer> count() {
        result = new HashMap<>();
        int countResult = 0;
        for (Character c : characters) {
            Character tmp = c;
            Iterator<Character> iterator = characters.iterator();
            while (iterator.hasNext()) {
                if (result.containsKey(tmp)) {
                    break;
                }
                c = iterator.next();
                if (c.equals(tmp)) {
                    countResult++;
                }
            }
            result.putIfAbsent(tmp, countResult);
            countResult = 0;
        }
        return result;
    }

    public static <K, V extends Comparable<V>> Map<K, V> sortByValues(Map<K, V> map) {
        Comparator<K> valueComparator = new Comparator<K>() {
            @Override
            public int compare(K o1, K o2) {
                int compare = map.get(o2).compareTo(map.get(o1));
                if (compare == 0) {
                    return -1;
                } else {
                    return compare * -1;
                }
            }
        };
        Map<K, V> sortByvalue = new TreeMap<K, V>(valueComparator);
        sortByvalue.putAll(map);
        return sortByvalue;

    }

}
