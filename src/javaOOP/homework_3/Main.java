package javaOOP.homework_3;

import java.io.File;
import java.util.List;

/**
 *
 * @author YBolshakova
 */
public class Main {

    public static void main(String[] args) {

        Dialog d = new Dialog();
        Group groupOfStudents = new Group();

        for (int i = 0; i < 12; i++) {
            try {
                groupOfStudents.addNewStudent(d);
            } catch (MyOwnException e) {
                e.showWarming();
                System.out.println(e.getMessage());
                break;
            }
        }
        try {
            System.out.println(groupOfStudents.resultToString(groupOfStudents.sortByLastname()));
            System.out.println(groupOfStudents.findStudent("Honor").toString());
            System.out.println("********");
            System.out.println(groupOfStudents.resultToString(groupOfStudents.selectStudentsByAge(18, false)));
            System.out.println("********");

            System.out.println(groupOfStudents.resultToString(groupOfStudents.sortByParameter()));
        } catch (ClickCancelException e) {
            System.out.println(e.getMessage());
        } catch (MyOwnException e) {
            e.showWarming();
            System.out.println(e.getMessage());
        }

        groupOfStudents.saveToFile("students.txt");
        List<Group> list = groupOfStudents.readFromFile("students.txt");
        list.stream().map((g) -> g.getStudents()).forEachOrdered((List<Student> ss) -> {
            System.out.println("*****");
            for(Student s:ss){
                if(s!=null){
                System.out.println(s.toString());
                }
            }
        });
        

    }

}
