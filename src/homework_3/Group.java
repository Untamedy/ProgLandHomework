package homework_3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
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

    private int groupCountr = 1;

    private Student[] students = new Student[10];

    public Group() {
    }

    public Group(Student[] newGroupOfStudents) {
        this.students = newGroupOfStudents;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public void addNewStudent(Dialog dialog) {
        if (groupCountr > students.length) {
            throw new MyOwnException();
        }
        Student s = null;
        while (s == null) {
            try {
                s = dialog.createStudent();
            } catch (ClickCancelException e) {
                if (e.getSelectResult() == JOptionPane.YES_OPTION) {
                    break;
                }
                System.out.println(e.getMessage());
            }
        }
        if (s != null) {
            addStudentToArray(s, students);
            groupCountr++;
        }
    }

    public void addStudentToArray(Student student, Student[] s) {
        for (int i = 0; i < s.length; i++) {
            if (s[i] == null) {
                s[i] = student;
                logger.log(Level.INFO, "Student {0} added successful", student.getLastname());
                break;
            }
        }

    }

    public void removeStudent(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (null != students[i] && students[i].equals(student)) {
                students[i] = null;
                groupCountr--;
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
        return resultToString(students);
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

    public Student[] sortByParameter() {
        boolean isRevers = selectSortType();
        Map<String, Comparator<Student>> comparatorMap = Sorter.createComporatorMap(isRevers);
        String[] parameters = {"Name", "Lastname", "Age", "Height", "Weight", "Sex"};

        String sort = (String) JOptionPane.showInputDialog(null, "Select parameter for sort", "Sort by parameter", JOptionPane.PLAIN_MESSAGE, null, parameters, null);

        if (sort == null) {
            throw new ClickCancelException();
        }
        Comparator<Student> comparator = comparatorMap.get(sort);
        if (comparator != null) {
            Arrays.sort(students, comparator);
        } else {
            return students;
        }
        return students;
    }

    @Override
    public Student[] selectStudentsByAge(int age, boolean sex) {
        Student[] studentsForArmy = new Student[10];
        for (Student s : students) {
            if (s != null) {
                if ((s.getAge() > 18) && (!s.isSex())) {
                    addStudentToArray(s, studentsForArmy);
                }
            }
        }
        return studentsForArmy;
    }

    public String resultToString(Student[] studentsArray) {
        StringBuilder studentsAfterSort = new StringBuilder();
        for (Student student : studentsArray) {
            if (student != null) {
                studentsAfterSort.append("\n").append(student.toString());
            }
        }
        return studentsAfterSort.toString();
    }

    public boolean selectSortType() {
        String[] parameters = {"ASC", "DESC"};
        String sort = (String) JOptionPane.showInputDialog(null, "Select parameter for sort", "Sort by parameter", JOptionPane.PLAIN_MESSAGE, null, parameters, null);
        return sort.equals("DESC");
    }

    public void saveToFile(String path) {
        File f = new File(path);
        try (PrintWriter print = new PrintWriter(f)) {
            print.println("Lastname,Name,Height,Weight,Age,Sex");
            for (Student s : students) {
                if (s != null) {
                    print.println(s.toCSV());
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Group> readFromFile(String path) {
        List<Group> faculty = new ArrayList<>();
        Student[] group = new Student[10];
        int counter = 1;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = "";
            boolean flag = false;
            for (; (line = reader.readLine()) != null;) {
                if (!flag) {
                    flag = true;
                    continue;
                }
                if (counter < 10) {
                    String[] studentsAttributs = line.split(",");
                    Student s = new Student(studentsAttributs);
                    addStudentToArray(s, group);
                    counter++;
                } else {
                    faculty.add(new Group(group));
                    counter = 0;
                    group = new Student[10];
                }
            }
            faculty.add(new Group(group));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return faculty;
    }

}
