package homework_3;

/**
 *
 * @author YBolshakova
 */
public class ClickCancelException extends RuntimeException{
    @Override
    public String getMessage(){
        return "You canceled student addition";
        
    }
    

}
