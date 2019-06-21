package homework_3;

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

        System.out.println(groupOfStudents.resultToString(groupOfStudents.sortByLastname()));
        System.out.println(groupOfStudents.findStudent("Honor").toString());
        System.out.println("********");
        System.out.println(groupOfStudents.resultToString(groupOfStudents.selectStudentsByAge(18, false)));
        System.out.println("********");
        try {
            System.out.println(groupOfStudents.resultToString(groupOfStudents.sortByParameter()));
        } catch (ClickCancelException e) {
            System.out.println(e.getMessage());
        }

    }

}
