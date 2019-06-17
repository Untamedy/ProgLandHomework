package homework_3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.logging.Logger;

/**
 *
 * @author YBolshakova
 */
public class Group {

    Logger logger = Logger.getLogger(Group.class.getName());
    private int id = 1;

    private Student[] students = new Student[10];

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        try {
            if (id > 10) {
                throw new MyOwnException();
            }
            for (int i = 0; i < students.length; i++) {
                if (students[i] == null) {
                    students[i] = student;
                    id++;
                    logger.info("Student " + student.getLastname() + " added successful");
                    break;
                }
            }

        } catch (MyOwnException e) {
            logger.warning(e.getMessage());
        }
    }

    public void removeStudent(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (null != students[i] && students[i].equals(student)) {
                students[i] = null;
                logger.info("Student " + student.getLastname() + " removed successful");
            }
        }
    }

    public Student findStudent(String lastname) {
        for (int i = 0; i < students.length; i++) {
            if (null != students[i] && students[i].getLastname().equals(lastname)) {
                return students[i];
            }

        }
        throw new RuntimeException("Student " + lastname + " is not found");
    }

    @Override
    public String toString() {
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (s1 == null && s2 == null) {
                    return 0;// no swap needed
                }
                if (s1 == null) {
                    return 1;// null is bigger, swap left with right
                }
                if (s2 == null) {
                    return -1;
                }
                return s1.getLastname().compareTo(s2.getLastname());
            }
        });
        StringBuilder studentsAfterSort = new StringBuilder();
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                studentsAfterSort.append("\n" + students[i].info());
            }
        }
        return studentsAfterSort.toString();

    }
}