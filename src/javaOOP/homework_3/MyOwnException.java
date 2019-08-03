package javaOOP.homework_3;

import javax.swing.JOptionPane;

/**
 *
 * @author YBolshakova
 */
public class MyOwnException extends RuntimeException{
    
    @Override
    public String getMessage(){        
        return "You tried to add more students than this array can contain.";        
    }
    
    public void showWarming(){
        JOptionPane.showMessageDialog(null, "You tried to add more students than this array can contain.");
    }

}
