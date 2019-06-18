package homework_3;

/**
 *
 * @author YBolshakova
 */
public class Main {

    public static void main(String[] args) {
        Student s1 = new Student(175, 67, 18, "Jack", "Wood");
        Student s2 = new Student(185, 77, 19, "Alan", "Geers");
        Student s3 = new Student(185, 77, 19, "Rick", "Honor");
        Student s4 = new Student(185, 77, 19, "Rick", "Allard");

        Group groupOfStudents = new Group();

        groupOfStudents.addStudent(s1);
        groupOfStudents.addStudent(s2);
        groupOfStudents.addStudent(s3);
        groupOfStudents.addStudent(s1);
        groupOfStudents.addStudent(s2);
        groupOfStudents.addStudent(s4);
        groupOfStudents.addStudent(s3);
        groupOfStudents.addStudent(s4);
        groupOfStudents.addStudent(s1);
        groupOfStudents.addStudent(s3);

        groupOfStudents.addStudent(s3);
        groupOfStudents.addStudent(s4);
        groupOfStudents.addStudent(s3);

        System.out.println(groupOfStudents.toString());

        System.out.println("\n Finded student: " + groupOfStudents.findStudent("Allard").toString());        

        groupOfStudents.removeStudent(s3);
        System.out.println("***Afre remote***\n" + groupOfStudents.toString());        
        
    }

}
