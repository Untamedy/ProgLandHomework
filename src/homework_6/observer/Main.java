package homework_6.observer;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author YBolshakova
 */
public class Main {

    public static void main(String[] args) {       
        
        String path = "folderOne\\";
        
        Observer ob = new Observer(path, () -> {
            JOptionPane.showMessageDialog(null, "Data in the folder: \" " + path + "\" is chenged");
        });
        
        ob.start();
        try {
            ob.getWorker().join(60000);
            ob.stop();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
