package javaOOP.homework_1.part_1;

/**
 *
 * @author YBolshakova
 */
public class Cat {
    
    private String name;
    private int age;
    private String color;
    
    public Cat(){
        
    }
    
    public Cat(String name, int age, String color){
        this.age=age;
        this.color=color;
        this.name=name;
    }
    
    public String getName(){
        return name;
    }
    
    public String getColor(){
        return color;
    }

    public int getAge() {
        return age;
    }  

    public void setAge(int age) {
        this.age = age;
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    public void setColor(String color){
        this.color=color;
    }
    
    public void figthWith(Cat cat){
        System.out.println("Cat with name " + this.name+ " jumped to cat " + cat.getName());
    }
    
    public void changeColor(String newColor){
        setColor(newColor);
        System.out.println("Cat with name " + this.name + " change color to " + this.color);
    }
    
    public void calculateAge(){
        int newAge =  (int) (Math.random()*100);
        setAge(newAge);
        System.out.println("Cat with name " +this.getName() + " think than it age is " + this.getAge() + " years old");
    }

}
