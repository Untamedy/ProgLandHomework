package homework_3;

import java.util.List;

/**
 *
 * @author YBolshakova
 */
public interface MilitaryRegistration {
    
    public List<Student> selectStudentsByAge(int age, boolean sex);

}
