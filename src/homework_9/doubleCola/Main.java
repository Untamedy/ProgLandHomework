package homework_9.doubleCola;



/**
 *
 * @author YBolshakova
 */
public class Main {
    public static void main(String[] args) {
           ColaMachine colaMachine = new ColaMachine(5);
           
           System.out.println("Queue befor:"); 
          for(ColaMachine.Human h: colaMachine.getQueueByCola()){
              System.out.println(h.toString());
              
          }
          System.out.println("Queue after :"); 
          for(ColaMachine.Human h: colaMachine.giveCola()){
              System.out.println(h.toString());
              
          }
    }
 
    

}
