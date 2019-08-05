package javaPro.homework_1.task3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author YBolshakova
 */
public class Cat implements Serializable {

    public static final Logger LOGGER = Logger.getLogger(Cat.class.getName());

    @Save
    private int age;
    @Save
    private boolean sex;
    private String color;
    @Save
    private String name;
    private String favoriteMeal;
    private String favoritetoy;

    public Cat() {

    }

    public Cat(int age, boolean sex, String color, String name, String favoriteMeal, String favoritetoy) {
        this.age = age;
        this.color = color;
        this.name = name;
        this.sex = sex;
        this.favoriteMeal = favoriteMeal;
        this.favoritetoy = favoritetoy;
    }    


    public static void mappedToFile(Cat cat, String path) {
        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(path))) {
            List<Object> annotatedFields = new ArrayList<>();
            Class clazz = cat.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field f : fields) {
                if (f.isAnnotationPresent(Save.class)) {
                    Object fieldValue = f.get(cat);
                    annotatedFields.add(fieldValue);
                }
            }
            writer.writeObject(annotatedFields);
        } catch (IOException | IllegalArgumentException | IllegalAccessException ex) {
            LOGGER.warning(ex.getMessage());
        }
    }

    public static List<Object> mappedToCat(String path) {
        List<Object> fields = new ArrayList<>();
        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(path))) {
            fields = (List<Object>) reader.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            LOGGER.warning(ex.getMessage());
        }
        return fields;
    }

}
