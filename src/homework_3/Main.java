package homework_3;

/**
 *
 * @author YBolshakova
 */
public class Main {

    public static void main(String[] args) {
        Student s1 = new Student(175, 67, 18, true, "Jack", "Wood", "123546589");
        Student s2 = new Student(185, 77, 19, true, "Alan", "Geers", "gt54538002");
        Student s3 = new Student(185, 77, 19, false, "Ricky", "Honor", "rfr5797943");
        Student s4 = new Student(185, 77, 19, true, "Rick", "Allard", "gjt4947676g");

        Dialog d = new Dialog();

        Group groupOfStudents = new Group();
        groupOfStudents.addNewStudent(d);
        

    }

}
