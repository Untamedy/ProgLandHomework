package homework_3;

import javax.swing.JOptionPane;

/**
 *
 * @author YBolshakova
 */
public class NotValidDataException extends RuntimeException {

    public int getSelectResult() {
        int select = JOptionPane.showConfirmDialog(null, "Eneted data is not correct. Do you want try again?", "Try again", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        return select;
    }

}
