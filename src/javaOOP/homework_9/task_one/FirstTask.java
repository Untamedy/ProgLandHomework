package javaOOP.homework_9.task_one;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author YBolshakova
 */
public class FirstTask {

    private List<String> list;

    public FirstTask() {

    }

    public List<String> getList() {
        return list;
    }

    public void modifyList() {
        List<String> modifiedList = new ArrayList<>();
        addToList();
        System.out.println("Befor modification: " + list);
        modifiedList = list.subList(2, list.size() - 1);
        System.out.println("After modification: " + modifiedList);

    }

    private void addToList() {
        list = new ArrayList<>();
        String s = "";
        for (int i = 0; i < 10; i++) {
            s = "String №_" + i;
            list.add(s);
        }
    }

}
