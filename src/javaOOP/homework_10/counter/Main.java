package javaOOP.homework_10.counter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author YBolshakova
 */
public class Main {

    public static void main(String[] args) {      

        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("one");
        list.add("two");
        list.add("foure");
        list.add("three");
        list.add("five");
        
        List<Boolean> listBoolean = new ArrayList<>();
        listBoolean.add(Boolean.TRUE);
        listBoolean.add(Boolean.FALSE);
        listBoolean.add(Boolean.TRUE);
        listBoolean.add(Boolean.FALSE);
        listBoolean.add(Boolean.TRUE);
        listBoolean.add(Boolean.FALSE);
        listBoolean.add(Boolean.TRUE);
        listBoolean.add(Boolean.FALSE);

        ObjectsCounter counter = new ObjectsCounter();
        Map<Character, Integer> counterStringResult = counter.count(list);
        System.out.println(counterStringResult);        
      
        Map<Character, Integer> counterBoolResult = counter.count(listBoolean);
        System.out.println(counterBoolResult);
        
        
    }
}
