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

    public Student createStudent() throws ClickCancelException,NotValidDataException {
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

    public String inputName() throws ClickCancelException,NotValidDataException {
        String name = getData(stringRegex, "name");
        return name;
    }

    public String inputLastname() throws ClickCancelException {
        String lastName = getData(stringRegex, "lastName");
        return lastName;

    }

    public int inputAge() throws ClickCancelException,NotValidDataException {
        int age = Integer.valueOf(getData(numberRehex, "age"));
        return age;
    }

    public int inputHeight() throws ClickCancelException {
        int height = Integer.valueOf(getData(numberRehex, "height"));
        return height;
    }

    public int inputWeight() throws ClickCancelException,NotValidDataException {
        int weight = Integer.valueOf(getData(numberRehex, "weight"));
        return weight;
    }

    public boolean inputSex() throws ClickCancelException,NotValidDataException {
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
        if (data.matches(regex)) {
            return data;
        }
        throw new NotValidDataException();
    }

    public void showmessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

}
