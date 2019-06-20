package homework_3;

import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author YBolshakova
 */
public class Student extends Human {

    private String name;
    private String lastname;
    private String identificationCode;

    public Student() {
    }

    public Student(int height, int weight, int age, boolean sex, String name, String lastname, String code) {
        super(height, weight, age, sex);
        this.name = name;
        this.lastname = lastname;
        this.identificationCode = code;
                
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

    public String getIdentificationCode() {
        return identificationCode;
    }

    public void setIdentificationCode(String identificationCode) {
        this.identificationCode = identificationCode;
    }
    
    
    public String createIdentifier() {
        String identifier = UUID.randomUUID().toString();
        return identifier;
    }

    @Override
    public String toString() {
        return "Student{lastname =" + lastname + ", name=" + name + " height=" + this.height + ", weight=" + this.weight + ", age=" + this.age + "}";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.lastname);
        hash = 79 * hash + Objects.hashCode(this.identificationCode);
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
        if (!Objects.equals(this.identificationCode, other.identificationCode)) {
            return false;
        }
        return true;
    }

    

}
