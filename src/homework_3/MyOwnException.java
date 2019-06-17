package homework_3;

/**
 *
 * @author YBolshakova
 */
public class MyOwnException extends RuntimeException{
    
    @Override
    public String getMessage(){
        return "You tried to add more students than this array can contain.";
        
    }

}
