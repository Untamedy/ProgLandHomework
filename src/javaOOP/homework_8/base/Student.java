package javaOOP.homework_8.base;

import java.io.Serializable;

/**
 *
 * @author YBolshakova
 */
public class Student implements Serializable {

    private int age;
    private String name;
    private String lastname;
    private int groupNumber;  
    

    public Student (){   

    }
    
    public Student(int age, String name, String lastname){
        this.age = age;
        this.name = name;
        this.lastname = lastname;        
    }  
    
    public Student(String [] attributes){
        this.age = Integer.valueOf(attributes[0]);
        this.name = attributes[1];
        this.lastname= attributes[2];        
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    @Override
    public String toString() {
        return "Student{" + "age=" + age + ", name=" + name + ", lastname=" + lastname + ", groupNumber=" + groupNumber + '}';
    }
    
    
    
    
    
    

}
