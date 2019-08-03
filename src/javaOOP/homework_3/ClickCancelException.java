package javaOOP.homework_3;

import javax.swing.JOptionPane;

/**
 *
 * @author YBolshakova
 */
public class ClickCancelException extends RuntimeException {

    @Override
    public String getMessage() {
        return "You canceled the current action.";

    }

    public int getSelectResult() {
        int select = JOptionPane.showConfirmDialog(null, "Do you want to cancel adding a student?", "Cancel", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        return select;
    }

}
