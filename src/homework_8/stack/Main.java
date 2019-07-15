package homework_8.stack;



/**
 *
 * @author YBolshakova
 */
public class Main {
    public static void main(String[] args) {
        BlackList blackList = new BlackList();
        Stack stack = new Stack(blackList);
        
        String s = "String №";
        Integer integer = 0;
        
        
        blackList.addToBlackList(integer);
        
        for(int i=0; i<5; i++){
          stack.addToStack(s + "_i");  
        }
        
        stack.addToStack(integer);
        
        stack.removeFromStack();
        stack.removeFromStack();
        stack.removeFromStack();
        stack.removeFromStack();
        stack.removeFromStack();
        stack.removeFromStack();
        stack.removeFromStack();
        stack.removeFromStack();
        
        Object ob = stack.peekFromStack();
        ob = ob.getClass();
        System.out.println("Class = " + ob.getClass());
        
        
        
                
       
    }

}
