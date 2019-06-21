package homework_3;

import javax.swing.JOptionPane;
import jdk.nashorn.internal.ir.BreakNode;

/**
 *
 * @author YBolshakova
 */
public class Dialog {

    private String stringRegex = "[A-Z][a-z]*";
    private String numberRehex = "^[0-9]*$";

    public Dialog() {

    }

    public Student createStudent() throws ClickCancelException {
        Student s = new Student();

        s.setName(inputName());
        s.setLastname(inputLastname());
        s.setAge(inputAge());
        s.setHeight(inputHeight());
        s.setWeight(inputWeight());
        s.setSex(inputSex());
        s.setIdentificationCode(s.createIdentifier());

        return s;
    }

    public String inputName() throws ClickCancelException {
        String name = "";
        try {
            name = getData(stringRegex, "name");
        } catch (NotValidDataException e) {
            int select = JOptionPane.showConfirmDialog(null, "Eneted data is not correct. Do you want try again?", "Try again", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (select == JOptionPane.NO_OPTION) {
                throw new ClickCancelException();
            } else {
                inputName();
            }
        }
        return name;
    }

    public String inputLastname() throws ClickCancelException {
        String lastName = "";
        try {
            lastName = getData(stringRegex, "lastName");
        } catch (NotValidDataException e) {
            int select = JOptionPane.showConfirmDialog(null, "Eneted data is not correct. Do you want try again?", "Try again", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (select == JOptionPane.NO_OPTION) {
                throw new ClickCancelException();
            } else {
                inputLastname();
            }
        }
        return lastName;

    }

    public int inputAge() throws ClickCancelException {
        int age = 0;
        try {
            age = Integer.valueOf(getData(numberRehex, "age"));
        } catch (NotValidDataException e) {
            int select = JOptionPane.showConfirmDialog(null, "Eneted data is not correct. Do you want try again?", "Try again", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (select == JOptionPane.NO_OPTION) {
                throw new ClickCancelException();
            } else {
                inputAge();
            }
        }

        return age;
    }

    public int inputHeight() throws ClickCancelException {
        int height = 0;
        try {
            height = Integer.valueOf(getData(numberRehex, "height"));
        } catch (NotValidDataException e) {
            int select = JOptionPane.showConfirmDialog(null, "Eneted data is not correct. Do you want try again?", "Try again", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (select == JOptionPane.NO_OPTION) {
                throw new ClickCancelException();
            } else {
                inputHeight();
            }
        }
        return height;
    }

    public int inputWeight() throws ClickCancelException {
        int weight = 0;
        try {
            Integer.valueOf(getData(numberRehex, "weight"));
        } catch (NotValidDataException e) {
            int select = JOptionPane.showConfirmDialog(null, "Eneted data is not correct. Do you want try again?", "Try again", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (select == JOptionPane.NO_OPTION) {
                throw new ClickCancelException();
            } else {
                inputWeight();
            }
        }
        return weight;
    }

    public boolean inputSex() throws ClickCancelException, NotValidDataException {
        String[] genderValues = {"Female", "Male"};
        String sex = (String) JOptionPane.showInputDialog(null, "Select student sex ", "sex", JOptionPane.PLAIN_MESSAGE, null, genderValues, null);
        if (sex.equals("Female")) {
            return true;
        }
        return false;
    }

    public String getData(String regex, String value) {
        String data = (String) JOptionPane.showInputDialog("Populate field with student " + value);
        if (data == null) {
            throw new ClickCancelException();
        }
        data = data.trim();
        if (!data.matches(regex)) {
            throw new NotValidDataException();
        }
        return data;
    }

    public void showmessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

}
