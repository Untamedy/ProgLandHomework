package homework_8.base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author YBolshakova
 */
public class Main {

    public static void main(String[] args) {

        List<Student> abiturients = createListOfAbiturients("C:\\Users\\YBolshakova\\Documents\\gs-maven\\Homework\\folderOne\\Students.txt");

        Faculty faculty = new Faculty();

        faculty.createFaculty(abiturients,1);
        faculty.addToBase("C:\\Users\\YBolshakova\\Documents\\gs-maven\\Homework\\folderOne\\GroupBase.txt");
        List<GroupOfStudent> groupOfStudents = faculty.readFromBase("C:\\Users\\YBolshakova\\Documents\\gs-maven\\Homework\\folderOne\\GroupBase.txt");
        
        for (GroupOfStudent groupOfStudent : groupOfStudents) {
            System.out.println(groupOfStudent.toString());
            
        }
    }

    public static List<Student> createListOfAbiturients(String path) {
        List<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = "";
            boolean flag = false;
            for (; (line = reader.readLine()) != null;) {
                if (!flag) {
                    flag = true;
                    continue;
                }
                String[] studentsAttributs = line.split(",");
                Student s = new Student(studentsAttributs);
                students.add(s);
            }
        } catch (IOException ex) {
        }
        return students;
    }

}
