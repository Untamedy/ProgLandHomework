package homework_3;

import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author YBolshakova
 */
public class Student extends Human {

    private String name;
    private String lastname;
    private int id;

    public Student() {

    }

    public Student(int height, int weight, int age, String name, String lastname) {
        super(height, weight, age);
        this.name = name;
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String info() {
        return "Student{lastname =" + lastname + ", name=" + name + " height=" + this.height + ", weight=" + this.weight + ", age=" + this.age + "}";
    }

    

}
