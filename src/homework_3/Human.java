package homework_3;

/**
 *
 * @author YBolshakova
 */
public class Human {

    protected int height;
    protected int weight;
    protected int age;
    protected boolean sex;

    public Human() {
    }

    public Human(int height, int weight, int age, boolean sex) {
        this.sex=sex;
        this.height = height;
        this.weight = weight;
        this.age = age;

    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
    
    

    
    @Override
    public String toString() {
        return "Human{" + "height=" + height + ", weight=" + weight + ", age=" + age + '}';
    }
    
    

}
