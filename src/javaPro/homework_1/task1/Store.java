package javaPro.homework_1.task1;


/**
 *
 * @author YBolshakova
 */
public class Store {

    public Store() {
    }
    
    @MyAnnotation(expected = 10, actualy = 13 )
    public static String balance(int expected, int actualy){
        int result = actualy-expected;        
        return (actualy-expected>=0) ? "Positive balance = " + result:"Negative balance = "+result;        
    }
   

}
