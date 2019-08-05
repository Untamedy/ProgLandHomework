package javaPro.homework_1.task3;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YBolshakova
 */
public class Main {

    public static void main(String[] args) {

        String path = "folderOne\\Cat.txt";
        Cat cat = new Cat(3, true, "Black", "Boris", "meat", "ball");

        Cat.mappedToFile(cat, path);
        List<Object> list = Cat.mappedToCat(path);
        list.forEach(l->System.out.println(l));
    }

}
