package homework_3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author YBolshakova
 */
public class Group implements MilitaryRegistration {

    Logger logger = Logger.getLogger(Group.class.getName());

    private int id = 1;

    private Student[] students = new Student[10];

    public Group() {
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public void addNewStudent(Dialog dialog) {
        Student s = null;
        while (s == null) {
            try {
                s = dialog.createStudent();
            } catch (ClickCancelException e) {
                int select = JOptionPane.showConfirmDialog(null, "Do you want to cancel adding a student?", "Cancel", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if (select == JOptionPane.YES_OPTION) {
                    break;
                }
                System.out.println(e.getMessage());
            }
        }
        if (s != null) {
            addStudent(s);
        }
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
                    logger.log(Level.INFO, "Student {0} added successful", student.getLastname());
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
                id--;
                logger.log(Level.INFO, "Student {0} removed successful", student.getLastname());
            }
        }
    }

    public Optional<Student> findStudent(String lastname) {
        for (Student student : students) {
            if (null != student && student.getLastname().equals(lastname)) {
                return Optional.of(student);
            }
        }
        return Optional.empty();
    }

    @Override
    public String toString() {
        students = sortByLastname();
        StringBuilder studentsAfterSort = new StringBuilder();
        for (Student student : students) {
            if (student != null) {
                studentsAfterSort.append("\n").append(student.toString());
            }
        }
        return studentsAfterSort.toString();

    }

    public Student[] sortByLastname() {
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (s1 == null && s2 == null) {
                    return 0;
                }
                if (s1 == null) {
                    return 1;
                }
                if (s2 == null) {
                    return -1;
                }
                return s1.getLastname().compareTo(s2.getLastname());
            }
        });

        return students;
    }

    public Student[] sortByParameter(String parameter) {
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (s1 == null && s2 == null) {
                    return 0;
                }
                if (s1 == null) {
                    return 1;
                }
                if (s2 == null) {
                    return -1;
                }
                if(parameter.equals("name")){
                    return s1.getName().compareTo(s2.getName());
                }
                if(parameter.equals("lastname")){
                    return s1.getLastname().compareTo(s2.getLastname());
                }
                if(parameter.equals("age")){
                    Integer a = s1.getAge();
                    Integer b = s2.getAge();
                    return (a.compareTo(b));
                }
                
                return s1.getLastname().compareTo(s2.getLastname());
            }
        });
        return students;

    }

    @Override
    public Student[] selectStudentsByAge(int age, boolean sex) {
        return null;
    }

    public String getData() {
        return null;

    }

}
