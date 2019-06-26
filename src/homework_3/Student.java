package homework_3;

import java.util.Objects;

/**
 *
 * @author YBolshakova
 */
public class Student extends Human {

    private String name;
    private String lastname;    

    public Student() {
    }

    public Student(int height, int weight, int age, boolean sex, String name, String lastname, String code) {
        super(height, weight, age, sex);
        this.name = name;
        this.lastname = lastname;      
    }

    public Student(String[] attr) {
        super(Integer.valueOf(attr[2]),Integer.valueOf(attr[3]),Integer.valueOf(attr[4]),attr[5].equals("female"));
        this.lastname = attr[0];
        this.name=attr[1];  
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
    public String toString() {
        boolean sex = this.sex;
        String s = "";
        if (sex) {
            s = "female";
        } else {
            s = "male";
        }
        return "Student{lastname =" + lastname + ", name=" + name + " height=" + this.height + ", weight=" + this.weight + ", age=" + this.age + ", sex =" + s + "}";
    }
    
    public String toCSV(){
        boolean sex = this.sex;
        String s = "";
        if (sex) {
            s = "female";
        } else {
            s = "male";
        }        
        return lastname + ","+ name + "," + this.height + "," + this.weight + "," + this.age + "," + s ;
        
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.lastname);       
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        
        return true;
    }

}
